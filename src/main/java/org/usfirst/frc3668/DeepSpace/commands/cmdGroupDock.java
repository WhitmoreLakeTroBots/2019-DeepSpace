package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.RobotMath;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

public class cmdGroupDock extends CommandGroup {

    public cmdGroupDock() {
        double horzAngle = Robot.tx.getDouble(0);
        double vertAngle = Robot.ty.getDouble(0);

        double absoluteHeading = Robot.subChassis.getNormaliziedNavxAngle() + Robot.tx.getDouble(0);
        double dist = RobotMath.calcLimeDist(vertAngle);
        System.err.println(String.format(
                "Limelight Data; Horz Angle: %1$.3f \t Abs Heading: %2$.3f \t Vert Angle: %3$.3f \t Dist: %4$.3f",
                horzAngle, absoluteHeading, vertAngle, dist));

        if (vertAngle != 0.0) {
            addSequential(new cmdTurnGyro(Settings.autoTurnSpeed, absoluteHeading));
            addSequential(new cmdProfileDrive(absoluteHeading, Settings.autoProfileDriveSpeed, dist));
        } else {
            System.err.println("We are forced to cancel; vert angle = 0");
            this.cancel();
            Scheduler.getInstance().removeAll();
        }
    }
}
