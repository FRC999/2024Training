// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  //_initializes and defines motors
  private CANSparkMax rightMotor = new CANSparkMax(Constants.OperatorConstants.RMOTOR, MotorType.kBrushless);
  private CANSparkMax leftMotor = new CANSparkMax(Constants.OperatorConstants.LMOTOR, MotorType.kBrushless);

  //_initializes differential drive
  private DifferentialDrive drive;
  
  public DriveSubsystem() {

    //_init driveTrainBrakeMode
    driveTrainBrakeMode();

    //_def DifferentialDrive between left and right motor
    drive = new DifferentialDrive(leftMotor, rightMotor);
    
  }

  public void driveTrainBrakeMode() {
    //_this will make the robot brake when no command is given. !!very important!!
    rightMotor.setIdleMode(IdleMode.kBrake);
    leftMotor.setIdleMode(IdleMode.kBrake);
  }

  public void manualDrive(double move, double turn) {

    drive.arcadeDrive(move, turn);

  }

  public void configureMotors() {
    rightMotor.setInverted(false);
    //_left motor is invertued due to its position on the frankenBot
    leftMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}