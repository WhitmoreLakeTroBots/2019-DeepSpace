package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class subIntake extends Subsystem {

    public subIntake() {
        resetIntakePivotEncoder();
    }

    public void setIntake(double throttle) {
        RobotMap.intake.set(ControlMode.PercentOutput, throttle);
    }

    public void stopIntake() {
        RobotMap.intake.set(ControlMode.PercentOutput, 0);
    }

    public void setIntakePivot(double throttle){
        RobotMap.intakePivot.set(ControlMode.PercentOutput, throttle);
    }

    public double getIntakePivotEncoderTics(){
        return RobotMap.intakePivot.getSelectedSensorPosition();
    }

    public void resetIntakePivotEncoder(){
        RobotMap.intakePivot.setSelectedSensorPosition(0);
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
}