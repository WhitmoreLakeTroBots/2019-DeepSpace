package org.usfirst.frc3668.DeepSpace;

public class Settings {	
    public static final double joyDriveDeadband = 0.05;
    public static final double chassisRightSideScalar = 1;
    public static final double chassisLeftSideScalar = 1;
    public static final boolean chassisSquareJoyInput = true;
    public static final int chassisEncoderTicsPerRevolution = 4096;
    public static final int talonTimeOut = 10;
    public static final double chassisWheelDiameter = 0.203; //meters; 8 inches
    public static final double chassisEncoderDistancePerPulse = (chassisWheelDiameter * Math.PI) / chassisEncoderTicsPerRevolution;
    public static final int chassisRightDrive1CanID = 1;
	public static final int chassisRightDrive2CanID = 2;
	public static final int chassisLeftDrive1CanID = 3;
    public static final int chassisLeftDrive2CanID = 4;
    public static final int chassisDriveMaxCurrentLimit = 55;
    public static final int chassisDriveMaxCurrentTimeout = 500;
    public static final double chassisEncoderDeadValueThreshold = 0.5;
    public static final double splineKp = 0.1;
    public static final double splineKi = 0.00;
    public static final double splineKd = 0.000;
    public static final double splineKf = 0;
    public static final double maxVelocity = 4.667;
    public static final double maxAccel = 3;
    public static final double maxJerk = 5;
    public static final double chassisTurnScalar = -0.015;

    //Interface Settings
    public static final int joyDrivePort = 0;
    public static final int joyArtPort = 0;

    //Spline Files
    public static final String test1 = "//home//lvuser//deploy//test_00.cvs";
}