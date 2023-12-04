// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveManualCommand extends CommandBase {
  /** Creates a new DriveYAxisManual. */
  public DriveManualCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  double move;
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {   

    move = RobotContainer.joystick.getY();
    RobotContainer.driveSubsystem.setSpeed(move);
    RobotContainer.driveSubsystem.joystickDrive(move);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}