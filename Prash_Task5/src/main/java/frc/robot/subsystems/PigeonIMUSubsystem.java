// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PigeonIMUSubsystem extends SubsystemBase {

  private WPI_PigeonIMU pigeon;
  private WPI_TalonSRX pigeonController; 

  /** Creates a new PigeonSubsystem. */
  public PigeonIMUSubsystem() {
    pigeonController = new WPI_TalonSRX(Constants.OperatorConstants.PIGEON_CONTROLLER_ID);
    pigeon = new WPI_PigeonIMU(pigeonController);
  }

  public double getRoll() {
    return pigeon.getRoll();
  }

  public double getPitch() {
    return pigeon.getPitch();
  }

  public double getYaw() {
    return pigeon.getYaw();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
