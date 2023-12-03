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
  WPI_TalonSRX motor = new WPI_TalonSRX(Constants.OperatorConstants.MOTOR_ID);
  WPI_TalonSRX encMotor = new WPI_TalonSRX(Constants.OperatorConstants.ENCMOTOR);

  public void setSpeed(double motorSpeed) {
    encMotor.set(motorSpeed);
  }

  public int getEncoder() {
    int e = (int) encMotor.getSelectedSensorPosition();
    System.out.println("e:"+e);
    return e;
  }

  public void configureEncoders() {
    encMotor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
  }

 
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void backward() {
    motor.set(ControlMode.PercentOutput, Constants.OperatorConstants.BACKWARDSPEED);
  }
  public void runMotor() {
    motor.set(ControlMode.PercentOutput, Constants.OperatorConstants.SPEED);
  }

  public void stopMotor() {
    motor.set(ControlMode.PercentOutput, Constants.OperatorConstants.STOP_SPEED);
  }

  public void joystickDrive(double move) {
    motor.set(ControlMode.PercentOutput, move);
  }
}
