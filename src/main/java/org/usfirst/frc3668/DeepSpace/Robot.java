package org.usfirst.frc3668.DeepSpace;


import org.usfirst.frc3668.DeepSpace.commands.cmdGroupAutoTemplate;
import org.usfirst.frc3668.DeepSpace.subsystems.subChassis;
import org.usfirst.frc3668.DeepSpace.subsystems.subHead;
import org.usfirst.frc3668.DeepSpace.subsystems.subIntake;
import org.usfirst.frc3668.DeepSpace.subsystems.subLift;
import org.usfirst.frc3668.DeepSpace.subsystems.subSwing;
import org.usfirst.frc3668.DeepSpace.subsystems.subTail;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

    static Command autonomousCommand;

    static SendableChooser<Settings.startLocation> startChooser = new SendableChooser<>();
    static SendableChooser<Settings.gameElementType> startGameChooser = new SendableChooser<>();
    static SendableChooser<Settings.locations> firstLocChooser = new SendableChooser<>();
    static SendableChooser<Settings.gameElementType> secondGameTypeChooser = new SendableChooser<>();
    static SendableChooser<Settings.locations> secondLocChooser = new SendableChooser<>();

    public static OI oi;
    public static subChassis subChassis;
    public static subLift subLift;
    public static subHead subHead;
    public static RobotMap RobotMap;
    public static subTail subTail;
    public static subSwing subSwing;
    public static subIntake subIntake;

    public static boolean isDriveInverted = false;
    public static double navxOffset = 0.0;
    public static int invertedSplineDirection = 1;
    public static double headHoldAngle = 0;
    public static double swingHoldAngle = 0;

    public static NetworkTableInstance inst = null;
    public static NetworkTable OmniTable = null;
    public static NetworkTableEntry lox = null;
    public static NetworkTableEntry loy = null;
    public static NetworkTableEntry loa = null;
    public static NetworkTableEntry lov = null;
    public static NetworkTableEntry los = null;
    public static NetworkTableEntry lol = null;
    public static NetworkTableEntry locm = null;
    public static NetworkTableEntry lolm = null;
    public static NetworkTableEntry lop = null;
    public static NetworkTable TracTable = null;
    public static NetworkTableEntry ltx = null;
    public static NetworkTableEntry lty = null;
    public static NetworkTableEntry lta = null;
    public static NetworkTableEntry ltv = null;
    public static NetworkTableEntry lts = null;
    public static NetworkTableEntry ltl = null;
    public static NetworkTableEntry ltcm = null;
    public static NetworkTableEntry ltlm = null;
    public static NetworkTableEntry ltp = null;
    public static double ox = 0;
    public static double oy = 0;
    public static double tx = 0;
    public static double ty = 0;
    public static double llCamMode = 0;
    //public static double Compressor = 0;
    

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap = new RobotMap();
        RobotMap.init();

        subChassis = new subChassis();
        subLift = new subLift();
        subHead = new subHead();
        subTail = new subTail();
        subSwing = new subSwing();
        subIntake = new subIntake();
         
        



       
        inst = NetworkTableInstance.getDefault();
        OmniTable = inst.getTable("limelight-omni");
        lox = OmniTable.getEntry("tx");
        loy = OmniTable.getEntry("ty");
        loa = OmniTable.getEntry("ta");
        lov = OmniTable.getEntry("tv");
        los = OmniTable.getEntry("ts");
        lol = OmniTable.getEntry("tl");
        locm = OmniTable.getEntry("camMode");
        lolm = OmniTable.getEntry("ledMode");
        lop = OmniTable.getEntry("pipeline");

        TracTable = inst.getTable("limelight-trac");
        ltx = TracTable.getEntry("tx");
        lty = TracTable.getEntry("ty");
        lta = TracTable.getEntry("ta");
        ltv = TracTable.getEntry("tv");
        lts = TracTable.getEntry("ts");
        ltl = TracTable.getEntry("tl");
        ltcm = TracTable.getEntry("camMode");
        ltlm = TracTable.getEntry("ledMode");
        ltp = TracTable.getEntry("pipeline");

        oi = new OI();

        startChooser.addOption("Center", Settings.startLocation.center);
        startChooser.addOption("Left", Settings.startLocation.left);
        startChooser.addOption("Right", Settings.startLocation.right);
        startChooser.addOption("Test", Settings.startLocation.test);

        startGameChooser.addOption("Hatch", Settings.gameElementType.hatch);
        startGameChooser.addOption("Cargo", Settings.gameElementType.cargo);
        startGameChooser.addOption("Teleop", Settings.gameElementType.teleop);

        firstLocChooser.addOption("CS Center Left", Settings.locations.CSCL);
        firstLocChooser.addOption("CS Center Right", Settings.locations.CSCR);
        firstLocChooser.addOption("Teleop", Settings.locations.teleop);

        secondGameTypeChooser.addOption("Hatch", Settings.gameElementType.hatch);
        secondGameTypeChooser.addOption("Cargo", Settings.gameElementType.cargo);
        secondGameTypeChooser.addOption("Teleop", Settings.gameElementType.teleop);

        secondLocChooser.addOption("CS Center Left", Settings.locations.CSCL);
        secondLocChooser.addOption("CS Center Right", Settings.locations.CSCR);
        secondLocChooser.addOption("Teleop", Settings.locations.teleop);

        SmartDashboard.putData("Start Location", startChooser);
        SmartDashboard.putData("Start Game Type", startGameChooser);
        SmartDashboard.putData("First Destentation", firstLocChooser);
        SmartDashboard.putData("Second Game Type", secondGameTypeChooser);
        SmartDashboard.putData("Second Location", secondLocChooser);

        lop.setNumber(0);
        ltp.setNumber(1);
    }

    /**
     * This function is called when the disabled button is hit. You can use it to
     * reset subsystems before shutting down.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        update_smartDashboard();
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        Settings.startLocation startLoc = startChooser.getSelected();
        Settings.gameElementType startGameType = startGameChooser.getSelected();
        Settings.locations firstLoc = firstLocChooser.getSelected();
        Settings.gameElementType secondGameType = secondGameTypeChooser.getSelected();
        Settings.locations secondLoc = secondLocChooser.getSelected();

        Settings.actions[] actions = new Settings.actions[4];

        String[] parameters = new String[4];
        parameters[0] = Settings.filePerfix;
        parameters[1] = Settings.filePerfix;
        parameters[2] = Settings.filePerfix;
        parameters[3] = Settings.filePerfix;

        switch (startLoc) {
        case center:
            parameters[1] = parameters[1] + Settings.startCenter;
            break;
        case left:
            parameters[1] = parameters[1] + Settings.startLeft;
            break;
        case right:
            parameters[1] = parameters[1] + Settings.startRight;
            break;
        case test:
            //actions[0] = Settings.actions.switchPipelines;
            //parameters[0] = Settings.llPipesRight;
            //parameters[1] = parameters[1] + Settings.startCenterL + Settings.cargoCenterLeft;
            //actions[1] = Settings.actions.splineOmni;
            break;
        }

        switch (startGameType) {
        case hatch:
            actions[1] = Settings.actions.splineOmni;
            break;
        case cargo:
            actions[1] = Settings.actions.placeCargo;
            break;
        case teleop:
            break;
        }

        switch (firstLoc) {
        case CSCL:
            actions[0] = Settings.actions.switchPipelines;
            parameters[0] = Settings.llPipesLeft;
            if(startLoc == Settings.startLocation.center){
                parameters[1] = Settings.filePerfix + Settings.startCenterL;
            }
            parameters[1] = parameters[1] + Settings.cargoCenterLeft;
            break;
        case CSCR:
            actions[0] = Settings.actions.switchPipelines;
            parameters[0] = Settings.llPipesRight;
            parameters[1] = parameters[1] + Settings.cargoCenterRight;
            if(startLoc == Settings.startLocation.center){
                parameters[1] = Settings.filePerfix + Settings.startCenterR;
            }
            break;
        case teleop:
            break;
        }

        switch (secondGameType) {
        case hatch:
            if (firstLoc == Settings.locations.CSCL) {
                parameters[2] = parameters[2] + Settings.loadStationLeft;
            } else if (firstLoc == Settings.locations.CSCR) {
                parameters[2] = parameters[2] + Settings.loadStationRight;
            }
            actions[2] = Settings.actions.placeHatch;
            break;
        case cargo:
            if (firstLoc == Settings.locations.CSCL) {
                parameters[2] = parameters[2] + Settings.depotCargoLeft;
                parameters[3] = parameters[3] + Settings.depotCargoLeft;
            } else if (firstLoc == Settings.locations.CSCR) {
                parameters[2] = parameters[2] + Settings.depotCargoRight;
                parameters[3] = parameters[3] + Settings.depotCargoRight;
            }
            actions[2] = Settings.actions.placeCargo;
            break;
        case teleop:
            break;
        }

        switch (secondLoc) {
        case CSCL:
            parameters[3] = parameters[3] + Settings.cargoCenterLeft;
            break;
        case CSCR:
            parameters[3] = parameters[3] + Settings.cargoCenterRight;
        case teleop:
            break;
        }

        parameters[0] = parameters[0] + Settings.fileExt;
        parameters[1] = parameters[1] + Settings.fileExt;
        parameters[2] = parameters[2] + Settings.fileExt;
        parameters[3] = parameters[3] + Settings.fileExt;

        autonomousCommand = new cmdGroupAutoTemplate(actions, parameters);

        if (autonomousCommand != null)
            autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        update_smartDashboard();
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
            autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */

    public void update_smartDashboard() {
        ox = lox.getDouble(Settings.loDefaultAngle) * Settings.loHorzAngleScalar;
        oy = loy.getDouble(Settings.loDefaultAngle);
        tx = ltx.getDouble(Settings.ltDefaultAngle) * Settings.ltHorzAngleScalar;
        ty = lty.getDouble(Settings.ltDefaultAngle);
        SmartDashboard.putNumber("lox", ox);
        SmartDashboard.putNumber("loy", oy);
        SmartDashboard.putNumber("lod", RobotMath.calcLimeOmniDist(oy));
        SmartDashboard.putNumber("ltx", tx);
        SmartDashboard.putNumber("lty", ty);
        SmartDashboard.putNumber("ltd", RobotMath.calcLimeTracDist(ty));
        SmartDashboard.putNumber("NavX", Robot.subChassis.getNormaliziedNavxAngle());
        // xEntry.setDouble(x);
        // yEntry.setDouble(y);
    }

    @Override
    public void teleopPeriodic() {
        update_smartDashboard();
        Scheduler.getInstance().run();
    }
}
