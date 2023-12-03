// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class MotorSubsystem extends SubsystemBase {
  private WPI_TalonSRX talonMotor;
  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {
    talonMotor = new WPI_TalonSRX(Constants.OperatorConstants.MOTOR_CONTROLLER_PORT);
  }

  public void startMotor() {
    talonMotor.set(ControlMode.PercentOutput, Constants.OperatorConstants.MOTPOWER_START);
  }

  public void stopMotor() {
    talonMotor.set(ControlMode.PercentOutput, Constants.OperatorConstants.MOTPOWER_END);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
