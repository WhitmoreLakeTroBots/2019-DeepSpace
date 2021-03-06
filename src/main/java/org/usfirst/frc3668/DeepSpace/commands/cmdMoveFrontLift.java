package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class cmdMoveFrontLift extends Command {

    public final int frontLiftManWindow = 15;
    public final int frontLiftSlowThreshold = 200;
    public final double frontLiftManSlowScalar = 0.5;

    boolean bDone = false;
    double initTics;
    double targetTics;
    double throttle;
    double deltaSignum;

    public cmdMoveFrontLift(double targetTics, double throttle) {
        this.targetTics = targetTics;
        this.throttle = throttle;
        requires(Robot.subLift);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        initTics = Robot.subLift.getLiftEncoderTics();
        deltaSignum = Math.signum(targetTics - initTics);
        System.err.println("Delta Signum: " + deltaSignum);
        bDone = false;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double currentTics = Robot.subLift.getLiftEncoderTics();
        double deltaTics = targetTics - currentTics;
        deltaSignum = Math.signum(deltaTics);
        double finalThrottle = throttle;

        if (Math.abs(deltaTics) <= frontLiftSlowThreshold) {
			finalThrottle = throttle * frontLiftManSlowScalar;
		}
		else if (Math.abs(initTics - currentTics)<= frontLiftSlowThreshold){
			finalThrottle = throttle * frontLiftManSlowScalar;
        }
        finalThrottle = deltaSignum * finalThrottle;
		System.err.println("CurrentTics: " + currentTics + " deltaTics: " + deltaTics);
		Robot.subLift.setLiftMotor(finalThrottle);
		if (currentTics > targetTics - frontLiftManWindow && currentTics < targetTics + frontLiftManWindow) {
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
        Robot.subLift.setLiftMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}