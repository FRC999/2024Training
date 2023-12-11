// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class EncMotorSubsystem extends SubsystemBase {

  public WPI_TalonSRX talonEncMotor = new WPI_TalonSRX(Constants.OperatorConstants.ENC_MOTOR_ID);

  /** Creates a new DriveSubsystem. */
  public EncMotorSubsystem() {
    talonEncMotor.configFactoryDefault();
    talonEncMotor.setInverted(true);
    talonEncMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void runMotor() {
    talonEncMotor.set(TalonSRXControlMode.PercentOutput, Constants.OperatorConstants.SPEED_FORWARD);
  }

  public void reverseMotor() {
    talonEncMotor.set(TalonSRXControlMode.PercentOutput, Constants.OperatorConstants.SPEED_BACKWARD);
  }

  public void stopMotor() {
    talonEncMotor.set(TalonSRXControlMode.PercentOutput, Constants.OperatorConstants.SPEED_STOP);
  }

  public void variableMotor(double speed) {
    talonEncMotor.set(TalonSRXControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public int getEncoder() {
    return((int) talonEncMotor.getSelectedSensorPosition());
  }

  public void configureEncoder() {
    talonEncMotor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
  }
}
