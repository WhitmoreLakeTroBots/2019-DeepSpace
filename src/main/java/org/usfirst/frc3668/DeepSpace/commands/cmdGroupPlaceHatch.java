package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupPlaceHatch extends CommandGroup {

    public cmdGroupPlaceHatch(String splineFile){
        addSequential(new cmdSplineBenderOmni(splineFile));
        addParallel(new cmdGroupSwingHead(Settings.swingOmniTier1Hatch, Settings.headOffsetOmniParrallel));
        addSequential(new cmdGraspHatch(Settings.hatchThrottle));
    }
}