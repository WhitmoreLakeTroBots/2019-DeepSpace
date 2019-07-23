package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class cmdManTail extends Command {

    boolean bDone = false;
    double initAngle;
    double targetAngle;
    double throttle;
    double deltaSignum;

    public cmdManTail(double targetAngle, double throttle) {
        this.targetAngle = targetAngle;
        this.throttle = throttle;
        requires(Robot.subLift);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        initAngle = Robot.subTail.getTailAngle();
        deltaSignum = Math.signum(targetAngle - initAngle);
        System.err.println("Delta Signum: " + deltaSignum);
        bDone = false;
    }
    

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double currentAngle = Robot.subTail.getTailAngle();
        double deltaAngle = targetAngle - currentAngle;
        deltaSignum = Math.signum(deltaAngle);
        double finalThrottle = throttle;

		System.err.println("CurrentAngle: " + currentAngle + " deltaAngle: " + deltaAngle);
		Robot.subTail.setTail(finalThrottle);
		if (currentAngle > targetAngle) {
            bDone = true;
            
        }
        if (Robot.subLift.getLiftEncoderMeters() < Robot.subLift.liftHieghttoLevel3*.75){
            bDone = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return bDone;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.subTail.setTail(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}