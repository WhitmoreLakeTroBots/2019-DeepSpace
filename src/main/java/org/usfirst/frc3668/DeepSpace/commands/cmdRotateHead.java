package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Command;

public class cmdRotateHead extends Command {
    double angle;
    double deltaSignum;
    double initAngle;
    boolean isFinished = false;

    public cmdRotateHead(String absoluteAngle) {
        angle = Double.valueOf(absoluteAngle) + Robot.subSwing.getSwingAngle();
        requires(Robot.subHead);
    }
    
    public cmdRotateHead(double requestedAngle){
        angle = requestedAngle + Robot.subSwing.getSwingAngle();
        requires(Robot.subHead);
    }
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.headAngleOffset = Robot.subSwing.getSwingAngle() + angle;
        initAngle = Robot.subHead.getHeadRotationAngle();
        deltaSignum = Math.signum(angle - initAngle);
    }
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double currentAngle = Robot.subHead.getHeadRotationAngle();
		double throttle = 0;
        double deltaAngle = angle - currentAngle;

		deltaSignum = Math.signum(deltaAngle);
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
		
		Robot.subHead.setRotationMotor(throttle);
		if (currentAngle > angle - Settings.headWindow && currentAngle < angle + Settings.headWindow) {
			isFinished = true;
		}
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
        isFinished = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
