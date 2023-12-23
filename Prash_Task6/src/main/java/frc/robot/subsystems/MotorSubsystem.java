// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorSubsystem extends SubsystemBase {

  public WPI_TalonSRX talonMotor = new WPI_TalonSRX(Constants.OperatorConstants.MOTOR_ID);

  /** Creates a new DriveSubsystem. */
  public MotorSubsystem() {
    talonMotor.configFactoryDefault();
    talonMotor.setInverted(true);
    talonMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void runMotor() {
    talonMotor.set(TalonSRXControlMode.PercentOutput, Constants.OperatorConstants.SPEED_FORWARD);
  }

  public void stopMotor() {
    talonMotor.set(TalonSRXControlMode.PercentOutput, Constants.OperatorConstants.SPEED_STOP);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}