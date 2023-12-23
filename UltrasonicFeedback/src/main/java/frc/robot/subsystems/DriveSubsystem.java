// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveSubsystem extends SubsystemBase {

  public DriveSubsystem() {}
  WPI_TalonSRX motor = new WPI_TalonSRX(9);
  WPI_TalonSRX encMotor = new WPI_TalonSRX(9);

  public void setSpeed(double motorSpeed) {
    encMotor.set(motorSpeed);
  }

  public int getEncoder() {
    int e = (int) encMotor.getSelectedSensorPosition();
    System.out.println("e:"+e);
    return e;
  }

  public double calculateMotorInput(int sensorValue) {
    double motorInput = (double) sensorValue / 1680.0;
    return motorInput;
  }

  public void configureEncoders() {
    encMotor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
  }

 
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}