// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.PneumaticsConstants;

public class PneumaticsSubsystem extends SubsystemBase {
  private static DoubleSolenoid barSolenoid;
  /** Creates a new PneumaticsSubsystem. */
  private Compressor compressor;

  private PneumaticsControlModule pneumaticsControlModule = new PneumaticsControlModule(PneumaticsConstants.compressorCANID);

  public PneumaticsSubsystem() {
    compressor = new Compressor(PneumaticsConstants.compressorCANID, PneumaticsConstants.pneumaticsModuleType);
    barSolenoid = new DoubleSolenoid(PneumaticsConstants.pneumaticsModuleType, Constants.PneumaticsConstants.FORWARDCHANNEL, Constants.PneumaticsConstants.REVERSECHANNEL);

    activateCompressor();
    deactivateCompressor();
  }

  public void activateCompressor() {
    compressor.enableDigital();
  }

  public void deactivateCompressor() {
    compressor.disable();
  }

  public void barForward() {
    barSolenoid.set(Value.kForward);
  }

  public void barBackwards() {
    barSolenoid.set(Value.kReverse);
  }

  public PneumaticsControlModule getPneumaticsHub() {
    return pneumaticsControlModule;
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
