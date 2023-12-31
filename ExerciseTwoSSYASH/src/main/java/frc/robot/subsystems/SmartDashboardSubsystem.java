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

  public void updateEncoders() {
    SmartDashboard.putNumber("S0 Drive Encoder", RobotContainer.motorSubsystem.getEncoder());
  }

  public void updateAllDisplays() {
    updateEncoders();
  }

  @Override
  public void periodic() {
    updateAllDisplays();
    // This method will be called once per scheduler run
  }
}