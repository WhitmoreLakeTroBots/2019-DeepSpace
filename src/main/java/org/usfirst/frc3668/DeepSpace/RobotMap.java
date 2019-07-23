package org.usfirst.frc3668.DeepSpace;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

public class RobotMap {
	public static final int rightDrive1CanID = 1;
	public static final int rightDrive2CanID = 2;
	public static final int leftDrive1CanID = 3;
	public static final int leftDrive2CanID = 4;
	public static final int tailCanID = 5;
	public static final int swingRotationCanID = 14;// 6 for srx
	public static final int frontLiftCanID = 7;
	public static final int intakePivotCanID = 9;
	public static final int intakeCanID = 8;
	public static final int headRotationCanID = 10;
	public static final int hatchManipulatorCanID = 11;
	public static final int cargoManipulatorCanID = 12;
	public static final int liftDriveCanID = 13;
	
	public static final int tailEncoderDIOPortA = 0;
	public static final int tailEncoderDIOPortB = 1;
	public static final int hatchDIOPortA = 2;
    public static final int hatchDIOPortB = 3;
	public static final int headRotationEncoderDIOA = 4;
    public static final int headRotationEncoderDIOB = 5;

	public static TalonSRX rightDrive1;
	public static TalonSRX rightDrive2;
	public static TalonSRX leftDrive1;
	public static TalonSRX leftDrive2;
	public static TalonSRX headRotation;
	public static TalonSRX tail;
	public static TalonSRX swingRotation;
	public static TalonSRX frontLift;
	public static TalonSRX intakePivot;
	public static TalonSRX intake;
	public static TalonSRX hatchManipulator;
	public static TalonSRX cargoManipulator;
	public static TalonSRX liftDrive;
	public static AHRS navx;
	public static Encoder tailEncoder;
	public static Encoder hatchManipulatorEncoder;
	public static Encoder headRotationEncoder;
	
	public static CANSparkMax tailSpark;
	public static CANSparkMax swingSpark;
	public static CANEncoder tailCanEncoder;
	public static DoubleSolenoid solo;

	public static void init() {

		//pnumatic solenoid

		solo = new DoubleSolenoid(0, 1);
		solo.set(DoubleSolenoid.Value.kOff);

		Compressor c = new Compressor(0);
        c.setClosedLoopControl(true);

		

		rightDrive1 = new TalonSRX(rightDrive1CanID);
		rightDrive1.setNeutralMode(NeutralMode.Brake);
		rightDrive1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, Settings.talonTimeOut);
		rightDrive1.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		rightDrive1.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		rightDrive2 = new TalonSRX(rightDrive2CanID);
		rightDrive2.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		rightDrive2.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		rightDrive2.setNeutralMode(NeutralMode.Brake);

		leftDrive1 = new TalonSRX(leftDrive1CanID);
		leftDrive1.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		leftDrive1.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		leftDrive1.setNeutralMode(NeutralMode.Brake);
		leftDrive1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, Settings.talonTimeOut);
		leftDrive2 = new TalonSRX(leftDrive2CanID);
		leftDrive2.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		leftDrive2.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		leftDrive2.setNeutralMode(NeutralMode.Brake);

		liftDrive = new TalonSRX(liftDriveCanID);
		liftDrive.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		liftDrive.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		liftDrive.setNeutralMode(NeutralMode.Coast);

		liftDrive.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, Settings.talonTimeOut);

		headRotation = new TalonSRX(headRotationCanID);
		headRotation.setNeutralMode(NeutralMode.Brake);
		headRotation.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		headRotation.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);

		headRotationEncoder = new Encoder(headRotationEncoderDIOA, headRotationEncoderDIOB);
		
		// tail = new TalonSRX(tailCanID);
		// tail.setNeutralMode(NeutralMode.Coast);
		// tail.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		// tail.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);

		//tailEncoder = new Encoder(tailEncoderDIOPortA, tailEncoderDIOPortB);
		
		tailSpark = new CANSparkMax(tailCanID, MotorType.kBrushless);
		tailSpark.setIdleMode(IdleMode.kCoast);
		tailCanEncoder = tailSpark.getEncoder();

		// swingRotation = new TalonSRX(swingRotationCanID);
		// swingRotation.setNeutralMode(NeutralMode.Brake);
		// swingRotation.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		// swingRotation.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);

		// swingRotation.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, Settings.talonTimeOut);
		
		swingSpark = new CANSparkMax(swingRotationCanID, MotorType.kBrushless);
		swingSpark.setIdleMode(IdleMode.kBrake);

		frontLift = new TalonSRX(frontLiftCanID);
		frontLift.setNeutralMode(NeutralMode.Brake);
		frontLift.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		frontLift.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);

		frontLift.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, Settings.talonTimeOut);

		intakePivot = new TalonSRX(intakePivotCanID);
		intakePivot.setNeutralMode(NeutralMode.Brake);
		intakePivot.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		intakePivot.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);

		intake = new TalonSRX(intakeCanID);
		intake.setNeutralMode(NeutralMode.Brake);
		intake.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		intake.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);

		hatchManipulator = new TalonSRX(hatchManipulatorCanID);
		hatchManipulator.setInverted(true);
		hatchManipulator.setNeutralMode(NeutralMode.Brake);
		hatchManipulator.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		hatchManipulator.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		
		hatchManipulatorEncoder = new Encoder(hatchDIOPortA, hatchDIOPortB);

		cargoManipulator = new TalonSRX(cargoManipulatorCanID);
		cargoManipulator.setNeutralMode(NeutralMode.Brake);
		cargoManipulator.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		cargoManipulator.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		cargoManipulator.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, Settings.talonTimeOut);

		navx = new AHRS(SPI.Port.kMXP);
	}
}