package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class subCargo extends Subsystem {

public subCargo() {
    
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

    public void resetCargoEncoder1(){
        RobotMap.cargoManipulator1.setSelectedSensorPosition(0, 0, 0);
    }

    public void setCargoMotor1(double throttle){
        RobotMap.cargoManipulator1.set(ControlMode.PercentOutput, throttle);
    }

    public void resetCargoEncoder2(){
        RobotMap.cargoManipulator2.setSelectedSensorPosition(0, 0, 0);
    }

    public void setCargoMotor2(double throttle){
        RobotMap.cargoManipulator2.set(ControlMode.PercentOutput, throttle);
    }

   

    
}

