package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;
import org.usfirst.frc3668.DeepSpace.Settings;
import org.usfirst.frc3668.DeepSpace.commands.cmdJoySwing;
import org.usfirst.frc3668.DeepSpace.commands.cmdSwingHoldPID;

import edu.wpi.first.wpilibj.command.Subsystem;

public class subSwing extends Subsystem {

    public final double swingDegreesPerRev = 1.0285714; //360.0 * (12.0/42.0) * (1.0/100.0) || 360 / (17.672 gear ratio * 4096 tics per revoltion)

    public subSwing() {
    resetSwingEncoder();
    }


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new cmdJoySwing());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void setSwingMotor(double throttle){
        RobotMap.swingSpark.set(throttle);
    }

    public void resetSwingEncoder(){
        RobotMap.swingSpark.getEncoder().setPosition(0);
        //RobotMap.swingRotation.setSelectedSensorPosition(0, 0, 0);
    }

    public double getSwingRevs(){
        return -RobotMap.swingSpark.getEncoder().getPosition();
        //return RobotMap.swingRotation.getSelectedSensorPosition();
    }
    public double getSwingAngle(){
        return getSwingRevs() * swingDegreesPerRev;
    }
}
