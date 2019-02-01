package org.usfirst.frc3668.DeepSpace.commands;

import edu.wpi.first.wpilibj.command.Command;
import java.lang.System;

public class cmdLiftDrive extends Command {
    boolean bDone = false;
    
    public cmdLiftDrive() {
    }

    public cmdLiftDrive(long mSeconds) {
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        bDone = false;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return bDone;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}