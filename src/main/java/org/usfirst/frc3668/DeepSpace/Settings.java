package org.usfirst.frc3668.DeepSpace;

public class Settings {
    
    public static final double chassisWheelbaseWidth = 0.7;
    public static final int magneticEncoderTicsPerRevolution = 4096;
    public static final int talonTimeOut = 10;
    public static final double chassisWheelDiameter = 0.203; //meters; 8 inches
    public static final int chassisDriveMaxCurrentLimit = 55;
    public static final int chassisDriveMaxCurrentTimeout = 500;
    public static final double chassisTurnKp = 0.005;
    public static final double chassisTurnKi = 0.0001;
    public static final double chassisTurnkd = 0.001;
    public static final double chassisGyroTol = 1.0;

    //Lift settings
    public static final double liftMaxSpeed = 0.335;
    public static final double liftCalibrateThrottle = -0.1;
    public static final int liftTicsPerRevolution = 1440;
    
    public static final double frontLiftManThrottle = 0.5;
    public static final double liftKp = 0.0;
    public static final double liftKi = 0.0;
    public static final double liftKd = 0.0;

    //liftDrive Settings
    public static final int liftDriveTicsPerRevolution = 189;
    public static final double liftDriveThrottle = 0.75;

    //Tail Settings
    public static final int tailTicks = 1316;
    public static final double tailRaiseThrottle = 1.0;
    public static final double tailCalibrateThrottle = -0.1;
    
    //Swing settings
    public static final double swingHome = 0;
    public static final double swingLowTrac = 15;
    public static final double swingLowOmni = -15;
    public static final double swingMedTrac = 45;
    public static final double swingMedOmni = -45;
    public static final double swingHighOmni = 120; 

    //Intake settings
    public static final double intakeInThrottle = 1.0;
    public static final double intakeOutThrottle = -1.0;

    //Head Settings
    public static final double headThrottleUP = -0.6;
    public static final double headThrottleDOWN = 0.4;
    public static final double headSlowThreshold = 15;
    public static final double headSlowScalar = 0.4;
    public static final double headWindow = 1.5;

    public static final double cargoOffset0 = 0;
    public static final double cargoOffset90 = 90;
    public static final double cargoOffsetNeg90 = -90;
    public static final double cargoOffsetPickCargo = 45;
    

    //Hatch Manipulator
    public static final double hatchThrottle = 0.9;
   
    //Cargo Maniplulator
    
    public static final double cargoInThrottle = 1.0;
    public static final double cargoOutThrottle = -1.0;

    //Auto Settings
    public static final double autoTurnSpeed = 0.15; //0.12 for tile;
    public static final double autoProfileDriveSpeed = 3.683; //In meters from 145 inches


    //Profile Settings
    public static final String profileTestLogName = "logs\\motionProfileTestResults";
    public static final String profileLogName = "//media//sda1//motionProfile";
    public static final String profileLogFileExtension = ".txt";
    public static final double profileDriveKp = 0.1;
	public static final double profileDriveKi = 0.003;
    public static final double profileDriveKd = 0.0004;
    
    //Test Settings
    public static final double delayMiliseconds = 24;
    
    //Limelight Settings
    public static final double limelightH2T = -0.3806;
    public static final double limelightAngleOffset = 1.1605;
    public static final double limelightHorzAngleScalar = 0.7655808619;
    public static final double llDefaultAngle = 99.00;
    public static final double llAecseptableAngle = 27;
    public static final double llDistanceOffset = 0.00;
    public static final double lmDefaultAngle = 99.00;
    public static final double lmAecseptableAngle = 27;
    public static final double lmDistantceOffset = 0.00;
    public static final double lmH2T = -0.3786;
    public static final double lmAngleOffset =1.1605;
    public static final double lmHorzAngleScalar = 0.765808619;

    //Spline Settings
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