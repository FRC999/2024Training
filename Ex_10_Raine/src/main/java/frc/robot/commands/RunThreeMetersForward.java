// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class RunThreeMetersForward extends CommandBase {
  private double startingEncoder;
  private double endingEncoder;

  // Creates a PIDController with gains kP, kI, and kD
  private PIDController pid ;
  //  Creates a new RunThreeMetersForward.
  public RunThreeMetersForward() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveSubsystem);
    pid = new PIDController(Constants.OperatorConstants.kP,
            Constants.OperatorConstants.kI,
            Constants.OperatorConstants.kD);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startingEncoder = RobotContainer.driveSubsystem.getRightEncoder();
    endingEncoder = startingEncoder + Constants.OperatorConstants.ENCODER_CHANGE_PER_METER;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double power = pid.calculate(RobotContainer.driveSubsystem.getRightEncoder(), endingEncoder);
    //System.out.println("Power: " + power);
    RobotContainer.driveSubsystem.manualDrive(0, power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Drive ended: " + interrupted);
    RobotContainer.driveSubsystem.manualDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}