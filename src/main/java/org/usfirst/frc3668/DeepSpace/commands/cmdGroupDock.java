package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.RobotMath;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupDock extends CommandGroup {
    public cmdGroupDock() {
        double horzAngle = Robot.tx.getDouble(0);
        double absoluteHeading = Robot.subChassis.getNormaliziedNavxAngle() + Robot.tx.getDouble(0);
        double dist = RobotMath.calcLimeDist(Robot.ty.getDouble(0));
        System.err.println(String.format("Limelight Data; Angle: %1$.3f \t Dist: %2$.3f", horzAngle, dist));
        addSequential(new cmdTurnGyro(Settings.autoTurnSpeed, absoluteHeading));
        addSequential(
                new cmdProfileDrive(horzAngle, Settings.autoProfileDriveSpeed, dist));
    }
}
