// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class SmartDashboardSubsystem extends SubsystemBase {
  /** Creates a new SmartDashboardSubsystem. */
  public SmartDashboardSubsystem() {}

  public void updatePigeonIMUValues() {
    SmartDashboard.putNumber("Pigeon Roll: ", RobotContainer.pigeonIMUSubsystem.getRoll());
    SmartDashboard.putNumber("Pigeon Pitch: ", RobotContainer.pigeonIMUSubsystem.getPitch());
    SmartDashboard.putNumber("Pigeon Yaw: ", RobotContainer.pigeonIMUSubsystem.getYaw());
  }

  public void updateNavXIMUValues() {
    SmartDashboard.putNumber("NavX Roll: ", RobotContainer.navXIMUSubsystem.getRoll());
    SmartDashboard.putNumber("NavX Pitch: ", RobotContainer.navXIMUSubsystem.getPitch());
    SmartDashboard.putNumber("NavX Yaw: ", RobotContainer.navXIMUSubsystem.getYaw());    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    updatePigeonIMUValues();
    updateNavXIMUValues();
  }
}
