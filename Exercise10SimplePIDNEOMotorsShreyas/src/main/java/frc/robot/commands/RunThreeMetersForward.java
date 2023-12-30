// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.hal.simulation.ConstBufferCallback;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class RunThreeMetersForward extends CommandBase {
  public double startEncoder;
  public double endEncoder;
  private PIDController proportionalIntegralDerivative;
  /** Creates a new RunThreeMetersForward. */
  public RunThreeMetersForward() {
    addRequirements(RobotContainer.driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
    proportionalIntegralDerivative=new PIDController(
                                  Constants.OperatorConstants.kP, 
                                  Constants.OperatorConstants.kI, 
                                  Constants.OperatorConstants.kD
                                  );
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startEncoder = RobotContainer.driveSubsystem.getRightEncoder();
    final double initialValue = startEncoder;
    endEncoder = initialValue + Constants.OperatorConstants.UNITSPERMETER;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double move = proportionalIntegralDerivative.calculate(RobotContainer.driveSubsystem.getRightEncoder(), endEncoder);
    double error = endEncoder - RobotContainer.driveSubsystem.getRightEncoder();
    RobotContainer.driveSubsystem.manualDrive(0, move);
    System.out.println("Error and Power:" + error + " " + move);
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
