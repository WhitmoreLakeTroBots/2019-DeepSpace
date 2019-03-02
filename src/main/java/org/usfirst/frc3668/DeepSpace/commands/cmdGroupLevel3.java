package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Settings;
import org.usfirst.frc3668.DeepSpace.commands.cmdLiftDrive;
import org.usfirst.frc3668.DeepSpace.commands.cmdRaise;
import org.usfirst.frc3668.DeepSpace.commands.cmdMoveFrontLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupLevel3 extends CommandGroup {

    public final double level3ProfileVelocity = 2.0;
    public final double level3ProfileDist = 0.3;
    public final int liftDriveLevel3Tics = 1000;

    public cmdGroupLevel3 (){
        addSequential(new cmdRaise());
        //addSequential(new cmdLiftDrive(liftDriveLevel3Tics, Settings.liftDriveThrottle));
        //addSequential(new cmdMoveFrontLift(0, Settings.frontLiftManThrottle));
        //addSequential(new cmdProfileDrive(level3ProfileVelocity, level3ProfileDist));
    }
}
