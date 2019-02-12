package org.usfirst.frc3668.DeepSpace;

public class Settings {
    public static final double joyDriveDeadband = 0.05;
    public static final double chassisWheelbaseWidth = 0.7;
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
    public static final double chassisTurnKp = 0.005;
    public static final double chassisTurnKi = 0.0001;
    public static final double chassisTurnkd = 0.001;
    public static final double chassisGyroTol = 1.0;

    //Lift settings
    public static final int frontLiftCanID = 7;
    public static final double liftMaxSpeed = 0.335;
    public static final double frontLiftManThrottle = 0.5;
    public static final int frontLiftManWindow = 15;
    public static final int frontLiftSlowThreshold = 200;
    public static final double frontLiftManSlowScalar = 0.4;
    public static final double liftElevationTargetAngle = 0;
    public static final double liftKp = 0.0;
    public static final double liftKi = 0.0;
    public static final double liftKd = 0.0;

    //liftDrive Settings
    public static final int liftDriveCanID = 13;
    public static final int liftDriveTicsPerRevolution = 189;
    public static final int liftDriveLevel3Tics = 1000;
    public static final double liftDriveThrottle = 0.75;

    //Tail Settings
    public static final int tailCanID = 5;
    public static final int tailTicks = 1316;
    public static final double tailTicksPerDeg = 6.8541666;
    public static final double tailRaiseThrottle = 1.0;
    public static final double tailMaxTipSpeed = 0.51816;
    public static final double tailLength = 0.508;
    public static final int tailEncoderDIOPortA = 0;
    public static final int tailEncoderDIOPortB = 1;

    //Swing settings
    public static final int swingRotationCanID = 6;
    public static final double swingDegreesPerTic = 0.00497332; //360 / (17.672 gear ratio * 4096 tics per revoltion)
    public static final double swingThrottleUP = 0.5;
    public static final double swingThrottleDOWN = -swingThrottleUP;
    public static final double swingWindow = 1.5;
    public static final double swingSlowThreshold = 15;
    public static final double swingSlowScalar = 0.5;

    public static final double swingHome = 0;
    public static final double swingLowTrac = 15;
    public static final double swingLowOmni = -15;
    public static final double swingMedTrac = 45;
    public static final double swingMedOmni = -45;
    public static final double swingHighOmni = 120; 

    //Intake settings
    public static final int intakeRotationCanID = 8;
    public static final int intakeCanID = 9;
    public static final double intakeInThrottle = 1.0;
    public static final double intakeOutThrottle = -1.0;

    //Head Settings
    public static final int headRotationCanID = 10;
    public static final double headRotationDegreesPerTic = 0.25777; //360 degrees / (497 tics per rev motor * 2.81 gear ratio)
    public static final double headThrottleUP = 0.5;
    public static final double headThrottleDOWN = -headThrottleUP;
    public static final double headSlowThreshold = 15;
    public static final double headSlowScalar = 0.4;
    public static final double headWindow = 1.5;

    public static final double cargoOffset90 = 90;
    public static final double cargoOffsetNeg90 = -90;
    

    //Hatch Manipulator
    public static final int hatchManipulatorCanID = 11;
    public static final double hatchThrottle = 0.9;
    public static final int hatchSlowThreshold = 100;
    public static final double hatchSlowScalar = 0.75;
    public static final int hatchWindow = 5;
    public static final int hatchClosedTics = 525;
    public static final int hatchOpenTics = 0;
    public static final int hatchDIOPortA = 2;
    public static final int hatchDIOPortB = 3;
   

    //Cargo Maniplulator
    public static final int cargoManipulatorCanID = 12;
    public static final double cargoInThrottle = 1.0;
    public static final double cargoOutThrottle = -1.0;
    
    //Interface Settings
    public static final int joyDrivePort = 0;
    public static final int joyDriveDock = 1;
    public static final int joyDriveInvertDrive = 2;
    public static final int joyDriveLevel3 = 12;
    public static final int joyDriveLevel2 = 11;
    public static final int joyDriveIntakeIn = 3;
    public static final int joyDriveIntakeOut = 5;
    public static final int joyDriveCargoIn = 4;
    public static final int joyDriveCargoOut = 6;
    public static final int joyArtPort = 1;
    public static final int joyArtSwingHome = 9;
    public static final int joyArtSwingLowTrac = 7;
    public static final int joyArtSwingLowOnmi = 11;
    public static final int joyArtSwingMedTrac = 12; 
    public static final int joyArtSwingMedOmni = 8;
    public static final int joyArtSwingHighOmni = 10;
    public static final int joyArtOffset90 = 5;
    public static final int joyArtOffsetNeg90 = 3;
    public static final int hatchManipulatorButton = 4;
    public static final int hatchManipulatorButtonTwo = 6;

    //Auto Settings
    public static final double autoTurnSpeed = 0.15; //0.12 for tile;
    public static final double autoProfileDriveSpeed = 3.683; //In meters from 145 inches

    //Level 3 Settings
    public static final double level3ProfileVelocity = 0.4;
    public static final double level3ProfileDist = 0.3;

    //Level 2 Settings
    public static final int level2FrontLiftTics = 1000;

    //Profile Settings
    public static final String profileTestLogName = "logs\\motionProfileTestResults";
    public static final String profileLogName = "//media//sda1//motionProfile";
    public static final String profileLogFileExtension = ".txt";
    public static final double profileDriveKp = 0.1;
	public static final double profileDriveKi = 0.003;
    public static final double profileDriveKd = 0.0004;
    public static final double profileDriveStraightGyroKp = -0.005;
    public static final double profileMovementThreshold = 0.02;
    public static final double profileInitVelocity = 0.0;
    public static final double profileEndTimeScalar = 1.3;
    public static final double profileDriveAccelration = 1.50; // meters/sec/sec 

    //Test Settings
    public static final double delayMiliseconds = 24;
    
    //Limelight Settings
    public static final double limelightH2T = -0.3806;
    public static final double limelightAngleOffset = 1.1605;
    public static final double limelightHorzAngleScalar = 0.7655808619;
    public static final double llDefaultAngle = 99.00;
    public static final double llAecseptableAngle = 27;
    public static final double llDistanceOffset = 0.00;

    //Spline Settings
    public static final double splineOmniKp = 0.0075;
    public static final double splineOmniKi = 0.0055;
    public static final double splineOmniKd = 0.00425;
    public static final double splineOmniKf = 0.00;
    public static final double splineOmniTurnScalar = 0.0125;
    public static final double splineTracKp = 0.015;
    public static final double splineTracKi = 0.005;
    public static final double splineTracKd = 0.005;
    public static final double splineTracKf = 0.00;
    public static final double splineTracTurnScalar = 0.025;
    public static final double maxVelocity = 4.667;
    public static final double maxAccel = 2;
    public static final double maxJerk = 5;

    //temp placement


    //Auto Enums
    public static enum chassisTurnDirection {
		turnRight, turnLeft
	}

    public enum actions{
        moveArm, placeHatch, graspHatch, placeCargo, graspCargo, invertDrive, splineOmni, splineTrac
    }

    public enum startLocation{
        left, right, center, test
    }

    public enum locations{
        CSCL, CSCR, CSL1, CSL2, CSL3, CSR1, CSR2, CSR3, LSL, LSR, DCL, DCR, teleop
    }

    public enum gameElementType{
        cargo, hatch, teleop
    }

    //Spline Files
    public static final String filePerfix = "/home/lvuser/deploy/Spline";

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

    public static final String test1 = "_test";
    public static final String test2 = "_test2";
}