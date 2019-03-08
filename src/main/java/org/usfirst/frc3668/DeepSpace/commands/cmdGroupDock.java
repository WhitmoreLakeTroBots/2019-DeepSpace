package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupDock extends CommandGroup {

    public cmdGroupDock() {
        addSequential(new cmdSwitchLLVision(0));
        addSequential(new cmdTurnGyro(Settings.autoTurnSpeed, true));
        addSequential(new cmdProfileDrive(Settings.autoProfileDriveSpeed, true));
    }
}