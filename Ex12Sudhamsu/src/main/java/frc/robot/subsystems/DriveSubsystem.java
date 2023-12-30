// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  private CANSparkMax rightMotor = new CANSparkMax(Constants.OperatorConstants.RMOTOR, MotorType.kBrushless);
  private CANSparkMax leftMotor = new CANSparkMax(Constants.OperatorConstants.LMOTOR, MotorType.kBrushless);
  private RelativeEncoder leftEncoder;
  private RelativeEncoder rightEncoder; 

  //initializes differential drive
  private DifferentialDrive drive;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    driveTrainBrakeMode();
    leftEncoder = leftMotor.getEncoder();
    rightEncoder = rightMotor.getEncoder();

    drive = new DifferentialDrive(leftMotor, rightMotor);
    drive.setSafetyEnabled(false);
  }

  public void driveTrainBrakeMode() {
    //this will make the robot brake when no command is given, when it is standing there basically
    rightMotor.setIdleMode(IdleMode.kBrake);
    leftMotor.setIdleMode(IdleMode.kBrake);
  }

  public double getLeftEncoder() {
    return -leftEncoder.getPosition();
  }

  public double getRightEncoder() {
    return rightEncoder.getPosition();
  }

  public void manualDrive(double move, double turn) {
    drive.arcadeDrive(move, turn);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Encoder Value: ", getLeftEncoder());
    SmartDashboard.putNumber("Right Encoder Value: ", getRightEncoder());
  }
}
