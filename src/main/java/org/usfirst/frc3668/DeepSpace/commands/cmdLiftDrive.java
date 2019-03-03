package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class cmdLiftDrive extends Command {
    public final double lDriveWindow = 2.5;
    public final double lDriveSlowThreshold = 15;
    public final double lDriveSlowScalar = 0.5;

    boolean bDone = false;
    double targetTics;
    double throttle;
    double deltaSignum;
    double initTics;
    boolean isFinished = false;
    double lowerBound;
    double upperBound;

    public cmdLiftDrive(double targetTics, double throttle) {
        this.targetTics = targetTics;
        this.throttle = throttle;
        requires(Robot.subLift);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        bDone = false;
        lowerBound = targetTics - lDriveWindow;
        upperBound = targetTics + lDriveWindow;
        initTics = Robot.subLift.getLiftDriveTics();
        deltaSignum = Math.signum(targetTics - initTics);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double currentTics = Robot.subLift.getLiftDriveTics();
        double deltatargetTics = targetTics - currentTics;
        double finalThrottle;

		deltaSignum = Math.signum(deltatargetTics);
		if (deltaSignum > 0) {
			finalThrottle = throttle;
		} else {
			finalThrottle = -throttle;
		}
		if (Math.abs(deltatargetTics) <= lDriveSlowThreshold) {
			finalThrottle = throttle *  lDriveSlowScalar;
		}
		else if (Math.abs(initTics - currentTics) <= lDriveSlowThreshold){
			finalThrottle = throttle * lDriveSlowScalar;
		}
		
		Robot.subLift.setLiftDriveMotor(finalThrottle);
		if (currentTics > lowerBound && currentTics < upperBound) {
            isFinished = true;
            System.err.println("cmdLiftDrive is finished");
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
        Robot.subLift.setLiftDriveMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}