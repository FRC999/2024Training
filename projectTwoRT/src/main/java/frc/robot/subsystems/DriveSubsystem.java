// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveSubsystem extends SubsystemBase {

  WPI_TalonFX motor = new WPI_TalonFX(Constants.OperatorConstants.MOTOR);
  WPI_TalonFX encMotor = new WPI_TalonFX(Constants.OperatorConstants.ENCMOTOR);

  /** Creates a new Drive. */
  public DriveSubsystem() {}

  public void setSpeed(double motorSpeed) {
    encMotor.set(motorSpeed);
  }

  public int getEncoder() {
    return (int) encMotor.getSelectedSensorPosition();
  }

  public void configureEncoders() {
    encMotor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
  }

 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
