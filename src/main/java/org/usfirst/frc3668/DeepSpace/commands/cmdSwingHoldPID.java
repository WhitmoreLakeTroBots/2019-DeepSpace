package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.PID;
import org.usfirst.frc3668.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class cmdSwingHoldPID extends Command {

    double holdKp = 0.1;
    double holdKi = 0.0;
    double holdKd = 0.0;

    PID holdPID;

    public cmdSwingHoldPID() {
        requires(Robot.subSwing);
    }
    
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        holdPID = new PID(holdKp, holdKi, holdKd);
    }
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double throttle = -holdPID.calcPID(Robot.swingHoldAngle, Robot.subSwing.getSwingAngle());
        Robot.subSwing.setSwingMotor(throttle);
    }
    
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }
    
    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.subSwing.setSwingMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.subSwing.setSwingMotor(0);
    }
}
