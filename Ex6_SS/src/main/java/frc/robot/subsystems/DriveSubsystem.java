// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  private static WPI_TalonFX motor;
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    motor = new WPI_TalonFX(Constants.OperatorConstants.MOTER_ID);
  }

  public void startMotor() {
    motor.set(ControlMode.PercentOutput, Constants.OperatorConstants.MOTOR_START_SPEED);
  }

  public void stopMotor() {
    motor.set(ControlMode.PercentOutput, Constants.OperatorConstants.MOTOR_STOP_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
