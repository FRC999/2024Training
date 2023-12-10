// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  WPI_TalonFX motor = new WPI_TalonFX(9);
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    
    
  }

  public void moveMotor(double speed) {
    motor.set(speed);
  };

  public void moveMotorJoystick() {
    
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public int getEncoder() {
    return (int) motor.getSelectedSensorPosition();
  }
  
  public void configureEncoders() {
    motor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
  }
}
