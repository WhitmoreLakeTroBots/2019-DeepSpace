package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class cmdHeadCargo extends Command {
    boolean bDone = false;
    double throttle;
    long mSec = -1;
    long endTime;
    
    public cmdHeadCargo(double throttle) {
        this.throttle = throttle;
        requires(Robot.subIntake);
    }

    public cmdHeadCargo(double throttle, long mSec){
        this.throttle = throttle;
        this.mSec = mSec;
    }
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        bDone = false;
        if(mSec > 0){
            endTime = System.currentTimeMillis() + mSec;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.subHead.setCargoMotor(throttle);
        if(mSec > 0 && System.currentTimeMillis() > endTime){
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
        Robot.subHead.setCargoMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.subHead.setCargoMotor(0);
    }
}
