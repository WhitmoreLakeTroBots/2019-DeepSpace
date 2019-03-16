package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class cmdInvertDriveAuto extends Command {

    protected boolean useABS = false;
    protected boolean absVal;

    protected double omniNavXOffset = 0;
    protected double tracNavXOffset = 180;
    protected double omniSplineDir = 1;
    protected double tracSplineDir = 0;

    public cmdInvertDriveAuto() {
        requires(Robot.subChassis);
    }

    public cmdInvertDriveAuto(boolean invertAbsolute) {
        useABS = true;
        absVal = invertAbsolute;
        requires(Robot.subChassis);
    }

    @Override
    protected void initialize() {
        Robot.subChassis.Drive(0, 0);
    }

    @Override
    protected void execute() {
        if (useABS) {
            Robot.isDriveInverted = absVal;
            if (Robot.isDriveInverted) {
                setOffsets(0, -1);
            } else {
                setOffsets(0, 1);
            }
        } else {
            if (Robot.isDriveInverted) {
                Robot.isDriveInverted = false;
                setOffsets(180, -1);
            } else {
                Robot.isDriveInverted = true;
                setOffsets(0, 1);
            }
        }
        System.err.println("Drive inverted. isDriveInverted is now set to " + Robot.isDriveInverted);
    }

    protected void setOffsets(double navX, int splineDir){
        Robot.navxOffset = navX;
        Robot.invertedSplineDirection = splineDir;
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