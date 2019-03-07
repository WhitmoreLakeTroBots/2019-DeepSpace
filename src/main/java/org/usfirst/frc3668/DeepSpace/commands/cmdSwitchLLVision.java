package org.usfirst.frc3668.DeepSpace.commands;

import edu.wpi.first.wpilibj.command.Command;
import java.lang.System;

import org.usfirst.frc3668.DeepSpace.Robot;

public class cmdSwitchLLVision extends Command {
    boolean bDone = false;
    double parameter = -1;
    long mSecDelay = 100;
    long endTime = 0;
    
    public cmdSwitchLLVision() {
    }

    public cmdSwitchLLVision(double parameter){
        this.parameter = parameter;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        bDone = false;
        endTime = System.currentTimeMillis() + mSecDelay;
        if(parameter >= 0){
            switchLLMode(parameter);
        } else {
            switchLLMode();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //System.err.println("Switching ll");
        if (System.currentTimeMillis() >= endTime) {
            bDone = true;
        }
    }

    protected void switchLLMode(double parameter){
        Robot.llCamMode = parameter;
            setLimeOmniMode(Robot.llCamMode);
            setLimeTracMode(Robot.llCamMode);
    }

    protected void switchLLMode(){
        if(Robot.llCamMode == 0){
            Robot.llCamMode = 1;
            setLimeOmniMode(Robot.llCamMode);
            setLimeTracMode(Robot.llCamMode);
        } else {
            Robot.llCamMode = 0;
            setLimeOmniMode(Robot.llCamMode);
            setLimeTracMode(Robot.llCamMode);
        }
    }
    protected void setLimeOmniMode(double parameter){
        Robot.lop.setNumber(Math.abs(parameter-1));
        
    }

    protected void setLimeTracMode(double parameter){
        Robot.ltp.setNumber(parameter);
    
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return bDone;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        bDone = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted(){
    }
}
