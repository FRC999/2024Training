// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorSensorV3.RawColor;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class ColorSensorSubsystem extends SubsystemBase {
  public final I2C.Port i2cPort = I2C.Port.kMXP;
  private ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private Color seenColor;
  public static boolean isColorSensor;
  double IR = colorSensor.getIR();

  // Color match test
  private final ColorMatch colorMatcher = new ColorMatch();
  private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
  private final Color kGreenTarget = new Color(0.197, 0.561, 0.240);
  private final Color kRedTarget = new Color(0.561, 0.232, 0.114);
  private final Color kYellowTarget = new Color(0.361, 0.524, 0.113);

  /** Creates a new ColorSensor. */
  public ColorSensorSubsystem() {
      colorMatcher.addColorMatch(kBlueTarget);
      colorMatcher.addColorMatch(kGreenTarget);
      colorMatcher.addColorMatch(kRedTarget);
      colorMatcher.addColorMatch(kYellowTarget);
    }

  public String getSeenColor(Color color) {   // It will return most closely matched color as ENUM
    ColorMatchResult match = colorMatcher.matchClosestColor(color);
    String colorString;
    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

  return colorString;

  }

  public int getDistance() {
    return colorSensor.getProximity();
  }

  @Override
  public void periodic() {
    Color detectedColor = colorSensor.getColor();
    // This method will be called once per scheduler run

    SmartDashboard.putString("Color: ", getSeenColor(detectedColor));
    SmartDashboard.putNumber("Disance: ", getDistance());
  }
}
