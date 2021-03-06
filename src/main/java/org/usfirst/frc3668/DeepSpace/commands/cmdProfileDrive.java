package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.PID;
import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.RobotMath;
import org.usfirst.frc3668.DeepSpace.Settings;
import org.usfirst.frc3668.DeepSpace.motionProfile.MotionProfiler;

import edu.wpi.first.wpilibj.command.Command;

public class cmdProfileDrive extends Command {

	public final double profileDriveStraightGyroKp = -0.01;
    public final double profileMovementThreshold = 0.02;
    public final double profileInitVelocity = 0.0;
    public final double profileEndTimeScalar = 1.3;
    public final double profileDriveAccelration = 1.50; // meters/sec/sec 


	private boolean _vision = false;
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

	public cmdProfileDrive(double cruiseSpeed, boolean vision){
		_vision = vision;
		_cruiseSpeed = cruiseSpeed;
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
		if(_vision){
			_distance = -RobotMath.calcLimeTracDist(Robot.lty.getDouble(Settings.ltDefaultAngle));
			System.err.println("LL Dist: " + _distance);
			_distance = _distance + Settings.ltDistanceOffset;
			if(_distance == -RobotMath.calcLimeTracDist(Settings.ltDefaultAngle) + Settings.ltDistanceOffset || !Robot.ltv.getBoolean(false)){
				_isFinished = true;
			}
			_absDistance = Math.abs(_distance);
			_distanceSignum = Math.signum(_distance);
			_requestedHeading = Robot.subChassis.getNormaliziedNavxAngle();
		}
		
		mp = new MotionProfiler(_absDistance, profileInitVelocity, _cruiseSpeed,
				profileDriveAccelration);
		Robot.subChassis.resetBothEncoders();
		_abortTime = _absDistance / _cruiseSpeed;
		_endTime = mp._stopTime * profileEndTimeScalar;
		System.err.println(String.format(
				"Projected Accelration Time: %1$.3f\tProjected Cruise Time: %2$.3f\tProjected Deccelration Time: %3$.3f \t Projected Length of Drive: %4$.3f \t Given Distance: %5$.3f \t Abort: %6$.3f \t Requested Heading: %7$.3f",
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
		double pidVal = pid.calcPID(profileDist, Math.abs(encoderVal));
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
		Robot.subChassis.Drive((finalThrottle * _distanceSignum), turnValue);

		// if (deltaTime > _abortTime && Robot.subChassis.getEncoderAvgDistInch() == 0)
		// {
		// System.out.println("Pasted Abort Time, Dead Encoders");
		// _isFinished = true;
		// Robot.subChassis._isSafeToMove = false;
		// }
		if (/*Math.abs(encoderVal) < _absDistance + profileMovementThreshold
				&&*/ Math.abs(encoderVal) > _absDistance - profileMovementThreshold) {
			Robot.subChassis.Drive((-3 * finalThrottle * _distanceSignum), 0);
			System.err.println("At Distance");
			_isFinished = true;
		}

		if (deltaTime > _endTime) {
			_isFinished = true;
		}
	}

	protected double calcTurnRate(double currentHeading) {
		double turnRate = RobotMath.calcTurnRate(currentHeading, _requestedHeading,
				profileDriveStraightGyroKp);
		// if(currentHeading > _requestedHeading) {
		// turnRate = turnRate * -1;
		// }
		return turnRate;
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
		_isFinished = false;
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