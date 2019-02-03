package org.usfirst.frc3668.DeepSpace.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.RobotMap;
import org.usfirst.frc3668.DeepSpace.Settings;



public class subIntake extends Subsystem {

    public subIntake() {

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

    public void setIntaketMotor(double throttle) {
        RobotMap.intake.set(ControlMode.PercentOutput, throttle);
    }

    public double getIntakeDriveDist() {
        return 0;
    }

    public void setRearIntakeMotor(double throttle) {
    }

    public void resetRearIntakeEncoder() {
    }

    public double getRearIntakeAngle() {
        return 0;
    }

    public double getRobotPitch() {
        return 0;
    }
    
   
}