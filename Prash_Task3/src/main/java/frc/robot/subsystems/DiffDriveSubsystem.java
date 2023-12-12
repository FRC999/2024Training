// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DiffDriveSubsystem extends SubsystemBase {
    
    private final CANSparkMax leftMotor = new CANSparkMax(Constants.OperatorConstants.LEFT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax rightMotor = new CANSparkMax(Constants.OperatorConstants.RIGHT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
  
    DifferentialDrive diffDrive;

  /** Creates a new DiffDriveSubsystem. */
  public DiffDriveSubsystem() {
    // configureMotors(); // NOT NEEDED - ONE NEO ALREADY INVERTED ONBAORD!
    setDriveTrainBrakeMode();
    diffDrive = new DifferentialDrive(leftMotor, rightMotor);
  }

  public void configureMotors() {
    leftMotor.setInverted(true);
    rightMotor.setInverted(false);
  }

  public void setDriveTrainBrakeMode() {
    leftMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);
  }

  public void manualDrive(double speed, double turn) {
    diffDrive.arcadeDrive(speed, turn);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
