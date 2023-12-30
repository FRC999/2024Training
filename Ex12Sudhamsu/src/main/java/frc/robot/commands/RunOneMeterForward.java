// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class RunOneMeterForward extends CommandBase {
  private double startingEncoder;
  private double endingEncoder;
  private double startingAngle;
  private double endingAngle;
  // Creates a PIDController with gains kP, kI, and kD
  private PIDController pid ;
  private PIDController pidTurn;

  public double error;
  public double tolerance = Constants.OperatorConstants.ENCODER_CHANGE_PER_METER*0.03;

  /** Creates a new RunOneMeterForward. */
  public RunOneMeterForward() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveSubsystem);
    pid = new PIDController(Constants.OperatorConstants.kP,
            Constants.OperatorConstants.kI,
            Constants.OperatorConstants.kD);

    pidTurn = new PIDController(Constants.OperatorConstants.TurnkP,
                                Constants.OperatorConstants.TurnkI,
                                Constants.OperatorConstants.TurnkD);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startingAngle = 0.0;
    endingAngle = 0.0;
    startingEncoder = RobotContainer.driveSubsystem.getRightEncoder();
    endingEncoder = startingEncoder + Constants.OperatorConstants.ENCODER_CHANGE_PER_METER*3;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double power = pid.calculate(RobotContainer.driveSubsystem.getRightEncoder(), endingEncoder);
    double turn = pidTurn.calculate(RobotContainer.pigeonIMUSubsystem.getYaw(), endingAngle);
    if(power > 1) {
      power = 1;
    }
    //System.out.println("Power: " + power);
    RobotContainer.driveSubsystem.manualDrive(turn, power*0.5);
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
    error  = Math.abs((startingEncoder + Constants.OperatorConstants.ENCODER_CHANGE_PER_METER*3) - RobotContainer.driveSubsystem.getRightEncoder());

    if(error <= tolerance) {
      return true;
    }
    else {
      return false;
    }
  }
}
