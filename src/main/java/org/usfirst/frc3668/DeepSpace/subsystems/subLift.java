package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;
import org.usfirst.frc3668.DeepSpace.Settings;
import edu.wpi.first.wpilibj.command.Subsystem;

public class subLift extends Subsystem {

    public subLift() {
        resetLiftDriveEncoder();
        resetLiftEncoder();
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

    public void resetLiftEncoder(){
        RobotMap.frontLift.setSelectedSensorPosition(0, 0, 0);
    }

    public double getLiftEncoderTics(){
        return RobotMap.frontLift.getSelectedSensorPosition();
    }

    public double getLiftEncoderMeters(){
        return getLiftEncoderTics() * Settings.liftMetersPerTic;
    }

    public void setLiftMotor(double throttle){
        if(getLiftEncoderMeters() < Settings.liftHieghttoLevel3){
            RobotMap.frontLift.set(ControlMode.PercentOutput, throttle);
        } else {
            RobotMap.frontLift.set(ControlMode.PercentOutput, 0);
        }
    }

    public void setLiftDriveMotor (double throttle){
        RobotMap.liftDrive.set(ControlMode.PercentOutput, throttle);
    }

    public void resetLiftDriveEncoder(){
        RobotMap.liftDrive.setSelectedSensorPosition(0, 0, 0);
    }

    public double getLiftDriveTics(){
        return RobotMap.liftDrive.getSelectedSensorPosition();
    }

    public double getRobotPitch(){
        return RobotMap.navx.getPitch();
    }
}

