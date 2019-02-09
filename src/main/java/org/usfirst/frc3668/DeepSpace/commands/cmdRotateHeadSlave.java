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
        angle = Robot.subSwing.getSwingAngle() + Robot.headAngleOffset;
        double currentAngle = Robot.subHead.getHeadRotationAngle();
		double throttle = 0;
		double deltaAngle = angle - currentAngle;
		deltaSignum = Math.signum(deltaAngle);
		if (deltaSignum > 0) {
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
		Robot.subSwing.setSwingMotor(throttle);
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
