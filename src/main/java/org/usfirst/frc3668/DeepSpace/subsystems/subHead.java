package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.RobotMap;
import org.usfirst.frc3668.DeepSpace.Settings;
import org.usfirst.frc3668.DeepSpace.commands.cmdRotateHeadSlave;

import edu.wpi.first.wpilibj.command.Subsystem;

public class subHead extends Subsystem {

    public final double headRotationDegreesPerTic = 0.25777; //360 degrees / (497 tics per rev motor * 2.81 gear ratio)
    
    public subHead() {
        resetHatchEncoder();
        resetCargoEncoder();
        resetRotationEncoder();
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new cmdRotateHeadSlave());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void resetRotationEncoder() {
        RobotMap.headRotation.setSelectedSensorPosition(0, 0, 0);
    }

    public double getRotationEncoder() {
        return RobotMap.headRotationEncoder.get();
    }

    public double getHeadRotationAngle() {
        return getRotationEncoder() * headRotationDegreesPerTic;
    }

    public void setRotationMotor(double throttle) {
        RobotMap.headRotation.set(ControlMode.PercentOutput, throttle);
    }

    public void resetHatchEncoder() {
        RobotMap.hatchManipulatorEncoder.reset();
    }

    public double getHatchEncoder() {
        return -1 * RobotMap.hatchManipulatorEncoder.get();
    }

    public void setHatchMotor(double throttle) {
        RobotMap.hatchManipulator.set(ControlMode.PercentOutput, throttle);
    }

    public void resetCargoEncoder() {
        RobotMap.cargoManipulator.setSelectedSensorPosition(0, 0, 0);
    }

    public double getCargoEnconder() {
        return RobotMap.cargoManipulator.getSelectedSensorPosition();
    }

    public void setCargoMotor(double throttle) {
        RobotMap.cargoManipulator.set(ControlMode.PercentOutput, throttle);
    }
}
