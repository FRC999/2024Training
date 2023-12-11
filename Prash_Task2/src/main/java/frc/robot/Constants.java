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
    public static final int kDriverControllerPort = 0;

    public static final int MOTOR_ID = 9;
    public static final int ENC_MOTOR_ID = 9;
    public static final int JOYSTICK_PORT = 0;
    public static final int BUTTON_RUN_NUM = 11;
    public static final int BUTTON_REVERSE_NUM = 12;
    public static final double SPEED_FORWARD = 0.3;
    public static final double SPEED_STOP = 0.0;
    public static final double SPEED_BACKWARD = -0.3;
  }
}
