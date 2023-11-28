// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.OperatorConstants;;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  private final TalonFX motor;
  public DriveSubsystem() {
    motor = new TalonFX(Constants.OperatorConstants.motorID);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  } 

  public void startMotor() {
    motor.set(ControlMode.PercentOutput, Constants.OperatorConstants.motorSpeed);
  }

  public void stopMotor() {
    motor.set(ControlMode.PercentOutput, 0.0);
  }
}