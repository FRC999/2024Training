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

  @Override
  public void periodic() {
    updateEncoder();
  }

  public void updateEncoder() {
    SmartDashboard.putNumber("Dynamic Pigeon Pitch", RobotContainer.pigeonSubsystem.getPitch());
    SmartDashboard.putNumber("Dynamic Pigeon Roll", RobotContainer.pigeonSubsystem.getRoll());
    SmartDashboard.putNumber("Dynamic Pigeon Yaw", RobotContainer.pigeonSubsystem.getYaw());

    SmartDashboard.putNumber("Dynamic NavX Pitch", RobotContainer.navXSubsystem.getPitch());
    SmartDashboard.putNumber("Dynamic NavX Roll", RobotContainer.navXSubsystem.getRoll());
    SmartDashboard.putNumber("Dynamic NavX Yaw", RobotContainer.navXSubsystem.getYaw());
  }
}
