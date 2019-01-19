package org.usfirst.frc3668.DeepSpace.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupPlaceCargo extends CommandGroup {

    public cmdGroupPlaceCargo(String splineFile){
        addSequential(new cmdSplineFollower(splineFile));
        addSequential(new cmdInvertDriveAuto());
        //place hatch commands
    }
}