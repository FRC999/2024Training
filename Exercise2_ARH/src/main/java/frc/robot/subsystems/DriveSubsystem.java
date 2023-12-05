// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.apriltag.AprilTagDetector.Config;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.OperatorConstants;;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  private final WPI_TalonFX motor; // instantiates the talonfx motor class
  private final WPI_TalonSRX encoderMotor;
  public DriveSubsystem() {
    motor = new WPI_TalonFX(Constants.OperatorConstants.motorID); // sets the talonfx motor id
    encoderMotor = new WPI_TalonSRX(Constants.OperatorConstants.encoderMotorID); // sets the talonfx motor id
    configureEncoders();
  }

  @Override
  public void periodic() { // is run every 20 ms
    // This method will be called once per scheduler run
  } 
  public void configureEncoders() {
    encoderMotor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
  }

  public void startMotorForward() {
    motor.set(ControlMode.PercentOutput, Constants.OperatorConstants.motorSpeed); // sets the percentage output of the motor by locating the motor speed
  }

  public void manuallyDrive(double speed) {
    encoderMotor.set(ControlMode.PercentOutput, speed); // sets the percent output to 0 in order to stop the motor

  }
  public void stopMotor() {
    encoderMotor.set(ControlMode.PercentOutput, 0.0); // sets the percent output to 0 in order to stop the motor
  }

  public void startMotorBackwards() {
    motor.set(ControlMode.PercentOutput, -Constants.OperatorConstants.motorSpeed); // sets the percentage output of the motor by locating the motor speed
  }
  
  public double getEncoder() {
    double encoder = encoderMotor.getSelectedSensorPosition();
    System.out.println("e:" + encoder);
    return encoder;
  }

  
}