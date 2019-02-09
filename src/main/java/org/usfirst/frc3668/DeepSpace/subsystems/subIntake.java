package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class subIntake extends Subsystem {

    public subIntake() {
    }

    public void setIntake(double throttle) {
        RobotMap.intake.set(ControlMode.PercentOutput, throttle);
    }

    public void stopIntake() {
        RobotMap.intake.set(ControlMode.PercentOutput, 0);
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

}