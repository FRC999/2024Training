// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.hal.simulation.ConstBufferCallback;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticSubsystem extends SubsystemBase {

private static DoubleSolenoid doubleSolenoid;
private Compressor compressor;

  /** Creates a new PneumaticSubsystem. */
  public PneumaticSubsystem() {
    compressor = new Compressor(Constants.OperatorConstants.COMPRESSOR_ID, PneumaticsModuleType.CTREPCM);
    doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.OperatorConstants.FORWARD_CHANNEL, Constants.OperatorConstants.REVERSE_CHANNEL);
    runCompressor();
  }

  private void runCompressor() {
    compressor.enableDigital();
  }

  private void stopCompressor() {
    compressor.disable();
  }

  public void extendSolenoid() {
    doubleSolenoid.set(Value.kReverse);
  }

  public void retractSolenoid() {
    doubleSolenoid.set(Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
