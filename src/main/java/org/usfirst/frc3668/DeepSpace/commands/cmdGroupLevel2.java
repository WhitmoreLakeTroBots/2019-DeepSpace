package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupLevel2 extends CommandGroup {
    public cmdGroupLevel2 (){
        addSequential(new cmdMoveFrontLift(Settings.level2FrontLiftTics, Settings.frontLiftManThrottle));
        //Add more code here
    }
}