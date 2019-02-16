package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.PID;
import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Command;

public class cmdRaise extends Command {
    boolean bDone = false;
    PID pid;
    double endThershold = -93;

    public cmdRaise() {
        requires(Robot.subLift);
        requires(Robot.subTail);
        requires(Robot.subChassis);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        pid = new PID(Settings.liftKp, Settings.liftKi, Settings.liftKd);
        bDone = false;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double tailThrottle = Settings.tailRaiseThrottle;
        double frontLiftSpeed = Robot.subTail.calcFrontLiftSpeed(tailThrottle);
        double pidVal = pid.calcError(Settings.liftElevationTargetAngle, Robot.subLift.getRobotPitch());
        frontLiftSpeed = frontLiftSpeed + pidVal;
        //Robot.subLift.setLiftMotor(-frontLiftSpeed / Settings.liftMaxSpeed);
        Robot.subLift.setLiftMotor(Math.abs(frontLiftSpeed));
        Robot.subTail.setTail(tailThrottle);
        System.err.println("Front Lift Encoder: " + Robot.subLift.getLiftEncoderTics() + " Lift Encoder Meters: " + Robot.subLift.getLiftEncoderMeters() + " Tail Angle: " + Robot.subTail.getTailAngle());
        if(Robot.subTail.getTailAngle() < endThershold){
            System.err.println("cmdRaise is done");
            bDone = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return bDone;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.subLift.setLiftMotor(0);
        Robot.subTail.setTail(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}