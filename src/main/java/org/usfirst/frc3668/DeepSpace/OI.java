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
    public final int joyArtSwingCargo = 2;
    public final int joyArtSwingLowTracHatch = 7; 
    public final int joyArtSwingLowOnmiHatch = 11;
    public final int joyArtSwingLowTracCargo = 8; 
    public final int joyArtSwingLowOmniCargo = 12;
    public final int joyArtSwingHighOmni = 10;
    public final int joyArtOffset90 = 5;
    public final int joyArtOffsetHome = 6;
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

    public Button driveTEMP = new JoystickButton(joyDrive, 7);

    public Joystick joyArt = new Joystick(joyArtPort);
    public Button swingHome = new JoystickButton(joyArt,joyArtSwingHome);
    public Button swingPickCargo = new JoystickButton(joyArt, joyArtSwingCargo);
    public Button swingLowTracHatch = new JoystickButton(joyArt,joyArtSwingLowTracHatch);
    public Button swingLowOmniHatch = new JoystickButton(joyArt,joyArtSwingLowOnmiHatch);
    public Button swingLowTracCargo = new JoystickButton(joyArt,joyArtSwingLowTracCargo);
    public Button swingLowOmniCargo = new JoystickButton(joyArt,joyArtSwingLowOmniCargo);
    public Button swingHighOmni = new JoystickButton(joyArt,joyArtSwingHighOmni);
    public Button cargoOffsetHome = new JoystickButton(joyArt,joyArtOffsetHome);
    public Button cargoOffsetTracParrallel = new JoystickButton(joyArt,joyArtOffset90);
    public Button cargoOffsetOmniParrallel = new JoystickButton(joyArt,joyArtOffsetNeg90);
    public Button hatch = new JoystickButton(joyArt, joyArtHatch);

    public OI() {
        dock.whenPressed(new cmdGroupDock());

        invertDrive.whenPressed(new cmdInvertDriveAuto());

        level3.whenPressed(new cmdGroupLevel3());
        level2.whenPressed(new cmdGroupLevel2());

        intakeIn.whileHeld(new cmdIntake(Settings.intakeInThrottle));
        intakeOut.whileHeld(new cmdIntake(Settings.intakeOutThrottle));

        cargoIn.whileHeld(new cmdHeadCargo(Settings.cargoInThrottle));
        cargoOut.whileHeld(new cmdHeadCargo(Settings.cargoOutThrottle));

        swingHome.whenPressed(new cmdGroupHeadSwing(Settings.swingHome, Settings.cargoOffsetHome));
        swingPickCargo.whenPressed(new cmdGroupSwingHead(Settings.swingCargoIntake, Settings.cargoOffsetPickCargo));
        swingLowTracHatch.whenPressed(new cmdGroupSwingHead(Settings.swingLowTracHatch, Settings.cargoOffsetTracParrallel));
        swingLowOmniHatch.whenPressed(new cmdGroupSwingHead(Settings.swingLowOmniHatch, Settings.cargoOffsetOmniParrallel));
        swingLowTracCargo.whenPressed(new cmdGroupSwingHead(Settings.swingLowTracCargo, Settings.cargoOffsetPlaceCargoTrac));
        swingLowOmniCargo.whenPressed(new cmdGroupSwingHead(Settings.swingLowOmniCargo, Settings.cargoOffsetPlaceCargoOmni));

        cargoOffsetTracParrallel.whenPressed(new cmdSetCargoOffset(Settings.cargoOffsetTracParrallel));
        cargoOffsetOmniParrallel.whenPressed(new cmdSetCargoOffset(Settings.cargoOffsetOmniParrallel));
        cargoOffsetHome.whenPressed(new cmdSetCargoOffset(Settings.cargoOffsetHome));

        hatch.whenPressed(new cmdGraspHatch(Settings.hatchThrottle));
        
        //driveTEMP.whenPressed(new cmdGroupSwingHead(-110, -170));
    }
}

