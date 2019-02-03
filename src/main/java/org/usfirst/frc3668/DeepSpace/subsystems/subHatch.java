package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class subHatch extends Subsystem {

public subHatch() {
    
    }


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void resetHatchEncoder(){
        RobotMap.hatchManipulator.setSelectedSensorPosition(0, 0, 0);
    }

    public void setHatchMotor(double throttle){
        RobotMap.hatchManipulator.set(ControlMode.PercentOutput, throttle);
    }

   

    
}

