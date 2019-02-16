package org.usfirst.frc3668.DeepSpace.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupHeadSwing extends CommandGroup {

    public cmdGroupHeadSwing(double swingAngle, double headAngle){
        addSequential(new cmdRotateHead(headAngle));
        addSequential(new cmdSwing(swingAngle));
    }
}