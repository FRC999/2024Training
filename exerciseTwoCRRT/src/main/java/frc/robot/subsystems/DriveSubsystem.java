// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  public WPI_TalonSRX motor;

  public DriveSubsystem() {

    motor = new WPI_TalonSRX(Constants.OperatorConstants.MOTOR_ID);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runMotor() {
    motor.set(ControlMode.PercentOutput, Constants.OperatorConstants.SPEED);
  }

  public void stopMotor() {
    motor.set(ControlMode.PercentOutput, Constants.OperatorConstants.STOP_SPEED);
  }
}
