package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Subsystem;

public class subTail extends Subsystem {
  public subTail() {
    resetTailEncoder();
  }
  
  public double getTailAngle(){
    return getTailEncoderTics() * Settings.tailDegPerTic;
    
  }

  public void resetTailEncoder(){
    RobotMap.tailEncoder.reset();
  }
  public int getTailEncoderTics() {
    return -RobotMap.tailEncoder.get();
  }

  public void setTail(double throttle) {
    RobotMap.tail.set(ControlMode.PercentOutput, throttle);

  }

  public double calcFrontLiftSpeed (double tailThrottle){
    double angle = Math.toRadians(getTailAngle());
    double numarator = Math.sqrt(Math.pow(Settings.tailLength, 2) - Math.pow((Settings.tailLength * Math.cos(angle)), 2));
    double denominator = Settings.tailLength * Math.cos(angle);
    //return tailThrottle * Settings.tailMaxTipSpeed * Math.cos(Math.atan(numarator/denominator));
    return 0.75;
  }

  @Override
  public void initDefaultCommand() {

  }

  @Override
  public void periodic() {

  }

}
