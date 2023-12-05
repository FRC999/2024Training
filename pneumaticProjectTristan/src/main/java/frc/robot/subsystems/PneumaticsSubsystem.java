// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsConstants;

public class PneumaticsSubsystem extends SubsystemBase {
  /** Creates a new PneumaticsSubsystem. */
  private Compressor compressor;

  private PneumaticsControlModule pneumaticsControlModule = new PneumaticsControlModule(PneumaticsConstants.compressorCANID);

  public PneumaticsSubsystem() {
    compressor = new Compressor(PneumaticsConstants.compressorCANID, PneumaticsConstants.pneumaticsModuleType);


    System.out.println("activating compressor :)");
    activateCompressor();
  }

  public void activateCompressor() {
    compressor.enableDigital();
  }

  public void deactivateCompressor() {
    compressor.disable();
  }

  public PneumaticsControlModule getPneumaticsHub() {
    return pneumaticsControlModule;
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
