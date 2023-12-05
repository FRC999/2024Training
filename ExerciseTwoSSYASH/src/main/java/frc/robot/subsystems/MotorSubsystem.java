// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveManuallyCommand;

public class MotorSubsystem extends SubsystemBase {
  private WPI_TalonSRX talonMotor;
  private WPI_TalonSRX encMotor;
  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {
    talonMotor = new WPI_TalonSRX(Constants.OperatorConstants.MOTOR_CONTROLLER_PORT);

    encMotor = new WPI_TalonSRX(Constants.OperatorConstants.ENCODER_MOTOR);
  }

  public void startMotor() {
    encMotor.set(ControlMode.PercentOutput, Constants.OperatorConstants.MOTPOWER_START);
  }
  
  public void reverseMotor() {
    encMotor.set(ControlMode.PercentOutput, Constants.OperatorConstants.MOTPOWER_REVERSE);
  }

  public void stopMotor() {
    encMotor.set(ControlMode.PercentOutput, Constants.OperatorConstants.MOTPOWER_END);
  }

  public void dynamicSpeedChange(double move) {
    encMotor.set(ControlMode.PercentOutput, move);
  }

  public void setSpeed(double motorSpeed) {
    encMotor.set(motorSpeed);
  }

  public int getEncoder() {
    int a = (int) encMotor.getSelectedSensorPosition();
    return a;
  }

  public void configureEncoders() {
    encMotor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
