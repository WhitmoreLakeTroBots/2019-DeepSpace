package org.usfirst.frc3668.DeepSpace.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3668.DeepSpace.*;

public class cmdJoySwing extends Command {

    public cmdJoySwing() {
        requires(Robot.subSwing);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double y = Robot.oi.joyArt.getY();
        if(Math.abs(y) < Robot.subChassis.joyDriveDeadband){
            y = 0;
        }
        y = y * Settings.swingMaxThrottle;
        Robot.subSwing.setSwingMotor(y);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.subSwing.setSwingMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.subSwing.setSwingMotor(0);
    }
}
