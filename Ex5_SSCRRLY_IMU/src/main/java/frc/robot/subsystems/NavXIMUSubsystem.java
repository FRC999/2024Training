// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NavXIMUSubsystem extends SubsystemBase {
  /** Creates a new NavXIMUSubsystem. */
  private static AHRS NavX;
  public NavXIMUSubsystem() {
    try {
    NavX = new AHRS(SPI.Port.kMXP);
    } catch (RuntimeException ex) {
      
    }
  }

  public double getPitch() {
    return NavX.getPitch();
  }

  public double getRoll() {
    return NavX.getRoll();
  }

  public double getYaw() {
    return NavX.getYaw();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
