package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.RobotMath;
import org.usfirst.frc3668.DeepSpace.Settings;
import org.usfirst.frc3668.DeepSpace.commands.*;
import org.usfirst.frc3668.DeepSpace.OI;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupDock extends CommandGroup {

    public cmdGroupDock() {
        double horzAngle = Robot.tx.getDouble(Settings.llDefaultAngle);
        double vertAngle = Robot.ty.getDouble(Settings.llDefaultAngle);

        double absoluteHeading = Robot.subChassis.getNormaliziedNavxAngle() + Robot.tx.getDouble(1.8);
        double dist = RobotMath.calcLimeDist(vertAngle);
        System.err.println(String.format(
                "Limelight Data; Horz Angle: %1$.3f \t Abs Heading: %2$.3f \t Vert Angle: %3$.3f \t Dist: %4$.3f",
                horzAngle, absoluteHeading, vertAngle, dist));

        if (vertAngle != Settings.llDefaultAngle) {
            addSequential(new cmdTurnGyro(Settings.autoTurnSpeed, absoluteHeading));
            addSequential(new cmdProfileDrive(absoluteHeading, Settings.autoProfileDriveSpeed, dist));
            // addSequential(new cmdTurnGyro(Settings.autoTurnSpeed,90));
            

        } else {
            addSequential(new cmdDelay(0));
            System.err.println("Im working");
            // addSequential(new cmdGroupDelay(Settings.delayMiliseconds));;
            /*
             * System.err.println("We are forced to cancel; vert angle = 0"); this.cancel();
             * Scheduler.getInstance().removeAll();
             */
        }
    }
}
