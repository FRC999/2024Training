// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PigeonSubsystem extends SubsystemBase {
  /** Creates a new PigeonSubsystem. */
  public WPI_TalonSRX pigeonIMUController = new WPI_TalonSRX(4);
  private PigeonIMU bird = new PigeonIMU(pigeonIMUController);

  public PigeonSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double getPitch() {
    return bird.getPitch();
  }

  public double getRoll() {
    return bird.getRoll();
  }

  public double getYaw() {
    return bird.getYaw();
  }
}
