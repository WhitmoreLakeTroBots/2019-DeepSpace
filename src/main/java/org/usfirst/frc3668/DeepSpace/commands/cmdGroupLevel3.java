package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Settings;
import org.usfirst.frc3668.DeepSpace.commands.cmdLiftDrive;
import org.usfirst.frc3668.DeepSpace.commands.cmdRaise;
import org.usfirst.frc3668.DeepSpace.commands.cmdRetractFrontLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupLevel3 extends CommandGroup {
    public cmdGroupLevel3 (){
        addSequential(new cmdRaise());
        addSequential(new cmdLiftDrive());
        addSequential(new cmdRetractFrontLift());
        addSequential(new cmdProfileDrive(0, 0));
    }
}
