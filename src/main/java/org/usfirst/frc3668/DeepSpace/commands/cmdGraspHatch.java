package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Command;

public class cmdGraspHatch extends Command {
    boolean bDone = false;
    double throttle;
    double targetTics;
    double initTics;
    double deltaSignum;
    
    public cmdGraspHatch(double throttle, double targetTics) {
        this.throttle = throttle;
		this.targetTics = targetTics;

		requires(Robot.subHead);
    }

    public cmdGraspHatch(double throttle){
        this.throttle = throttle;
    }
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        bDone = false;
        initTics = Robot.subHead.getHatchEncoder();
        if(initTics < Settings.hatchClosedTics / 2){
            targetTics = Settings.hatchOpenTics;
        } else {
            targetTics = Settings.hatchClosedTics;
        }
		deltaSignum = Math.signum(targetTics - initTics);
        
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double currentTics = Robot.subHead.getHatchEncoder();
		double throttle = 0;
        double deltaTics = targetTics - currentTics;
		deltaSignum = Math.signum(deltaTics);
		if (deltaSignum > 0) {
            throttle = Settings.hatchThrottle;
		} else {
			throttle = -Settings.hatchThrottle;
        }
        
		if (Math.abs(deltaTics) <= Settings.hatchSlowThreshold) {
			throttle = throttle *  Settings.hatchSlowScalar;
		}
		else if (Math.abs(initTics - currentTics)<= Settings.hatchSlowThreshold){
			throttle = throttle * Settings.hatchSlowScalar;
		}
		
		Robot.subHead.setHatchMotor(throttle);
		if (currentTics > targetTics - Settings.hatchWindow && currentTics < targetTics + Settings.hatchWindow) {
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
        Robot.subHead.setHatchMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.subHead.setHatchMotor(0);
    }
}
