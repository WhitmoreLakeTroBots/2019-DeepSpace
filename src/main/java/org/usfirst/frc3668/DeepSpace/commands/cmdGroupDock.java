package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.RobotMath;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class cmdGroupDock extends CommandGroup {

    public double horzAngle = Robot.tx.getDouble(Settings.llDefaultAngle);
    public double vertAngle = Robot.y;

    public cmdGroupDock() {
        Robot.subChassis.resetNavx();
        SmartDashboard.putNumber("Dock X", horzAngle);
        double absoluteHeading = Robot.subChassis.getNormaliziedNavxAngle() + horzAngle;
        SmartDashboard.putNumber("Abs Heading", absoluteHeading);
        SmartDashboard.putNumber("NavX", Robot.subChassis.getNormaliziedNavxAngle());
        double dist = RobotMath.calcLimeDist(vertAngle);
        
        if (horzAngle <= Settings.llAecseptableAngle && horzAngle >= -Settings.llAecseptableAngle) {
            addSequential(new cmdTurnGyro(Settings.autoTurnSpeed, absoluteHeading));
            // addSequential(new cmdProfileDrive(absoluteHeading, Settings.autoProfileDriveSpeed, dist));
        } else {
            addSequential(new cmdDelay(0));
        }
    }

    @Override
    public synchronized void start() {
        horzAngle = Robot.tx.getDouble(Settings.llDefaultAngle);
        vertAngle = Robot.y;
        super.start();
    }
}