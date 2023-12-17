// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SPI;

public class NavXSubsystem extends SubsystemBase {
  /** Creates a new NavXSubsystem. */
  public AHRS navX = new AHRS(SPI.Port.kMXP);

  public NavXSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double getPitch() {
    return navX.getPitch();
  }

  public double getRoll() {
    return navX.getRoll();
  }

  public double getYaw() {
    return -navX.getYaw();
  }
}
