package org.usfirst.frc3668.DeepSpace.commands;

import java.io.File;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

public class cmdSplineFollower extends Command {
    double splineLength;
    EncoderFollower follower;
    Trajectory trajectory;
    File spline;

    int pointCount = 0;
    double trajLen;

    public cmdSplineFollower(String fileName) {
        spline = new File(fileName);
        trajectory = Pathfinder.readFromCSV(spline);
        trajLen = trajectory.length();
        requires(Robot.subChassis);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.subChassis.resetBothEncoders();
        follower = new EncoderFollower(trajectory);
        follower.configureEncoder(Robot.subChassis.getEncoderAvgTic(), Settings.chassisEncoderTicsPerRevolution,
                Settings.chassisWheelDiameter);
        follower.configurePIDVA(Settings.splineKp, Settings.splineKi, Settings.splineKd, 1 / Settings.maxVelocity,
                Settings.splineKf);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        pointCount++;
        double output = follower.calculate(Robot.subChassis.getRightEncoderTics());
        double heading = Robot.subChassis.getNormaliziedNavxAngle();
        double desiredHeading = Pathfinder.r2d(follower.getHeading());
        double angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - heading);
        double turnVal = Settings.splineTurnScalar * angleDifference;
        double rightThrottle = output + turnVal;
        double leftThrottle = output - turnVal;
        System.err.println(String.format(
                "Right Encoder: %1$d\tLeft Encoder: %2$d\tAvg Encoder: %3$d\tNavx: %4$.3f\tdHeading: %5$.3f\tOutput: %6$.3f\tR throttle: %7$.3f\tL Throttle: %8$.3f\tPerComp: %9$.3f",
                Robot.subChassis.getRightEncoderTics(), Robot.subChassis.getLeftEncoderTics(),
                Robot.subChassis.getEncoderAvgTic(), Robot.subChassis.getNormaliziedNavxAngle(), desiredHeading, output,
                rightThrottle, leftThrottle, percentComplete()));
        Robot.subChassis.DriveMan(leftThrottle, rightThrottle);
    }

    protected double percentComplete() {
        return pointCount / trajLen;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return percentComplete() == 1;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.subChassis.DriveMan(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.subChassis.DriveMan(0, 0);
    }
}
