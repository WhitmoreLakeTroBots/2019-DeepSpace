package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class cmdInvertDriveAuto extends Command{

    public cmdInvertDriveAuto(){
        requires(Robot.subChassis);
    }

    @Override
    protected void initialize() {
        Robot.subChassis.Drive(0, 0);
    }

    @Override
    protected void execute() {
        if(Robot.isDriveInverted){
            Robot.isDriveInverted = false;
          // Robot.navxOffset = 180;
            Robot.invertedSplineDirection = -1;
        } else {
            Robot.isDriveInverted = true;
            Robot.navxOffset = 0;
            Robot.invertedSplineDirection = 1;
        }
        System.err.println("Drive inverted. isDriveInverted is now set to " + Robot.isDriveInverted);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        Robot.subChassis.Drive(0, 0);
    }

    @Override
    protected void interrupted() {
        Robot.subChassis.Drive(0, 0);
    }
}