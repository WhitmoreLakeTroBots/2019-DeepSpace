package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupPlaceCargo extends CommandGroup {

    public cmdGroupPlaceCargo(String splineFile) {
        if (Robot.isDriveInverted) {
            addSequential(new cmdSplineFollowerOmni(splineFile));
        } else {
            addSequential(new cmdSplineFollowerTrac(splineFile));
        }
        addSequential(new cmdInvertDriveAuto());
        // place hatch commands
    }
}