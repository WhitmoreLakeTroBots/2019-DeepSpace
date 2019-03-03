package org.usfirst.frc3668.DeepSpace.commands;

import java.io.File;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;
 
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class cmdSplineBenderOmni extends Command {

    public final double splineOmniKp = 0.0075;
    public final double splineOmniKi = 0.0055;
    public final double splineOmniKd = 0.00425;
    public final double splineOmniKf = 0.10;
    public final double splineOmniTurnScalar = 0.013;

    double splineLength;
    double turnScalar;
    EncoderFollower leftFollower;
    EncoderFollower rightFollower;
    Trajectory trajectory;
    Trajectory left;
    Trajectory right;
    TankModifier mod;
    File spline;
    double percentThershold;

    int pointCount = 0;
    double trajLen;

    public cmdSplineBenderOmni(String fileName) {
        spline = new File(fileName);
        trajectory = Pathfinder.readFromCSV(spline);
        trajLen = trajectory.length();
        requires(Robot.subChassis);
        mod = new TankModifier(trajectory);
        mod.modify(Settings.chassisWheelbaseWidth);
        left = mod.getLeftTrajectory();
        right = mod.getRightTrajectory();
    }

    public cmdSplineBenderOmni(String fileName, double percentThreshold) {
        this.percentThershold = percentThreshold;
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
        Robot.subChassis.resetBothEncoders();
        leftFollower = new EncoderFollower(left);
        leftFollower.configureEncoder(Robot.subChassis.getLeftEncoderTics(), Settings.magneticEncoderTicsPerRevolution,
                Settings.chassisWheelDiameter);
        leftFollower.configurePIDVA(splineOmniKp, splineOmniKi, splineOmniKd, 1 / Settings.maxVelocity, splineOmniKf);

        rightFollower = new EncoderFollower(right);
        rightFollower.configureEncoder(Robot.subChassis.getLeftEncoderTics(), Settings.magneticEncoderTicsPerRevolution,
                Settings.chassisWheelDiameter);
        rightFollower.configurePIDVA(splineOmniKp, splineOmniKi, splineOmniKd, 1 / Settings.maxVelocity, splineOmniKf);

        turnScalar = splineOmniTurnScalar;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        pointCount++;

        double leftOutput = leftFollower.calculate(Robot.subChassis.getLeftEncoderTics());
        double leftTurnVal = Robot.invertedSplineDirection * turnScalar * leftAngleDifference();
        double leftThrottle = leftOutput - leftTurnVal;

        double rightOutput = rightFollower.calculate(Robot.subChassis.getRightEncoderTics());
        double rightTurnVal = Robot.invertedSplineDirection * turnScalar * rightAngleDifference();
        double rightThrottle = rightOutput + rightTurnVal;

        System.err.println(String.format(
                "PC: %1$d\tRight Encoder: %2$.3f\tLeft Encoder: %3$.3f\tAngle Diff: %4$.3f\tNavX: %5$.3f\tR Output: %6$.3f\tR throttle: %7$.3f\tLL Angle: %8$.3f\tL Throttle: %9$.3f\tPerComp: %10$.3f",
                pointCount, Robot.subChassis.getRightEncoderDist(), Robot.subChassis.getLeftEncoderDist(),
                leftAngleDifference(),
                Robot.subChassis.getNormaliziedNavxAngle(), rightOutput, rightThrottle,
                (Robot.lox.getDouble(Settings.loDefaultAngle) * Settings.loHorzAngleScalar), leftThrottle, percentComplete()));

        Robot.subChassis.DriveMan(leftThrottle, rightThrottle);
    }

    protected double leftAngleDifference() {
        double angleDiff = 0;
        if (Robot.lov.getDouble(0) == 1 && percentComplete() >= percentThershold) {
            angleDiff = -Robot.lox.getDouble(Settings.loDefaultAngle) * Settings.loHorzAngleScalar;
        } else {
            angleDiff = Pathfinder
                    .boundHalfDegrees(Robot.subChassis.gyroNormalize(Pathfinder.r2d(leftFollower.getHeading()))
                            + Robot.subChassis.getNormaliziedNavxAngle());
        }
        return angleDiff;
    }

    protected double rightAngleDifference() {
        double angleDiff = 0;
        if (Robot.lov.getDouble(0) == 1 && percentComplete() >= percentThershold) {
            angleDiff = - Robot.lox.getDouble(Settings.loDefaultAngle) * Settings.loHorzAngleScalar;
        } else {
            angleDiff = Pathfinder
                    .boundHalfDegrees(Robot.subChassis.gyroNormalize(Pathfinder.r2d(rightFollower.getHeading()))
                            + Robot.subChassis.getNormaliziedNavxAngle());
        }
        return angleDiff;
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
