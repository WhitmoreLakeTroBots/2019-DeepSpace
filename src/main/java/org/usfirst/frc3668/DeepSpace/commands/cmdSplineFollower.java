package org.usfirst.frc3668.DeepSpace.commands;

import java.io.File;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.Filesystem;
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
        follower.configureEncoder(Robot.subChassis.getEncoderAvgTic(), Settings.chassisEncoderTicsPerRevolution, Settings.chassisWheelDiameter);
        follower.configurePIDVA(Settings.splineKp, Settings.splineKi, Settings.splineKd, 1/ Settings.maxVelocity, Settings.splineKf );
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
      pointCount ++;
      double output = follower.calculate(Robot.subChassis.getRightEncoderTics()); 
      double heading = Robot.subChassis.getNormaliziedNavxAngle();
      double desiredHeading = Pathfinder.r2d(follower.getHeading());
      double angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - heading);
      double turnVal = Settings.chassisTurnScalar * angleDifference;
      System.err.println(String.format("Right Encoder: %1$d \t Left Encoder: %2$d \t Avg Encoder: %3$d \t Navx: %4$.3f \t dHeading: %5$.3f \t Spline Output: %6$.3f \t PerComp: %7$.3f", Robot.subChassis.getRightEncoderTics(), Robot.subChassis.getLeftEncoderTics(), Robot.subChassis.getEncoderAvgTic(), Robot.subChassis.getNormaliziedNavxAngle(), desiredHeading, output, percentComplete()));
      Robot.subChassis.DriveMan(output - turnVal, output + turnVal);
    }

    protected double percentComplete (){
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
