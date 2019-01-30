// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3668.DeepSpace.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class subTail extends Subsystem {
      public subTail() {
        
    }

    public void resetTailEncoder() {
		RobotMap.tail.setSelectedSensorPosition(0, 0, 0);
    }
    
    public int getTailEncoderTics(){
            return RobotMap.tail.getSelectedSensorPosition(0);
    }
    
    public void tailThrotle(double throttle) {
		RobotMap.tail.set(ControlMode.PercentOutput, throttle);
		
	}
   


 

    @Override
    public void initDefaultCommand() {
       
    }

    @Override
    public void periodic() {
       

    }

   
}

