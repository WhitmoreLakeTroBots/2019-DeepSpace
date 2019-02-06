package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.PID;
import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.RobotMath;
import org.usfirst.frc3668.DeepSpace.Settings;
import org.usfirst.frc3668.DeepSpace.Settings.chassisTurnDirection;

import edu.wpi.first.wpilibj.command.Command;

public class cmdTurnGyro extends Command {
	double _initLeftThrottle;
	double _initThrottle;
	double _desiredHeading;
	chassisTurnDirection _turnDir;
	boolean _isFinished = false;
	double _rightSignum;
	double _leftSignum;
	boolean _vision = false;
	PID pid = new PID(Settings.chassisTurnKp, Settings.chassisTurnKi, Settings.chassisTurnkd);
	
	public cmdTurnGyro(double throttle, double desiredHeading) {
		requires(Robot.subChassis);
		_desiredHeading = desiredHeading;
		_initThrottle = throttle;
		
	}

	public cmdTurnGyro(double throttle, boolean vision){
		requires(Robot.subChassis);
		_initThrottle = throttle;
		_vision = vision;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		double limeAngle = Robot.llx.getDouble(Settings.llDefaultAngle);
		if(_vision){
			if(limeAngle != Settings.llDefaultAngle){
			limeAngle = limeAngle * Settings.limelightHorzAngleScalar;
			_desiredHeading = Robot.subChassis.getNormaliziedNavxAngle() + limeAngle;
			System.err.println("Lime Angle: " + limeAngle);
			} else {
				_isFinished = true;
			}
		}
		System.err.println("cmdTurnGyro " + _desiredHeading);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double currHeading = Robot.subChassis.getNormaliziedNavxAngle();
		double headingDelta = RobotMath.headingDelta(currHeading, _desiredHeading);
		double scaledHeading = pid.calcPID(headingDelta);
		double scaledHeadingSignum = -Math.signum(scaledHeading);
		double throttle = (_initThrottle + Math.abs(scaledHeading)) * scaledHeadingSignum;
		
		Robot.subChassis.Drive(0, throttle);
		
		System.err.println(String.format(
						"Current Heading: %1$.3f \t Heading Delta: %2$.3f \t Scaled Heading: %3$.3f \t Throttle: %4$.3f",
						currHeading, headingDelta, scaledHeading, throttle));
		
		if (Robot.subChassis.gyroInTol(currHeading, _desiredHeading, Settings.chassisGyroTol)) {
			_isFinished = true;
			System.out.println("Finished!");
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return _isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.subChassis.Drive(0, 0);
		System.err.println("Finished at " + Robot.subChassis.getNormaliziedNavxAngle());
		_isFinished = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
