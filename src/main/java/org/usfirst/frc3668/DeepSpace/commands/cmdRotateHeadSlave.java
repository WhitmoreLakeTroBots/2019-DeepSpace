package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Command;

public class cmdRotateHeadSlave extends Command {
    double angle;
    double deltaSignum;
    double initAngle;
    boolean isFinished = false;

    public cmdRotateHeadSlave() {
        requires(Robot.subHead);
    }
    
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        initAngle = Robot.subSwing.getSwingAngle();
        deltaSignum = Math.signum(angle - initAngle);
    }
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double joyY = Robot.oi.joyArt2.getY();
        angle = (-Robot.subSwing.getSwingAngle()) + Robot.headHoldAngle;
        double currentAngle = Robot.subHead.getHeadRotationAngle();
		double throttle = 0;
		double deltaAngle = angle - currentAngle;
        deltaSignum = Math.signum(deltaAngle);
        //System.err.println("joyY: " + joyY);
        if(Math.abs(joyY) < Settings.joystickDeadband){
        //System.err.println("Auto head movement");
		if (deltaSignum < 0) {
            throttle = Settings.headThrottleUP;
        
		} else {
			throttle = Settings.headThrottleDOWN;
		}
		if (Math.abs(deltaAngle) <= Settings.headSlowThreshold) {
			throttle = throttle *  Settings.headSlowScalar;
		}
		else if (Math.abs(initAngle - currentAngle) <= Settings.headSlowThreshold){
			throttle = throttle * Settings.headSlowScalar;
        }
        
        if (currentAngle > angle - Settings.headWindow && currentAngle < angle + Settings.headWindow) {
			throttle = 0;
        }
        } else {
            throttle = -joyY;
            Robot.headHoldAngle = Robot.subHead.getHeadRotationAngle();
        }
        //System.err.println(String.format("Target Angle: %1$.3f Current Angle: %2$.3f Current Throttle: %3$.3f", angle, currentAngle, throttle));
		Robot.subHead.setRotationMotor(throttle);
    }
    
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isFinished;
    }
    
    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.subHead.setRotationMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.subHead.setRotationMotor(0);
    }
}
