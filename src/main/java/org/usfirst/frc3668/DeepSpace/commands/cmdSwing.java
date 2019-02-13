package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Command;

public class cmdSwing extends Command {
    double angle;
    double deltaSignum;
    double initAngle;
    boolean isFinished = false;
    double lowerBound;
    double upperBound;

    public cmdSwing(String requestedAngle) {
        angle = Double.valueOf(requestedAngle);
        requires(Robot.subSwing);
    }
    
    public cmdSwing(double requestedAngle){
        angle = requestedAngle;
        requires(Robot.subSwing);
    }
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.headAngleOffset = 0.0;
        lowerBound = angle - Settings.swingWindow;
        upperBound = angle + Settings.swingWindow;
        initAngle = Robot.subSwing.getSwingAngle();
        deltaSignum = Math.signum(angle - initAngle);
    }
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double currentAngle = Robot.subSwing.getSwingAngle();
		double throttle = 0;
		double deltaAngle = angle - currentAngle;
		deltaSignum = Math.signum(deltaAngle);
		if (deltaSignum > 0) {
			throttle = Settings.swingThrottleUP;
		} else {
			throttle = Settings.swingThrottleDOWN;
		}
		if (Math.abs(deltaAngle) <= Settings.swingSlowThreshold) {
			throttle = throttle *  Settings.swingSlowScalar;
		}
		else if (Math.abs(initAngle - currentAngle) <= Settings.swingSlowThreshold){
			throttle = throttle * Settings.swingSlowScalar;
		}
		
		Robot.subSwing.setSwingMotor(throttle);
		if (currentAngle > lowerBound && currentAngle < upperBound) {
            isFinished = true;
            System.err.println("cmdSwing is finished");
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
        Robot.subSwing.setSwingMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.subSwing.setSwingMotor(0);
    }
}
