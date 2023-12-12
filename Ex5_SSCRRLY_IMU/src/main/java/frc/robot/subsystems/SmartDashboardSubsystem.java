// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class SmartDashboardSubsystem extends SubsystemBase {
  /** Creates a new SmartDashboardSubsystem. */
  public SmartDashboardSubsystem() {
  }

  public void updatePigeon() {
    SmartDashboard.putNumber("PigeonYaw: ", RobotContainer.pigeonIMUSubsystem.getYaw());
    SmartDashboard.putNumber("PigeonRoll: ", RobotContainer.pigeonIMUSubsystem.getRoll());
    SmartDashboard.putNumber("PigeonPitch: ", RobotContainer.pigeonIMUSubsystem.getPitch());
  }
  public void updateNavX() {
    SmartDashboard.putNumber("NavXYaw: ", RobotContainer.navXIMUSubsystem.getYaw());
    SmartDashboard.putNumber("NavXRoll: ", RobotContainer.navXIMUSubsystem.getRoll());
    SmartDashboard.putNumber("NavXPitch: ", RobotContainer.navXIMUSubsystem.getPitch());
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    updatePigeon();
    updateNavX();
  }
}
