package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class cmdSetCargoOffset extends Command {
    double offset = 0;
    boolean isFinished = false;
    boolean adjust = false;
    double adjustment = 0;

    public cmdSetCargoOffset(double offset){
        this.offset = offset;
    }

    public cmdSetCargoOffset(double adjustment, boolean adjust){
        this.adjustment = adjustment;
        this.adjust = adjust;
    }
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        System.err.println("Head offset set to " + offset + " POV: " + Robot.oi.joyDrive.getPOV());
        if(adjust){
            Robot.headHoldAngle = Robot.headHoldAngle + adjustment;
        } else {
            Robot.headHoldAngle = offset;
        }
        isFinished = true;
    }
    
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isFinished;
    }
    
    // Called once after isFinished returns true
    @Override
    protected void end() {
        isFinished = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
