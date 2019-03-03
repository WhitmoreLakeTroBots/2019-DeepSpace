package org.usfirst.frc3668.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3668.DeepSpace.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class subTail extends Subsystem {

  public final double tailDegPerRev = 2.16;// (1/100) * (3/5) * 360
  public final double tailMaxTipSpeed = 0.51816;
  public final double tailLength = 0.508;
  public final double tailLimit = -93;

  public subTail() {
    resetTailEncoder();
  }

  public double getTailAngle() {
    return getTailEncoderRevs() * tailDegPerRev;

  }

  public void resetTailEncoder() {
    // RobotMap.tailEncoder.reset();
    RobotMap.tailCanEncoder.setPosition(0);
  }

  public double getTailEncoderRevs() {
    // System.err.println("Readind tail encoder " +
    // RobotMap.tailSpark.getEncoder().getPosition());
    // return -RobotMap.tailEncoder.get();
    // return -RobotMap.tailSpark.getEncoder().getPosition();
    return -RobotMap.tailCanEncoder.getPosition();

  }

  public void setTail(double throttle) {
    // RobotMap.tail.set(ControlMode.PercentOutput, throttle);
    if (getTailAngle() > tailLimit && Math.signum(throttle) == 1) {
      RobotMap.tailSpark.set(throttle);
    } else if (getTailAngle() < 0 && Math.signum(throttle) == -1){
      RobotMap.tailSpark.set(throttle);
    }else {
      RobotMap.tailSpark.set(0);
    }
  }

  public double calcFrontLiftSpeed(double tailThrottle) {
    double angle = Math.toRadians(getTailAngle());
    double numarator = Math.sqrt(Math.pow(tailLength, 2) - Math.pow((tailLength * Math.cos(angle)), 2));
    double denominator = tailLength * Math.cos(angle);
    // return tailThrottle * Settings.tailMaxTipSpeed *
    // Math.cos(Math.atan(numarator/denominator));
    return 1;
  }

  @Override
  public void initDefaultCommand() {

  }

  @Override
  public void periodic() {

  }

}
