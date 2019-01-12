


package org.usfirst.frc3668.DeepSpace.commands;

import java.io.File;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

public class cmdSplineFollower extends Command {
    EncoderFollower follower;

    public cmdSplineFollower(String fileName) {
        File spline = new File(fileName);
        Trajectory trajectory = Pathfinder.readFromCSV(spline);
        requires(Robot.subChassis);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        follower = new EncoderFollower();
        follower.configureEncoder(Robot.subChassis.getEncoderAvgTic(), Settings.chassisEncoderTicsPerRevolution, Settings.chassisWheelDiameter);
        follower.configurePIDVA(Settings.splineKp, Settings.splineKi, Settings.splineKd, 1/ Settings.maxVelocity, Settings.splineKf );
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
