// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class RunMeterForwardHardwarePID extends CommandBase {
  private DoubleSupplier leftEncoder;
  private DoubleSupplier rightEncoder;

  private double initialLeft;
  private double initialRight;
  /** Creates a new RunMeterForwardHardwarePID. */
  public RunMeterForwardHardwarePID() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveSubsystem);
  }

  public RunMeterForwardHardwarePID(DoubleSupplier lE, DoubleSupplier rE) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveSubsystem);
    leftEncoder = lE;
    rightEncoder = rE;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initialLeft = leftEncoder.getAsDouble();
    initialRight = rightEncoder.getAsDouble();

    RobotContainer.driveSubsystem.runMotorPIDLeft(initialLeft - Constants.OperatorConstants.ENCODER_CHANGE_PER_METER);
    RobotContainer.driveSubsystem.runMotorPIDRight(initialRight + Constants.OperatorConstants.ENCODER_CHANGE_PER_METER);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveSubsystem.endPIDLeft();
    RobotContainer.driveSubsystem.endPIDRight();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
