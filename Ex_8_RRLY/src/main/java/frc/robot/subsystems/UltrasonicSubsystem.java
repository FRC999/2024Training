// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class UltrasonicSubsystem extends SubsystemBase {
  /** Creates a new UltrasonicSubsystem. */
  private final AnalogInput ultrasonic = new AnalogInput(Constants.OperatorConstants.UltrasonicPort);
  
  public double getDistance() {
    return ultrasonic.getValue();
  }

  public UltrasonicSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
