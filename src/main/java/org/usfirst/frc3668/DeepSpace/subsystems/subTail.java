package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class subTail extends Subsystem {

  public final double tailDegPerTic = 0.16413;//360/((5/3)*188*7)
  public final double tailMaxTipSpeed = 0.51816;
  public final double tailLength = 0.508;

  public subTail() {
    resetTailEncoder();
  }
  
  public double getTailAngle(){
    return getTailEncoderTics() * tailDegPerTic;
    
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
    double angle = getTailAngle();
    double numarator = Math.sqrt(Math.pow(tailLength, 2) - Math.pow((tailLength * Math.cos(angle)), 2));
    double denominator = tailLength * Math.cos(angle);
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
