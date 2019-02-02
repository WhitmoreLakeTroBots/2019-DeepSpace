package org.usfirst.frc3668.DeepSpace.commands;

import edu.wpi.first.wpilibj.command.Command;
import java.lang.System;

public class cmdDelay extends Command {
    boolean bDone = false;
    
    long endTime = 0;
    
    public cmdDelay() {
        // yes set the end time to 1 second ago.
        endTime = System.currentTimeMillis() - 1000;
    }

    public cmdDelay(long mSeconds) {
        endTime = System.currentTimeMillis() + mSeconds;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        bDone = false;
        System.err.println("Adding Delay effect");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        if (System.currentTimeMillis() >= endTime) {
            bDone = true;
        }
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
        bDone = true;
    }
}
