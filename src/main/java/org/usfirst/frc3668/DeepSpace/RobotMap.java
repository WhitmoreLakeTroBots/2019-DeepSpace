package org.usfirst.frc3668.DeepSpace;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

public class RobotMap {
    public static TalonSRX rightDrive1;
    public static TalonSRX rightDrive2;
    public static TalonSRX leftDrive1;
    public static TalonSRX leftDrive2;
	public static TalonSRX headRotation;
	public static TalonSRX tail;
	public static TalonSRX swingRotation;
	public static TalonSRX frontLift;
	public static TalonSRX intakeRotation;
	public static TalonSRX intake;
	public static TalonSRX hatchManipulator;
	public static TalonSRX cargoManipulator1;
	public static TalonSRX cargoManipulator2;
	public static AHRS navx;
	public static Encoder tailEncoder;

    public static void init() {
		rightDrive1 = new TalonSRX(Settings.chassisRightDrive1CanID);
		rightDrive1.setNeutralMode(NeutralMode.Brake);
		rightDrive1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0,
				Settings.talonTimeOut);
		rightDrive1.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		rightDrive1.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		rightDrive2 = new TalonSRX(Settings.chassisRightDrive2CanID);
		rightDrive2.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		rightDrive2.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		rightDrive2.setNeutralMode(NeutralMode.Brake);

		leftDrive1 = new TalonSRX(Settings.chassisLeftDrive1CanID);
		leftDrive1.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		leftDrive1.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		leftDrive1.setNeutralMode(NeutralMode.Brake);
		leftDrive1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0,
				Settings.talonTimeOut);
		leftDrive2 = new TalonSRX(Settings.chassisLeftDrive2CanID);
		leftDrive2.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		leftDrive2.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		leftDrive2.setNeutralMode(NeutralMode.Brake);
		
		headRotation = new TalonSRX(Settings.headRotationCanID);
		headRotation.setNeutralMode(NeutralMode.Brake);
		headRotation.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		headRotation.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		
		tail = new TalonSRX(Settings.TailCanID);
		tail.setNeutralMode(NeutralMode.Brake);
		tail.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		tail.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);

		tailEncoder = new Encoder(Settings.tailEncoderDIOPortA, Settings.tailEncoderDIOPortB);
		tail.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0,
		Settings.talonTimeOut);
		
		swingRotation = new TalonSRX(Settings.swingRotationCanID);
		swingRotation.setNeutralMode(NeutralMode.Brake);
		swingRotation.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		swingRotation.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		
		frontLift = new TalonSRX(Settings.frontLiftCanID);
		frontLift.setNeutralMode(NeutralMode.Brake);
		frontLift.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		frontLift.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		
		intakeRotation = new TalonSRX(Settings.intakeRotationCanID);
		intakeRotation.setNeutralMode(NeutralMode.Brake);
		intakeRotation.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		intakeRotation.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		
		intake = new TalonSRX(Settings.intakeCanID);
		intake.setNeutralMode(NeutralMode.Brake);
		intake.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		intake.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		
		hatchManipulator = new TalonSRX(Settings.hatchManipulatorCanID);
		hatchManipulator.setNeutralMode(NeutralMode.Brake);
		hatchManipulator.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		hatchManipulator.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		
		cargoManipulator1 = new TalonSRX(Settings.cargoManipulator1CanID);
		cargoManipulator1.setNeutralMode(NeutralMode.Brake);
		cargoManipulator1.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		cargoManipulator1.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		
		cargoManipulator2 = new TalonSRX(Settings.cargoManipulator2CanID);
		cargoManipulator2.setNeutralMode(NeutralMode.Brake);
		cargoManipulator2.configPeakCurrentLimit(Settings.chassisDriveMaxCurrentLimit, Settings.talonTimeOut);
		cargoManipulator2.configPeakCurrentDuration(Settings.chassisDriveMaxCurrentTimeout, Settings.talonTimeOut);
		

		navx = new AHRS(SPI.Port.kMXP);
    }
}