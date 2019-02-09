package org.usfirst.frc3668.DeepSpace.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupPlaceHatch extends CommandGroup {

    public cmdGroupPlaceHatch(String splineFile){
        addSequential(new cmdSplineFollower(splineFile));
        //addSequential(new cmdInvertDriveAuto());
        addSequential(new cmdGroupDock());
        //place hatch commands
    }
}