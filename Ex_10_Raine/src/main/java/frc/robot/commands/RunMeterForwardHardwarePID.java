// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class RunMeterForwardHardwarePID extends CommandBase {
  private DoubleSupplier leftEncoder;
  private DoubleSupplier rightEncoder;
  

  public static double initialLeft;
  public static double initialRight;
  public double error;
  public double tolerance = Constants.OperatorConstants.ENCODER_CHANGE_PER_METER*0.03;
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

    PIDController pid = new PIDController(kD,kI,kP);

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
    System.out.println("Command ended: " + interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    error  = Math.abs((initialRight + Constants.OperatorConstants.ENCODER_CHANGE_PER_METER) - RobotContainer.driveSubsystem.getRightEncoder());

    if(error <= tolerance) {
      return true;
    }
    else {
      return false;
    }
  }
}