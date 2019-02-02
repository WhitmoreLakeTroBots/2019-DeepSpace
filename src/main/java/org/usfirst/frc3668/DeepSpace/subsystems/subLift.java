package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;
import org.usfirst.frc3668.DeepSpace.Settings;
import org.usfirst.frc3668.DeepSpace.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

public class subLift extends Subsystem {

public subLift() {
    
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

    public void setLiftMotor(double throttle){
        RobotMap.frontLift.set(ControlMode.PercentOutput, throttle);
    }

   

    public void resetLiftDriveEncoder(){
        RobotMap.liftDrive.setSelectedSensorPosition(0, 0, 0);
    }

    public double getLiftDriveDist(){
        return 0;
    }

    public void setRearLiftMotor(double throttle){
    }

    public void resetRearLiftEncoder(){
    }

    public double getRearLiftAngle(){
        return 0;
    }

    public double getRobotPitch(){
        return 0;
    }

    public double calcFrontLiftSpeed (){
        double angle = getRearLiftAngle();
        double numarator = Math.sqrt(Math.pow(Settings.liftRearStiltLength, 2) - Math.pow((Settings.liftRearStiltLength * Math.cos(angle)), 2));
        double denominator = Settings.liftRearStiltLength * Math.cos(angle);
        return Settings.liftRearStiltSpeed * Math.cos(Math.atan(numarator/denominator));
    }
}

