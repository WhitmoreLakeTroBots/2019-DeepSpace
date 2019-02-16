package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupLevel2 extends CommandGroup {
    public cmdGroupLevel2 (){
        addSequential(new cmdMoveFrontLift(Settings.level2FrontLiftTics, Settings.frontLiftManThrottle));
        addSequential(new cmdProfileDrive(Settings.autoProfileDriveSpeed, Settings.level2ProfileDist));
        addSequential(new cmdMoveFrontLift(0, Settings.frontLiftManThrottle));
        addSequential(new cmdProfileDrive(Settings.autoProfileDriveSpeed, Settings.level2SecondProfileDist));
    }
}