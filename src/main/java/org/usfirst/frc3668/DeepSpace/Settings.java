package org.usfirst.frc3668.DeepSpace;

public class Settings {
    
    public static final double chassisWheelbaseWidth = 0.7;
    public static final double magneticEncoderTicsPerRevolution = 4096.0;
    public static final int talonTimeOut = 10;
    public static final double chassisWheelDiameter = 0.2032; //meters; 8 inches
    public static final int chassisDriveMaxCurrentLimit = 55;
    public static final int chassisDriveMaxCurrentTimeout = 500;
    public static final double chassisTurnKp = 0.007;
    public static final double chassisTurnKi = 0.0001;
    public static final double chassisTurnkd = 0.001;
    public static final double chassisGyroTol = 1.0;

    //Lift settings
    public static final double liftMaxSpeed = 0.335;
    public static final double liftThrottle = 1;
    public static final double liftCalibrateThrottle = -0.1;
    public static final int liftTicsPerRevolution = 1440;
    
    public static final double frontLiftManThrottle = 1.0;
    public static final double liftKp = 0.0;
    public static final double liftKi = 0.0;
    public static final double liftKd = 0.0;

    //liftDrive Settings
    public static final int liftDriveTicsPerRevolution = 189;
    public static final double liftDriveThrottle = 0.75;

    //Tail Settings
    public static final int tailTicks = 1316;
    public static final double tailRaiseThrottle = 0.5;
    public static final double tailCalibrateThrottle = -0.1;
    
    //Swing settings
    public static final double swingHome = 0;
    public static final double swingCargoIntake = 22;
    public static final double swingLowTracHatch = 55;
    public static final double swingLowOmniHatch = -50;
    public static final double swingLowTracCargo = 75;
    public static final double swingLowOmniCargo = -110;
    public static final double swingHighOmni = 120; 

    public static final double cargoAdjustOmni = 5;
    public static final double cargoAdjustTrac = -5;

    //Cargo Offsets
    public static final double cargoOffsetHome = 0;
    public static final double cargoOffsetTracParrallel = -83; //account for sag in the mech
    public static final double cargoOffsetOmniParrallel = 83; //account for sag in the mech
    public static final double cargoOffsetPickCargo = -65;
    public static final double cargoOffsetPlaceCargoOmni = 170;
    public static final double cargoOffsetPlaceCargoTrac = 0;

    //Intake settings
    public static final double intakeInThrottle = 1.0;
    public static final double intakeOutThrottle = -1.0;
    public static final double intakeUpThrottle = 1.0;
    public static final double intakeDownThrottle = -1.0;

    //Head Settings
    public static final double headThrottleUP = 0.75;
    public static final double headThrottleDOWN = -0.75;
    public static final double headSlowThreshold = 15;
    public static final double headSlowScalar = 0.4;
    public static final double headWindow = 1.5;
    

    //Hatch Manipulator
    public static final double hatchThrottle = -0.9;

    //Spark MAX settings
    public static final int maxOutput = 1;
    public static final int minOutput = 0;
   
    //Cargo Maniplulator
    
    public static final double cargoInThrottle = -1.0;
    public static final double cargoOutThrottle = 1.0;

    //Auto Settings
    public static final double autoTurnSpeed = 0.3; //0.12 for tile;
    public static final double autoProfileDriveSpeed = 3.683; //In meters from 145 inches


    //Profile Settings
    public static final String profileTestLogName = "logs\\motionProfileTestResults";
    public static final String profileLogName = "//media//sda1//motionProfile";
    public static final String profileLogFileExtension = ".txt";
    public static final double profileDriveKp = 0.25;
	public static final double profileDriveKi = 0.01;
    public static final double profileDriveKd = 0.0008;
    
    //Test Settings
    public static final double delayMiliseconds = 24;
    
    //Limelight Settings
    public static final double llProcess = 0;
    public static final double llDriveCam = 1;

    public static final double loH2T = 0.3806;
    public static final double loAngleOffset = -20.212014;//-22.26957;//-18.7748;
    public static final double loHorzAngleScalar = 0.7655808619;
    public static final double loDefaultAngle = 99.00;
    public static final double loAecseptableAngle = 27;
    public static final double loDistanceOffset = 1;

    public static final double ltDefaultAngle = 99.00;
    public static final double ltAecseptableAngle = 27;
    public static final double ltH2T = 0.3786;
    public static final double ltAngleOffset = -28.445842; //a = arctan(H2T/x) + llAngle
    public static final double ltHorzAngleScalar =  1.00;//0.7655808619;
    public static final double ltDistanceOffset = 1;

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
        moveArm, placeHatch, graspHatch, placeCargo, graspCargo, invertDrive, splineOmni, splineTrac, switchPipelines
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
    public static final String startCenterR = "_StartCenterR";
    public static final String startCenterL = "_StartCenterL";
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

    public static final String test1 = "_StartCenterL_CSCL";
    public static final String test2 = "_test2";
    public static final String bend1 = "_BendTest";

    public static final String llPipesLeft = "1|1|";
    public static final String llPipesRight = "2|2|";
}