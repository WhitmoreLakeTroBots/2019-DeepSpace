package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class cmdInvertDriveAuto extends Command{

    public cmdInvertDriveAuto(){
    }

    @Override
    protected void initialize() {
        requires(Robot.subChassis);
        Robot.subChassis.Drive(0, 0);
    }

    @Override
    protected void execute() {
        if(Robot.isDriveInverted){
            Robot.isDriveInverted = false;
        } else {
            Robot.isDriveInverted = true;
        }
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