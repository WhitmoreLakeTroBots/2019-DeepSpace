package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Settings;
import org.usfirst.frc3668.DeepSpace.commands.cmdLiftDrive;
import org.usfirst.frc3668.DeepSpace.commands.cmdRaise;
import org.usfirst.frc3668.DeepSpace.commands.cmdMoveFrontLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class cmdGroupLevel3 extends CommandGroup {
    public cmdGroupLevel3 (){
        addSequential(new cmdRaise());
        // addSequential(new cmdLiftDrive(Settings.liftDriveLevel3Tics, Settings.liftDriveThrottle));
        // addSequential(new cmdMoveFrontLift(0, Settings.frontLiftManThrottle));
        // addSequential(new cmdProfileDrive(Settings.level3ProfileVelocity, Settings.level3ProfileDist));
    }
}
