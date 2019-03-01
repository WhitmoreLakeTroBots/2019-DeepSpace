package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.Robot;
import org.usfirst.frc3668.DeepSpace.Settings;

import edu.wpi.first.wpilibj.command.Command;

public class cmdCalibrateLiftTail extends Command {
    boolean bDone = false;
    int tailTol = 10;
    int liftTol = 10;
    double tailTolCount;
    double liftTolCount;
    double tailThrottle;
    double liftThrottle;
    int tailNeededLoops = 5;
    int liftNeededLoops = 5;
    double lastTailTics;
    int lastLiftTics;

    public cmdCalibrateLiftTail(double tailThrottle, double liftThrottle) {
        this.tailThrottle = tailThrottle;
        this.liftThrottle = liftThrottle;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        bDone = false;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double tailRev = Robot.subTail.getTailEncoderRevs();
        int liftTics = (int) Robot.subLift.getLiftEncoderTics();

        if (tailTolCount < tailNeededLoops) {
            Robot.subTail.setTail(tailThrottle);
        }
        if (liftTolCount < liftNeededLoops) {
            Robot.subLift.setLiftMotor(liftThrottle);
        }

        if (inTolerance(tailRev, lastTailTics, tailTol)){
            tailTolCount++;
        } else {
            tailTolCount = 0;
        }

        if (inTolerance(liftTics, lastLiftTics, liftTol)){
            liftTolCount ++;
        } else {
            liftTolCount = 0;
        }

        lastTailTics = tailRev;
        lastLiftTics = liftTics;

        if (tailTolCount > tailNeededLoops && liftTolCount < liftNeededLoops) {
            Robot.subTail.resetTailEncoder();
            Robot.subLift.resetLiftEncoder();
            bDone = true;
        }
    }

    protected boolean inTolerance(double value, double target, double tol) {
        if (value >= (target - tol) && value <= (target + tol)) {
            return true;
        } else {
            return false;
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