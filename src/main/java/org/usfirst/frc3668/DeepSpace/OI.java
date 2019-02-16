// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3668.DeepSpace;

import org.usfirst.frc3668.DeepSpace.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
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
    public final int joyDriveDock = 1;
    public final int joyDriveInvertDrive = 2;
    public final int joyDriveLevel3 = 12;
    public final int joyDriveLevel2 = 11;
    public final int joyDriveIntakeIn = 3;
    public final int joyDriveIntakeOut = 5;
    public final int joyDriveCargoIn = 4;
    public final int joyDriveCargoOut = 6;
    public final int joyArtPort = 1;
    public final int joyArtSwingHome = 9;
    public final int joyArtSwingLowTrac = 7;
    public final int joyArtSwingLowOnmi = 11;
    public final int joyArtSwingMedTrac = 8; 
    public final int joyArtSwingMedOmni = 12;
    public final int joyArtSwingHighOmni = 10;
    public final int joyArtOffset90 = 5;
    public final int joyArtOffset0 = 6;
    public final int joyArtOffsetNeg90 = 3;
    public final int joyArtHatch = 4;

    public Joystick joyDrive = new Joystick(joyDrivePort);
    public Button dock = new JoystickButton(joyDrive, joyDriveDock);
    public Button invertDrive = new JoystickButton(joyDrive, joyDriveInvertDrive);
    public Button level3 = new JoystickButton(joyDrive, joyDriveLevel3);
    public Button level2 = new JoystickButton(joyDrive, joyDriveLevel2);
    public Button intakeIn = new JoystickButton(joyDrive, joyDriveIntakeIn);
    public Button intakeOut = new JoystickButton(joyDrive, joyDriveIntakeOut);
    public Button cargoIn = new JoystickButton(joyDrive, joyDriveCargoIn);
    public Button cargoOut = new JoystickButton(joyDrive, joyDriveCargoOut);

    public Joystick joyArt = new Joystick(joyArtPort);
    public Button swingHome = new JoystickButton(joyArt,joyArtSwingHome);
    public Button swingLowTrac = new JoystickButton(joyArt,joyArtSwingLowTrac);
    public Button swingLowOmni = new JoystickButton(joyArt,joyArtSwingLowOnmi);
    public Button swingMedTrac = new JoystickButton(joyArt,joyArtSwingMedTrac);
    public Button swingMedOmni = new JoystickButton(joyArt,joyArtSwingMedOmni);
    public Button swingHighOmni = new JoystickButton(joyArt,joyArtSwingHighOmni);
    public Button cargoOffset0 = new JoystickButton(joyArt,joyArtOffset0);
    public Button cargoOffset90 = new JoystickButton(joyArt,joyArtOffset90);
    public Button cargoOffsetNeg90 = new JoystickButton(joyArt,joyArtOffsetNeg90);
    public Button hatch = new JoystickButton(joyArt, joyArtHatch);

    public Button TEMP = new JoystickButton(joyArt, 1);
    public Button TEMP2 = new JoystickButton(joyArt, 2);

    public OI() {
        dock.whenPressed(new cmdGroupDock());

        invertDrive.whenPressed(new cmdInvertDriveAuto());

        level3.whenPressed(new cmdGroupLevel3());
        level2.whenPressed(new cmdGroupLevel2());

        intakeIn.whileHeld(new cmdIntake(Settings.intakeInThrottle));
        intakeOut.whileHeld(new cmdIntake(Settings.intakeOutThrottle));

        cargoIn.whileHeld(new cmdHeadCargo(Settings.cargoInThrottle));
        cargoOut.whileHeld(new cmdHeadCargo(Settings.cargoOutThrottle));

        swingHome.whenPressed(new cmdSwing(Settings.swingHome));
        swingLowTrac.whenPressed(new cmdSwing(Settings.swingLowTrac));
        swingLowOmni.whenPressed(new cmdSwing(Settings.swingLowOmni));
        swingMedTrac.whenPressed(new cmdSwing(Settings.swingMedTrac));
        swingMedOmni.whenPressed(new cmdSwing(Settings.swingMedOmni));
        swingHighOmni.whenPressed(new cmdSwing(Settings.swingHighOmni));

        cargoOffset90.whenPressed(new cmdSetCargoOffset(Settings.cargoOffset90));
        cargoOffsetNeg90.whenPressed(new cmdSetCargoOffset(Settings.cargoOffsetNeg90));
        cargoOffset0.whenPressed(new cmdSetCargoOffset(Settings.cargoOffset0));
        hatch.whenPressed(new cmdGraspHatch(Settings.hatchThrottle));

        TEMP.whenPressed(new cmdGroupSwingHead(45, 63));
        TEMP2.whenPressed(new cmdGroupHeadSwing(0, 0));
    }
}

