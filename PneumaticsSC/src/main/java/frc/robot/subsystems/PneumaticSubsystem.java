// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj. PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticSubsystem extends SubsystemBase {
  private Compressor compressor;
  public static final PneumaticsModuleType pneumaticsModuleType = PneumaticsModuleType.CTREPCM;
  private static DoubleSolenoid solenoid;
  
  /** Creates a new PneumaticSubsystem. */
  public PneumaticSubsystem() {
  compressor = new Compressor(Constants.OperatorConstants.COMPRESSOR_ID, PneumaticsModuleType.CTREPCM);
  solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.OperatorConstants.F_CHANNEL, Constants.OperatorConstants.R_CHANNEL);
  runCompressor();
  }

  public void runCompressor() {
    compressor.enableDigital();
  }

  public void stopCompressor() {
    compressor.disable();
  }

  public void goForward() {
    solenoid.set(Value.kReverse);
  }

  public void goBackward() {
    solenoid.set(Value.kForward);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
