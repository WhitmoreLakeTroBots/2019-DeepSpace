package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.PID;
import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.RobotMath;
import org.usfirst.frc3668.DeepSpace.Settings;
import org.usfirst.frc3668.DeepSpace.motionProfile.MotionProfiler;

import edu.wpi.first.wpilibj.command.Command;

public class cmdProfileDrive extends Command {
	private double _distance;
	private double _cruiseSpeed;
	private boolean _isFinished = false;
	private double _startTime;
	private double _requestedHeading = 0;
	private double _distanceSignum;
	private double _absDistance;
	private double _abortTime;
	private double _endTime;
	private MotionProfiler mp;
	private PID pid = new PID(Settings.profileDriveKp, Settings.profileDriveKi, Settings.profileDriveKd);

	public cmdProfileDrive(double requestedHeading, double cruiseSpeed, double distance) {
		System.err.println("cmdProfileDrive");
		requires(Robot.subChassis);
		_distance = distance;
		_absDistance = Math.abs(distance);
		_distanceSignum = Math.signum(distance);
		_cruiseSpeed = cruiseSpeed;
		_requestedHeading = requestedHeading;
	}

	public cmdProfileDrive(double cruiseSpeed, double distance) {
		requires(Robot.subChassis);
		_distance = distance;
		_absDistance = Math.abs(distance);
		_distanceSignum = Math.signum(distance);
		_cruiseSpeed = cruiseSpeed;
		_requestedHeading = Robot.subChassis.getNormaliziedNavxAngle();
	}

	protected void ProfileMockConstructor(double Speed, double distance) {
		_distance = distance;
		_absDistance = Math.abs(distance);
		_distanceSignum = Math.signum(distance);
		_cruiseSpeed = Speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.err.println("Initializing");
		mp = new MotionProfiler(_absDistance, Settings.profileInitVelocity, _cruiseSpeed,
				Settings.profileDriveAccelration);
		Robot.subChassis.resetBothEncoders();
		_abortTime = _absDistance / _cruiseSpeed;
		_endTime = mp._stopTime * Settings.profileEndTimeScalar;
		System.err.println(String.format(
				"Projected Accelration Time: %1$.3f \tProjected Cruise Time: %2$.3f \t Projected Deccelration Time: %3$.3f \t Projected Length of Drive: %4$.3f \t Given Distance: %5$.3f \t Abort: %6$.3f \t Requested Heading: %7$.3f",
				mp._accelTime, mp._cruiseTime, mp._deccelTime, mp._stopTime, _distance, _abortTime, _requestedHeading));
		_startTime = RobotMath.getTime();
		_isFinished = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double encoderVal = Robot.subChassis.getEncoderAvgDistMeters();
		double deltaTime = RobotMath.getTime() - _startTime;
		double profileDist = mp.getTotalDistanceTraveled(deltaTime);
		double currentHeading = Robot.subChassis.getNormaliziedNavxAngle();
		double turnValue = calcTurnRate(currentHeading);
		double profileVelocity = mp.getProfileCurrVelocity(deltaTime);
		double throttlePos = (profileVelocity / Settings.maxVelocity);
		double pidVal = pid.calcPID(profileDist, encoderVal);
		double finalThrottle = throttlePos + pidVal;

		String msg = String.format(
				"CurrVel: %1$.3f \t throttle: %2$.3f \t Time: %3$.3f \t ProfileX: %4$.3f \t Encoder: %5$.3f \t PID Value: %10$.3f \t P: %14$.3f \t I: %13$.3f \t D: %11$.3f \t Final Throttle: %12$.3f \t Gyro: %15$.3f",
				profileVelocity, throttlePos, deltaTime, mp.getTotalDistanceTraveled(deltaTime), encoderVal,
				Robot.subChassis.getLeftEncoderDist(), Robot.subChassis.getRightEncoderDist(), currentHeading,
				turnValue, pidVal, pid.getDError(), finalThrottle, pid.getIError(), pid.getPError(), currentHeading);
		// FULL LOG MESSAGE: CurrVel: %1$.3f \t throttle: %2$.3f \t deltaTime: %3$.3f \t
		// Disantce Travelled: %4$.3f \t AvgEncoder: %5$.3f \t Left Encoder: %6$.3f \t
		// Right Encoder: %7$.3f \t Gyro Raw Heading: %8$.3f \t Turn Value: %9$.3f \t
		// PID Value: %10$.3f \t P Value: %11$.3f \t Final Throttle: %12$.3f
		System.err.println(msg);
		// log.makeEntry(msg);
		// SmartDashboard.putNumber("Drive Left Encoder:",
		// Robot.subChassis.getLeftEncoderDist());
		// SmartDashboard.putNumber("Drive Right Encoder: ",
		// Robot.subChassis.getRightEncoderDist());

		Robot.subChassis.Drive((finalThrottle * _distanceSignum), turnValue);

		// if (deltaTime > _abortTime && Robot.subChassis.getEncoderAvgDistInch() == 0)
		// {
		// System.out.println("Pasted Abort Time, Dead Encoders");
		// _isFinished = true;
		// Robot.subChassis._isSafeToMove = false;
		// }
		if (encoderVal < _absDistance + Settings.profileMovementThreshold
				&& encoderVal > _absDistance - Settings.profileMovementThreshold) {
			System.err.println("At Distance");
			_isFinished = true;
		}

		if (deltaTime > _endTime) {
			_isFinished = true;
		}
	}

	protected double calcTurnRate(double currentHeading) {
		double turnRate = RobotMath.calcTurnRate(currentHeading, _requestedHeading,
				Settings.profileDriveStraightGyroKp);
		// if(currentHeading > _requestedHeading) {
		// turnRate = turnRate * -1;
		// }
		return turnRate;
	}

	double limelightDistance(double area) {
		return 0; // Settings.limelightDistEXPC * (Math.pow(Math.E, (Settings.limelightDistEXPS *
					// area)));
	}

	public double calculateAngle(double rotation) {
		return Robot.subChassis.getNormaliziedNavxAngle() - rotation;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return _isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.subChassis.Drive(0, 0);
		Robot.subChassis.resetBothEncoders();
		System.out.println("AutoDriveProfileGyro is Finished Left Encoder: " + Robot.subChassis.getLeftEncoderDist()
				+ " Right Encoder: " + Robot.subChassis.getRightEncoderDist());
		System.err.println(String.format(
				"Projected Accelration Time: %1$.3f \tProjected Cruise Time: %2$.3f \t Projected Deccelration Time: %3$.3f \t Projected Length of Drive: %4$.3f \t Given Distance: %5$.3f",
				mp._accelTime, mp._cruiseTime, mp._deccelTime, mp._stopTime, _distance));

		// mp = null;
		// log.write();
		// log = null;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}