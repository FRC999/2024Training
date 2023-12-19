// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.WPI_PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PigeonSubsystem extends SubsystemBase {

  private static WPI_PigeonIMU pigeon;

  private static pigeonIMUcontroller wpi_TalonSRX;

  /** Creates a new PigeonSubsystem. */
  public PigeonSubsystem() {
    pigeonIMUcontroller = new wpi_TalonSRX(Constants.OperatorConstants.PIGEON_CONTROLLERID);
    pigeon = new WPI_PigeonIMU(pigeonIMUcontroller);
  }
  public static wpi_TalonSRX()

  public double getRoll() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
