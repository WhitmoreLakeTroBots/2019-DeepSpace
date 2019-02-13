package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Subsystem;

public class subSwing extends Subsystem {

    public subSwing() {
    resetSwingEncoder();
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

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void setSwingMotor(double throttle){
        RobotMap.swingRotation.set(ControlMode.PercentOutput, throttle);
    }

    public void resetSwingEncoder(){
        RobotMap.swingRotation.setSelectedSensorPosition(0, 0, 0);
    }

    public double getSwingTics(){
        return RobotMap.swingRotation.getSelectedSensorPosition();
    }
    public double getSwingAngle(){
        return getSwingTics() * Settings.swingDegreesPerTic;
    }
}
