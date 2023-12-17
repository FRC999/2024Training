// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Autos;
import frc.robot.commands.MotorReverse;
import frc.robot.commands.MotorRun;
import frc.robot.commands.MotorStop;
import frc.robot.commands.MotorVariable;
import frc.robot.subsystems.MotorSubsystem;
import frc.robot.subsystems.SmartDashboardSubsystem;
import frc.robot.subsystems.EncMotorSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static final MotorSubsystem motorSubsystem = new MotorSubsystem();
  public static final EncMotorSubsystem encMotorSubsystem = new EncMotorSubsystem();
  public static final SmartDashboardSubsystem smartDashboardSubsystem = new SmartDashboardSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  //private final CommandXboxController m_driverController =
  //    new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public static Joystick joystick = new Joystick(0);

  private final Trigger motorRunButton = new JoystickButton(joystick, Constants.OperatorConstants.BUTTON_RUN_NUM);
  private final Trigger motorReverseButton = new JoystickButton(joystick, Constants.OperatorConstants.BUTTON_REVERSE_NUM);
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    encMotorSubsystem.setDefaultCommand(new MotorVariable());
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_exampleSubsystem::exampleCondition)
        // .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  
    motorRunButton.onTrue(new MotorRun())
                    .onFalse(new MotorStop());

    motorReverseButton.onTrue(new MotorReverse())
                    .onFalse(new MotorStop());

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}