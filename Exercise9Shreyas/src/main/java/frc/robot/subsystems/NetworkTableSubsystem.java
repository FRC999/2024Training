// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NetworkTableSubsystem extends SubsystemBase {
  private NetworkTableInstance netInst;
  /** Creates a new NetworkTableSubsystem. */
  public NetworkTableSubsystem() {
    netInst = NetworkTableInstance.getDefault(); //initializes the NetworkTable
  }

  public double getHorizontalOffset() {
    return netInst.getTable("limelight").getEntry("tx").getDouble(0);
  }

  public double getVerticalOffset() {
    return netInst.getTable("limelight").getEntry("ty").getDouble(0);
  }

  public boolean isTargetAvailable() {
    return netInst.getTable("limelight").getEntry("tv").getDouble(0) == 1;

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Horizontal Offset: ", getHorizontalOffset());
    SmartDashboard.putNumber("Vertical Offset: ", getVerticalOffset());
    SmartDashboard.putBoolean("Target present:", isTargetAvailable());
  }
}
