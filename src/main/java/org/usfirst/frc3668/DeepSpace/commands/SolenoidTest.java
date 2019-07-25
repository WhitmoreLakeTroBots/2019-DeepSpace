
package org.usfirst.frc3668.DeepSpace.commands;

import org.usfirst.frc3668.DeepSpace.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SolenoidTest extends Command {
  public SolenoidTest() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  // RobotMap.solo.set(DoubleSolenoid.Value.kOff);
    RobotMap.han.set(false);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    RobotMap.han.set(true);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
