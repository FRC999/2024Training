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
    public static final int DRIVER_STICK = 0;
    public static final int BUTTON_ELEVEN = 11;
    public static final int MOTOR_CONTROLLER_PORT = 9;
    public static final int BUTTON_TEN = 10;
    public static final int ENCODER_MOTOR = 9;

    public static final double MOTPOWER_START = 0.2;
    public static final double MOTPOWER_END = 0.0;
    public static final double MOTPOWER_REVERSE = -0.2;
    
  }
}
