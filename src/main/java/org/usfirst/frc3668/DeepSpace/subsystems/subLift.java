package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;
import org.usfirst.frc3668.DeepSpace.Settings;
import org.usfirst.frc3668.DeepSpace.commands.cmdLiftDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class subLift extends Subsystem {

    public final double liftMetersPerTic = 0.000051485; //1 / 19422.8295 Experimental value
    public final double liftHieghttoLevel3 = 0.55;
    public final double liftHieghttoLevel2 = 0.1778;

    public subLift() {
        resetLiftDriveEncoder();
        resetLiftEncoder();
    }


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new cmdLiftDrive());
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
        return getLiftEncoderTics() * liftMetersPerTic;
    }

    public void setLiftMotor(double throttle){
        if(getLiftEncoderMeters() < liftHieghttoLevel3){
            System.err.print("Moving lift because meters < limit   ");
            RobotMap.frontLift.set(ControlMode.PercentOutput, throttle);
        } else if(throttle < 0) {
            System.err.print("Moving lift because throttle < 0   ");
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
        return -RobotMap.liftDrive.getSelectedSensorPosition();
    }

    public double getRobotPitch(){
        return RobotMap.navx.getPitch();
    }
}

