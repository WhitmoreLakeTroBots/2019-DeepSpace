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
    public static final double chassisTurnKp = 0.003;
    public static final double chassisGyroTol = 1.5;

    //Interface Settings
    public static final int joyDrivePort = 0;
    public static final int joyDriveDock = 1;
    public static final int joyArtPort = 1;

    //Auto Settings
    public static final double autoTurnSpeed = -0.23; //0.12 for tile;
    public static final double autoProfileDriveSpeed = 1.00;//3.683; //In meters from 145 inches

    public static enum chassisTurnDirection {
		turnRight, turnLeft
	}

    public enum actions{
        moveArm, placeHatch, graspHatch, placeCargo, graspCargo, invertDrive, spline
    }

    public enum startLocation{
        left, right, center
    }

    public enum locations{
        CSCL, CSCR, CSL1, CSL2, CSL3, CSR1, CSR2, CSR3, LSL, LSR, DCL, DCR
    }

    public enum gameElementType{
        cargo, hatch
    }

    //Profile Settings
    public static final String profileTestLogName = "logs\\motionProfileTestResults";
    public static final String profileLogName = "//media//sda1//motionProfile";
    public static final String profileLogFileExtension = ".txt";
    public static final double profileDriveKp = 0.2;
	public static final double profileDriveKi = 0.003;
    public static final double profileDriveKd = 0.0010;
    public static final double profileDriveStraightGyroKp = -0.10;
    public static final double profileMovementThreshold = 0.02;
    public static final double profileInitVelocity = 0.0;
    public static final double profileEndTimeScalar = 1.3;
    public static final double profileDriveAccelration = 3.00; // meters/sec/sec 

    //Test Settings
    public static final double delayMiliseconds = 24;
    
    //Limelight Settings
    public static final double limelightH2T = 0.534;

    //Spline Settings
    public static final double splineKp = 0.2;
    public static final double splineKi = 0.01;
    public static final double splineKd = 0.00;
    public static final double splineKf = 0.01;
    public static final double maxVelocity = 4.667;
    public static final double maxAccel = 3;
    public static final double maxJerk = 5;
    public static final double splineTurnScalar = -0.001;

    //Spline Files
    public static final String filePerfix = "//home//lvuser//deploy//Spline";

    public static final String startCenter = "_StartCenter";
    public static final String startLeft = "_StartLeft";
    public static final String startRight = "_StartRight";

    public static final String cargoCenterLeft = "_CSCL";
    public static final String cargoCenterRight = "_CSCR";
    public static final String cargoShipLeft1 = "_CSL1";
    public static final String cargoShipLeft2 = "_CSL2";
    public static final String cargoShipLeft3 = "_CSL3";
    public static final String cargoShipRight1 = "_CSR1";
    public static final String cargoShipRight2 = "_CSR2";
    public static final String cargoShipRight3 = "_CSR3";

    public static final String loadStationLeft = "_LSL";
    public static final String loadStationRight = "_LSR";

    public static final String depotCargoLeft = "_DCL";
    public static final String depotCargoRight = "_DCR";

    public static final String fileExt = ".cvs";

    public static final String test1 = filePerfix + "test_00.cvs";
}