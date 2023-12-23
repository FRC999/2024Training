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
    SmartDashboard.putNumber("Pigeon Roll: ", RobotContainer.pigeonSubsystem.getRoll());
    SmartDashboard.putNumber("Pigeon Pitch: ", RobotContainer.pigeonSubsystem.getPitch());
    SmartDashboard.putNumber("Pigeon Yaw: ", RobotContainer.pigeonSubsystem.getYaw());
  }

public void updateNavXIMUValues(){
  SmartDashboard.putNumber("NavX Roll: ", RobotContainer.navXSubsystem.getRoll());
  SmartDashboard.putNumber("NavX Pitch: ", RobotContainer.navXSubsystem.getPitch());
  SmartDashboard.putNumber("NavX Yaw: ", RobotContainer.navXSubsystem.getYaw());
}

  @Override
  public void periodic() {
    updatePigeonIMUValues();
    updateNavXIMUValues();
  }
}
