package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupLevel2 extends CommandGroup {

    public final int level2FrontLiftTics = 1000;
    public final int liftDriveLevel2Tics = 346;
    public static final double level2ProfileDist = 0.508;
    public static final double level2SecondProfileDist = 1.016;

    public cmdGroupLevel2 (){        
        addSequential(new cmdRaise());
		addSequential(new cmdLiftDrive(liftDriveLevel2Tics, Settings.liftDriveThrottle));
        //addSequential(new cmdMoveFrontLift(0, Settings.frontLiftManThrottle));
        //Add more code here
    }
}