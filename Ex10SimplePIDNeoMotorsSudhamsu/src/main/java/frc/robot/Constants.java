// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int JoystickPort = 0;
    public static final int LMOTOR = 20;
    public static final int RMOTOR = 21;
    public static final int BUTTON_THREE = 3;
    public static final int BUTTON_TWO = 2;

    public static final double ENCODER_CHANGE_PER_METER = 19.2416369340551;
    public static final double kP = 0.05;
    public static final double kI = 0.0;
    public static final double kD = 0.0;
    public static final double kF = 0.0;
  }
}
