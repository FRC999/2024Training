// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
//import frc.robot.subsystems.DriveSubsystem;
//_commented out because it isn't used. technically should be there but wtvr

public class DriveManuallyCommand extends Command {
  /** Creates a new DriveManuallyCommand. */
  public DriveManuallyCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    //_depends on driveSubsystem for commands
    addRequirements(RobotContainer.driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //_on initial schedule, begins brakemode (makes it stop when joystick is let go of)
    RobotContainer.driveSubsystem.driveTrainBrakeMode();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //_on every 20ms cycle, checks joystick for position
    double move = RobotContainer.driveStick.getX();
    //_y is inverted due to the joystick using aviator controls
    double turn = RobotContainer.driveStick.getY()*(-1);

    //_sends the joystick pos to arcadeDrive in driveSubsystem
    RobotContainer.driveSubsystem.manualDrive(move, turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
