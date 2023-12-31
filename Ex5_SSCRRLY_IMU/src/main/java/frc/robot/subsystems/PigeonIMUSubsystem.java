// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU_Faults;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PigeonIMUSubsystem extends SubsystemBase {

  public static WPI_PigeonIMU pigeon;
  public static WPI_TalonSRX pigeonIMUController;
  
  private double[] xyz = new double[3];

  /** Creates a new PigeonIMUSubsystem. */
  public PigeonIMUSubsystem() {
    pigeonIMUController = new WPI_TalonSRX(4);
    pigeon = new WPI_PigeonIMU(pigeonIMUController);
  }

  public double getPitch() {
    return pigeon.getPitch();
  }

  public double getRoll() {
    return pigeon.getRoll();
  }

  public double getYaw() {
    return pigeon.getYaw();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
