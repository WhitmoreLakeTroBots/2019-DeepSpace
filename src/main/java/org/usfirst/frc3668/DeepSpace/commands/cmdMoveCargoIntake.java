package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Command;

public class cmdMoveCargoIntake extends Command {
 
    public static final int intakeSlowThreshold = 100;
    public static final double intakeSlowScalar = 0.75;
    public static final int intakeWindow = 5;
    public static final int intakeDownTics = 450;
    public static final int intakeUpTics = 0;
 
    boolean bDone = false;
    double throttle;
    double targetTics;
    double initTics;
    double deltaSignum;
    
    public cmdMoveCargoIntake(double throttle, double targetTics) {
        this.throttle = throttle;
		this.targetTics = targetTics;

		requires(Robot.subIntake);
    }

    public cmdMoveCargoIntake(double throttle){
        this.throttle = throttle;
        requires(Robot.subIntake);
    }
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        bDone = false;
        initTics = Robot.subIntake.getIntakePivotEncoderTics();
        if(initTics > intakeDownTics / 2){
            targetTics = intakeUpTics;
        } else {
            targetTics = intakeDownTics;
        }
        deltaSignum = Math.signum(targetTics - initTics);
        System.err.println("starting to move cargo intake " + targetTics);
        
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double currentTics = Robot.subIntake.getIntakePivotEncoderTics();
		double throttle = 0;
        double deltaTics = targetTics - currentTics;
		deltaSignum = Math.signum(deltaTics);
		if (deltaSignum > 0) {
            throttle = Settings.intakeUpThrottle;
		} else {
			throttle = -Settings.intakeDownThrottle;
        }
        
		if (Math.abs(deltaTics) <= intakeSlowThreshold) {
			throttle = throttle *  intakeSlowScalar;
		}
		else if (Math.abs(initTics - currentTics)<= intakeSlowThreshold){
			throttle = throttle * intakeSlowScalar;
        }
        System.err.println("Current Encoder Tics: " + currentTics);
		
		Robot.subIntake.setIntakePivot(throttle);
		if (currentTics > targetTics - intakeWindow && currentTics < targetTics + intakeWindow) {
            System.err.println("ending intake movement");
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
        Robot.subIntake.setIntakePivot(0);
        bDone = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.subIntake.setIntakePivot(0);
    }
}
