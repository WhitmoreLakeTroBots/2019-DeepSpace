package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.RobotMath;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class cmdGroupDock extends CommandGroup {

    public cmdGroupDock() {
        addSequential(new cmdTurnGyro(Settings.autoTurnSpeed, true));
        addSequential(new cmdProfileDrive(Settings.autoProfileDriveSpeed, true));
    }
}