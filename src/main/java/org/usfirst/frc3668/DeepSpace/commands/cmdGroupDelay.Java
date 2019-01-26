package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.OI;
import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.commands.*;

import edu.wpi.first.wpilibj.command.Command;

public class cmdGroupDelay extends CommandGroup {
    boolean bDone =false;
    long finishedTime = 0; 
    public cmdGroupDelay(long milliseconds) { 
        finishedTime = milliseconds + java.lang.System.currentTimeMillis() ;}
                   
    public cmdGroupDelay () {
        finishedTime =  java.lang.System.currentTimeMillis() -1000 ;
     }
        // Called just before this Command runs the first time
        @Override
        protected void initialize() {
        }
    
        // Called repeatedly when this Command is scheduled to run
        @Override
        protected void execute() {
           if (java.lang.System.currentTimeMillis > FinishedTime) 

         { bDone = true;
                
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

        }
    }
