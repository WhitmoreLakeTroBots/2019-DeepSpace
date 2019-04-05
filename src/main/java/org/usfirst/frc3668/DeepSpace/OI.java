package org.usfirst.frc3668.DeepSpace;

import org.usfirst.frc3668.DeepSpace.commands.cmdGraspHatch;
import org.usfirst.frc3668.DeepSpace.commands.cmdGroupDock;
import org.usfirst.frc3668.DeepSpace.commands.cmdGroupHeadSwing;
import org.usfirst.frc3668.DeepSpace.commands.cmdGroupSwingHead;
import org.usfirst.frc3668.DeepSpace.commands.cmdHeadCargo;
import org.usfirst.frc3668.DeepSpace.commands.cmdIntake;
import org.usfirst.frc3668.DeepSpace.commands.cmdManTail;
import org.usfirst.frc3668.DeepSpace.commands.cmdInvertDriveAuto;
import org.usfirst.frc3668.DeepSpace.commands.cmdMoveFrontLift;
import org.usfirst.frc3668.DeepSpace.commands.cmdSetCargoOffset;
import org.usfirst.frc3668.DeepSpace.commands.cmdSwitchLLVision;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    //Interface Settings
    public final int joyDrivePort = 0;
    public final int joyDriveDock = 6;
    public final int joyDriveInvertDrive = 2;
    public final int joyDriveExtendTail = 9;
    public final int joyDriveExtendLiftLevel3 = 11;
    public final int joyDriveExtendLiftLevel2 = 12;
    public final int joyDriveRetractLift = 7;
    public final int joyDriveRetractTail = 8;
    public final int joyDriveLiftDrive = 10;
    public final int joyDriveIntakeIn = 3;
    public final int joyDriveIntakeOut = 5;
    public final int joyDriveVision = 1;

    public final int joyArtPort = 1;
    public final int joyArtSwingHome = 9;
    public final int joyArtCargoPick = 10;
    public final int joyArtCargoTracCS = 8; 
    public final int joyArtCargoOmniCS = 12;
    public final int joyArtCargoOmniRocketTier1 = 11;
    public final int joyArtCargoTracRocketTier1 = 7;
    public final int joyArtCargoOmniRocketTier2 = 4;
    public final int joyArtCargoOmniRocketTier3 = 6;
    public final int joyArtCargoOut = 5;
    public final int joyArtCargoIn = 3;
    public final int joyArtHatch = 1;

    public final int joyArt2Port = 2;
    public final int joyArt2AdjustTrac = 3;
    public final int joyArt2AdjustOmni = 5;
    public final int joyArt2Hatch = 4;
    public final int joyArt2Hatch2 = 1;
    public final int joyArt2Home = 9;
    public final int joyArt2OmniTier3Hatch = 8;
    public final int joyArt2OmniTier2Hatch = 10;
    public final int joyArt2OmniTier1Hatch = 12;

    public Joystick joyDrive = new Joystick(joyDrivePort);
    public Button dock = new JoystickButton(joyDrive, joyDriveDock);
    public Button invertDrive = new JoystickButton(joyDrive, joyDriveInvertDrive);
    public Button extendTail = new JoystickButton(joyDrive, joyDriveExtendTail);
    public Button retractTail = new JoystickButton(joyDrive, joyDriveRetractTail);
    public Button extendLiftLevel3 = new JoystickButton(joyDrive, joyDriveExtendLiftLevel3);
    public Button extendLiftLevel2 = new JoystickButton(joyDrive, joyDriveExtendLiftLevel2);
    public Button intakeIn = new JoystickButton(joyDrive, joyDriveIntakeIn);
    public Button intakeOut = new JoystickButton(joyDrive, joyDriveIntakeOut);
    public Button switchVision = new JoystickButton(joyDrive, joyDriveVision);
    public Button liftDrive = new JoystickButton(joyDrive, joyDriveLiftDrive);
    public Button retractLift = new JoystickButton(joyDrive, joyDriveRetractLift);

    public Joystick joyArt = new Joystick(joyArtPort);
    public Button cargoIn = new JoystickButton(joyArt, joyArtCargoIn);
    public Button cargoOut = new JoystickButton(joyArt, joyArtCargoOut);
    public Button swingHome = new JoystickButton(joyArt,joyArtSwingHome);
    public Button pickCargo = new JoystickButton(joyArt, joyArtCargoPick);
    public Button cargoTracCS = new JoystickButton(joyArt,joyArtCargoTracCS);
    public Button cargoTracRocketTier1 = new JoystickButton(joyArt, joyArtCargoTracRocketTier1);
    public Button cargoOmniCS = new JoystickButton(joyArt,joyArtCargoOmniCS);
    public Button cargoOmniRocketTier1 = new JoystickButton(joyArt, joyArtCargoOmniRocketTier1);
    public Button cargoOmniRocketTier2 = new JoystickButton(joyArt, joyArtCargoOmniRocketTier2);
    public Button cargoOmniRocketTier3 = new JoystickButton(joyArt, joyArtCargoOmniRocketTier3);
    public Button hatch = new JoystickButton(joyArt, joyArtHatch);

    public Joystick joyArt2 = new Joystick(joyArt2Port);
    public Button headAdjustOmni = new JoystickButton(joyArt2, joyArt2AdjustOmni);
    public Button headAdjustTrac = new JoystickButton(joyArt2, joyArt2AdjustTrac);
    public Button artHatch = new JoystickButton(joyArt2, joyArt2Hatch);
    public Button artHatch2 = new JoystickButton(joyArt2, joyArt2Hatch2);
    public Button swingHome2 = new JoystickButton(joyArt2, joyArt2Home);
    public Button omniTier1Hatch = new JoystickButton(joyArt2, joyArt2OmniTier1Hatch);
    public Button onmiTier2Hatch = new JoystickButton(joyArt2, joyArt2OmniTier2Hatch);
    public Button onmiTier3Hatch = new JoystickButton(joyArt2, joyArt2OmniTier3Hatch);

    public OI() {
        //joyDrive
        dock.whenPressed(new cmdGroupDock());

        invertDrive.whenPressed(new cmdInvertDriveAuto());

        extendLiftLevel3.whenPressed(new cmdMoveFrontLift(Robot.subLift.liftHieghttoLevel3/Robot.subLift.liftMetersPerTic, Settings.liftThrottle));
        extendLiftLevel2.whenPressed(new cmdMoveFrontLift(Robot.subLift.liftHieghttoLevel2/Robot.subLift.liftMetersPerTic, Settings.liftThrottle));
        retractLift.whenPressed(new cmdMoveFrontLift(0, Settings.liftThrottle));

        extendTail.whenPressed(new cmdManTail(Robot.subTail.tailLength, Settings.tailRaiseThrottle));
        //retractTail.whenPressed(new cmdManTail(0, Settings.tailRaiseThrottle));

        intakeIn.whileHeld(new cmdIntake(Settings.intakeInThrottle));
        intakeOut.whileHeld(new cmdIntake(Settings.intakeOutThrottle));

        //joyArt
        swingHome.whenPressed(new cmdGroupHeadSwing(Settings.swingHome, Settings.headOffsetHome));

        cargoIn.whileHeld(new cmdHeadCargo(Settings.cargoInThrottle));
        cargoOut.whileHeld(new cmdHeadCargo(Settings.cargoOutThrottle));
        pickCargo.whenPressed(new cmdGroupSwingHead(Settings.swingCargoIntake, Settings.headOffsetPickCargo));
        omniTier1Hatch.whenPressed(new cmdGroupSwingHead(Settings.swingOmniTier1Hatch, Settings.headOffsetOmniParrallel));
        cargoTracCS.whenPressed(new cmdGroupSwingHead(Settings.swingTracCargoCS, Settings.headOffsetTracCargoCS));
        cargoOmniCS.whenPressed(new cmdGroupSwingHead(Settings.swingOmniCargoCS, Settings.headOffsetOmniCargoCS));

        hatch.whenPressed(new cmdGraspHatch(Settings.hatchThrottle));
        switchVision.whenPressed(new cmdSwitchLLVision());

        //joyArt2
        headAdjustOmni.whenPressed(new cmdSetCargoOffset(Settings.cargoAdjustOmni, true));
        headAdjustTrac.whenPressed(new cmdSetCargoOffset(Settings.cargoAdjustTrac, true));

        artHatch.whenPressed(new cmdGraspHatch(Settings.hatchThrottle));

        swingHome2.whenPressed(new cmdGroupHeadSwing(Settings.swingHome, Settings.headOffsetHome));
    }
}

