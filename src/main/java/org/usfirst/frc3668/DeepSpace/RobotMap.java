package org.usfirst.frc3668.DeepSpace;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;

public class RobotMap {
    public static TalonSRX rightDrive1;
    public static TalonSRX rightDrive2;
    public static TalonSRX leftDrive1;
    public static TalonSRX leftDrive2;
    public static AHRS navx;

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

		navx = new AHRS(SPI.Port.kMXP);
    }
}