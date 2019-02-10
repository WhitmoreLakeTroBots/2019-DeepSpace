package org.usfirst.frc3668.DeepSpace.commands;

import java.io.File;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class cmdSplineFollowerTrac extends Command {
    double splineLength;
    double turnScalar;
    EncoderFollower leftFollower;
    EncoderFollower rightFollower;
    Trajectory trajectory;
    Trajectory left;
    Trajectory right;
    TankModifier mod;
    File spline;

    int pointCount = 0;
    double trajLen;

    public cmdSplineFollowerTrac(String fileName) {
        spline = new File(fileName);
        trajectory = Pathfinder.readFromCSV(spline);
        trajLen = trajectory.length();
        requires(Robot.subChassis);
        mod = new TankModifier(trajectory);
        mod.modify(Settings.chassisWheelbaseWidth);
        left = mod.getLeftTrajectory();
        right = mod.getRightTrajectory();
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        System.err.println("Starting spline. trajLen: " + trajLen);
        Robot.subChassis.resetBothEncoders();
        leftFollower = new EncoderFollower(left);
        leftFollower.configureEncoder(Robot.subChassis.getLeftEncoderTics(), Settings.chassisEncoderTicsPerRevolution,
                Settings.chassisWheelDiameter);
        leftFollower.configurePIDVA(Settings.splineTracKp, Settings.splineTracKi, Settings.splineTracKd,
                1 / Settings.maxVelocity, Settings.splineTracKf);

        rightFollower = new EncoderFollower(right);
        rightFollower.configureEncoder(Robot.subChassis.getLeftEncoderTics(), Settings.chassisEncoderTicsPerRevolution,
                Settings.chassisWheelDiameter);
        rightFollower.configurePIDVA(Settings.splineTracKp, Settings.splineTracKi, Settings.splineTracKd,
                1 / Settings.maxVelocity, Settings.splineTracKf);

        turnScalar = Settings.splineTracTurnScalar;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        pointCount++;
        double heading = -Robot.subChassis.getNormaliziedNavxAngle();
        double leftOutput = leftFollower.calculate(Robot.subChassis.getLeftEncoderTics());
        double leftDesiredHeading = Robot.subChassis.gyroNormalize(Pathfinder.r2d(leftFollower.getHeading()));
        double leftAngleDifference = Pathfinder.boundHalfDegrees(leftDesiredHeading - heading);
        double leftTurnVal = Robot.invertedSplineDirection * turnScalar * leftAngleDifference;
        double leftThrottle = leftOutput - leftTurnVal;

        double rightOutput = rightFollower.calculate(Robot.subChassis.getRightEncoderTics());
        double rightDesiredHeading = Robot.subChassis.gyroNormalize(Pathfinder.r2d(rightFollower.getHeading()));
        double rightAngleDifference = Pathfinder.boundHalfDegrees(rightDesiredHeading - heading);
        double rightTurnVal = Robot.invertedSplineDirection * turnScalar * rightAngleDifference;
        double rightThrottle = rightOutput + rightTurnVal;

        System.err.println(String.format(
                "PC: %1$d\tRight Encoder: %2$d\tLeft Encoder: %3$d\tNavx: %4$.3f\tR dHeading: %5$.3f\tR Output: %6$.3f\tR throttle: %7$.3f\tL Output: %8$.3f\tL Throttle: %9$.3f\tPerComp: %10$.3f",
                pointCount, Robot.subChassis.getRightEncoderTics(), Robot.subChassis.getLeftEncoderTics(), heading,
                rightDesiredHeading, rightOutput, rightThrottle, leftOutput, leftThrottle, percentComplete()));

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
