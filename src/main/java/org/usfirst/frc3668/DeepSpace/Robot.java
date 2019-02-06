package org.usfirst.frc3668.DeepSpace;

import org.usfirst.frc3668.DeepSpace.subsystems.subCargo;
import org.usfirst.frc3668.DeepSpace.subsystems.subChassis;
import org.usfirst.frc3668.DeepSpace.subsystems.subHatch;
import org.usfirst.frc3668.DeepSpace.subsystems.subLift;
import org.usfirst.frc3668.DeepSpace.subsystems.subTail;
import org.usfirst.frc3668.DeepSpace.commands.cmdGroupAutoTemplate;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
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
    public static subCargo subCargo;
    public static subHatch subHatch;
    public static RobotMap RobotMap;
    public static subTail subTail;
    public static boolean isDriveInverted = true;

    public static NetworkTableInstance inst = null;
    public static NetworkTable table = null;
    public static NetworkTableEntry llx = null;
    public static NetworkTableEntry lly = null;
    public static NetworkTableEntry lla = null;
    public static NetworkTableEntry llv = null;
    public static NetworkTableEntry lls = null;
    public static NetworkTableEntry lll = null;
    public static NetworkTableEntry xEntry;
    public static NetworkTableEntry yEntry;
    public static NetworkTableEntry blink = null;
    public static NetworkTableEntry on = null;
    public static NetworkTableEntry Off = null;

    public static NetworkTable piTab = null;
    public static NetworkTableEntry pix = null;
    public static NetworkTableEntry piy = null;
    public static NetworkTableEntry pia = null;
    public static NetworkTableEntry piv = null;
    public static NetworkTableEntry pis = null;
    public static NetworkTableEntry pil = null;

    public static double x = 0;
    public static double y = 0;
    
    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap = new RobotMap();
        RobotMap.init();

        subChassis = new subChassis();
        subChassis.resetNavx();
        subLift = new subLift();
        subCargo = new subCargo();
        subHatch = new subHatch();
        subTail = new subTail();

        inst = NetworkTableInstance.getDefault();
        table = inst.getTable("limelight-test");
        llx = table.getEntry("tx");
        lly = table.getEntry("ty");
        lla = table.getEntry("ta");
        llv = table.getEntry("tv");
        lls = table.getEntry("ts");
        lll = table.getEntry("tl");
    
        piTab = inst.getTable("limelight-pi");
        pix = piTab.getEntry("tx");
        piy = piTab.getEntry("ty");
        pia = piTab.getEntry("ta");
        piv = piTab.getEntry("tv");
        pis = piTab.getEntry("ts");
        pil = piTab.getEntry("tl");

        oi = new OI();

        startChooser.addOption("Center", Settings.startLocation.center);
        startChooser.addOption("Left", Settings.startLocation.left);
        startChooser.addOption("Right", Settings.startLocation.right);
        startChooser.addOption("Test", Settings.startLocation.test);

        startGameChooser.addOption("Hatch", Settings.gameElementType.hatch);
        startGameChooser.addOption("Cargo", Settings.gameElementType.cargo);
        startGameChooser.addOption("Test", Settings.gameElementType.test);

        firstLocChooser.addOption("CS Center Left", Settings.locations.CSCL);
        firstLocChooser.addOption("CS Center Right", Settings.locations.CSCR);
        firstLocChooser.addOption("Test", Settings.locations.test);

        secondGameTypeChooser.addOption("Hatch", Settings.gameElementType.hatch);
        secondGameTypeChooser.addOption("Cargo", Settings.gameElementType.cargo);
        secondGameTypeChooser.addOption("Test", Settings.gameElementType.test);

        secondLocChooser.addOption("CS Center Left", Settings.locations.CSCL);
        secondLocChooser.addOption("CS Center Right", Settings.locations.CSCR);
        secondLocChooser.addOption("Test", Settings.locations.test);

        SmartDashboard.putData("Start Location", startChooser);
        SmartDashboard.putData("Start Game Type", startGameChooser);
        SmartDashboard.putData("First Destentation", firstLocChooser);
        SmartDashboard.putData("Second Game Type", secondGameTypeChooser);
        SmartDashboard.putData("Second Location", secondLocChooser);
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

        Settings.actions[] actions = new Settings.actions[3];

        String[] parameters = new String[3];
        parameters[0] = Settings.filePerfix;
        parameters[1] = Settings.filePerfix;
        parameters[2] = Settings.filePerfix;

        switch (startLoc) {
        case center:
            parameters[0] = parameters[0] + Settings.startCenter;
            break;
        case left:
            parameters[0] = parameters[0] + Settings.startLeft;
            break;
        case right:
            parameters[0] = parameters[0] + Settings.startRight;
            break;
        case test:
            parameters[0] = parameters[0] + Settings.test1;
            parameters[2] = parameters[2] + Settings.test1;
            actions[0] = Settings.actions.spline;
            actions[1] = Settings.actions.invertDrive;
            actions[2] = Settings.actions.spline;
        }

        switch (firstLoc) {
        case CSCL:
            parameters[0] = parameters[0] + Settings.cargoCenterLeft;
            parameters[1] = parameters[1] + Settings.cargoCenterLeft;
            break;
        case CSCR:
            parameters[0] = parameters[0] + Settings.cargoCenterRight;
            parameters[1] = parameters[1] + Settings.cargoCenterRight;
            break;
        case test:
            break;
        }

        switch (secondGameType) {
        case hatch:
            if (firstLoc == Settings.locations.CSCL) {
                parameters[1] = parameters[1] + Settings.loadStationLeft;
            } else if (firstLoc == Settings.locations.CSCR) {
                parameters[1] = parameters[1] + Settings.loadStationRight;
            }
            break;
        case cargo:
            if (firstLoc == Settings.locations.CSCL) {
                parameters[1] = parameters[1] + Settings.depotCargoLeft;
                parameters[2] = parameters[2] + Settings.depotCargoLeft;
            } else if (firstLoc == Settings.locations.CSCR) {
                parameters[1] = parameters[1] + Settings.depotCargoRight;
                parameters[2] = parameters[2] + Settings.depotCargoRight;
            }
            break;
        case test:
            break;
        }

        switch (secondLoc) {
            case CSCL:
                parameters[2] = parameters[2] + Settings.cargoCenterLeft;
                break;
            case CSCR:
                parameters[2] = parameters[2] + Settings.cargoCenterRight;
            case test:
                break;
        }
        parameters[0] = parameters[0] + Settings.fileExt;
        parameters[1] = parameters[1] + Settings.fileExt;
        parameters[2] = parameters[2] + Settings.fileExt;

        autonomousCommand = new cmdGroupAutoTemplate(actions, parameters);

        if (autonomousCommand != null)
            autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
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
        x = llx.getDouble(Settings.llDefaultAngle);
        y = lly.getDouble(Settings.llDefaultAngle);
        SmartDashboard.putNumber("llx", x);
        SmartDashboard.putNumber("lly", y);
        SmartDashboard.putNumber("lld", RobotMath.calcLimeDist(y));
        SmartDashboard.putNumber("pix", pix.getDouble(Settings.llDefaultAngle));
        SmartDashboard.putNumber("piy", piy.getDouble(Settings.llDefaultAngle));
       // xEntry.setDouble(x);
       // yEntry.setDouble(y); 
    }
    @Override
    public void teleopPeriodic() {
        update_smartDashboard();
        Scheduler.getInstance().run();
    }
}
