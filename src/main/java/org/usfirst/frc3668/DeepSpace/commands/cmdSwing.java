package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class cmdSwing extends Command {

    public final double swingThrottleUP = -0.5;
    public final double swingThrottleDOWN = -swingThrottleUP;
    public final double swingWindow = 2.5;
    public final double swingSlowThreshold = 15;
    public final double swingSlowScalar = 0.5;

    boolean incerment = false;

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
        Robot.swingHoldAngle = angle;
        Robot.headHoldAngle = 0.0;
        lowerBound = angle - swingWindow;
        upperBound = angle + swingWindow;
        initAngle = Robot.subSwing.getSwingAngle();
        deltaSignum = Math.signum(angle - initAngle);
        System.err.println("Staring swing movement");
    }
    
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double currentAngle = Robot.subSwing.getSwingAngle();
		double throttle = 0;
		double deltaAngle = angle - currentAngle;
		deltaSignum = Math.signum(deltaAngle);
		if (deltaSignum > 0) {
			throttle = swingThrottleUP;
		} else {
			throttle = swingThrottleDOWN;
		}
		if (Math.abs(deltaAngle) <= swingSlowThreshold) {
			throttle = throttle *  swingSlowScalar;
		}
		else if (Math.abs(initAngle - currentAngle) <= swingSlowThreshold){
			throttle = throttle * swingSlowScalar;
		}
		System.err.println("Target Angle:" + angle + " Current Swing Angle: " + currentAngle + " current Swing Revs: " + Robot.subSwing.getSwingRevs());
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
        isFinished = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.subSwing.setSwingMotor(0);
    }
}
