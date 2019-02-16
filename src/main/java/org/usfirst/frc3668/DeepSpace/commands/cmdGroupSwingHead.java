package org.usfirst.frc3668.DeepSpace.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupSwingHead extends CommandGroup {

    public cmdGroupSwingHead(double swingAngle, double cargoOffset){
        addSequential(new cmdSwing(swingAngle));
        addSequential(new cmdSetCargoOffset(cargoOffset));
    }
}