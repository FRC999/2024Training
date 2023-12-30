// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ColorSensorSubsystem extends SubsystemBase {
  /** Creates a new ColorSensorSubsystem. */
  private final I2C.Port shooterI2CPort = I2C.Port.kMXP;

  private ColorSensorV3 colorSensor;

  private final ColorMatch colorMatcher = new ColorMatch();
  private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
  private final Color kRedTarget = new Color(0.561, 0.232, 0.114);
  public ColorSensorSubsystem() {
    colorSensor = new ColorSensorV3(shooterI2CPort);
    colorMatcher.addColorMatch(kBlueTarget);
    //colorMatcher.addColorMatch(kGreenTarget);
    colorMatcher.addColorMatch(kRedTarget);
    //colorMatcher.addColorMatch(kYellowTarget);

  }
  public String getSeenColor(Color color) {   // It will return most closely matched color as ENUM
    ColorMatchResult match = colorMatcher.matchClosestColor(color);
    String colorString;
    if (match.color == kBlueTarget) {
      colorString = "Azul";
    } else if (match.color == kRedTarget) {
      colorString = "Rojo";
    //} else if (match.color == kGreenTarget) {
     // colorString = "Green";
    //} else if (match.color == kYellowTarget) {
    //  colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }   return colorString;
  }

  public String getSeenColor() {
    Color lastSeenColor = colorSensor.getColor();
    return getSeenColor(lastSeenColor);
  }

  public int getObjectProximity() {
    return colorSensor.getProximity();
  }

  @Override
  public void periodic() {
    SmartDashboard.putString("I See Color", getSeenColor());
    SmartDashboard.putNumber("Distance", getObjectProximity());
    // This method will be called once per scheduler run
  }
}
