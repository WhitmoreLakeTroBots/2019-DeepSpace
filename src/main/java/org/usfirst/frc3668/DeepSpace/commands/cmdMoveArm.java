package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.OI;
import org.usfirst.frc3668.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class cmdMoveArm extends Command {
    double angle;
    public cmdMoveArm(String requestedAngle) {
        angle = Double.valueOf(requestedAngle);
           // requires(Robot.subChassis);
        }
    
        // Called just before this Command runs the first time
        @Override
        protected void initialize() {
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