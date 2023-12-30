package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  private CANSparkMax rightMotor = new CANSparkMax(Constants.OperatorConstants.RMOTOR, MotorType.kBrushless);
  private CANSparkMax leftMotor = new CANSparkMax(Constants.OperatorConstants.LMOTOR, MotorType.kBrushless);
  private RelativeEncoder leftEncoder;
  private RelativeEncoder rightEncoder;
  private SparkMaxPIDController pidLeft;
  private SparkMaxPIDController pidRIght;

  //initializes differential drive
  private DifferentialDrive drive;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    driveTrainBrakeMode();
    leftEncoder = leftMotor.getEncoder();
    rightEncoder = rightMotor.getEncoder();

    configurePIDMotorLeft();
    configurePIDMotorRight();
  
    drive = new DifferentialDrive(leftMotor, rightMotor);
    drive.setSafetyEnabled(false);
  }

  public void driveTrainBrakeMode() {
    //this will make the robot brake when no command is given, when it is standing there basically
    rightMotor.setIdleMode(IdleMode.kBrake);
    leftMotor.setIdleMode(IdleMode.kBrake);
  }

  public void manualDrive(double move, double turn) {
    drive.arcadeDrive(move, turn);
  }

  public double getLeftEncoder() {
    return -leftEncoder.getPosition();
  }

  public double getRightEncoder() {
    return rightEncoder.getPosition();
  }

  public Double getLeftEncoderRaw() {
    return leftEncoder.getPosition();
  }

  public Double getRightEncoderRaw() {
    return rightEncoder.getPosition();
  }

  public void configurePIDMotorLeft() {
    pidLeft = leftMotor.getPIDController();
    pidLeft.setFeedbackDevice(leftEncoder);

    pidLeft.setP(Constants.OperatorConstants.kP);
    pidLeft.setI(Constants.OperatorConstants.kI);
    pidLeft.setD(Constants.OperatorConstants.kD);
    pidLeft.setFF(Constants.OperatorConstants.kF);
    leftMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus5, 20);

    leftMotor.burnFlash();
  }

  public void configurePIDMotorRight() {
    pidRIght = rightMotor.getPIDController();
    pidRIght.setFeedbackDevice(rightEncoder);

    pidRIght.setP(Constants.OperatorConstants.kP);
    pidRIght.setI(Constants.OperatorConstants.kI);
    pidRIght.setD(Constants.OperatorConstants.kD);
    pidRIght.setFF(Constants.OperatorConstants.kF);
    rightMotor.setPeriodicFramePeriod(PeriodicFrame.kStatus5, 20);

    rightMotor.burnFlash();
  }

  public void runMotorPIDRight(double destination) {
    rightMotor.getPIDController().setReference(destination, ControlType.kPosition);
  }

  public void runMotorPIDLeft(double destination) {
    leftMotor.getPIDController().setReference(destination, ControlType.kPosition);
  }

  public void endPIDLeft() {
    leftMotor.getPIDController().setReference(0, ControlType.kVoltage);
  }
  public void endPIDRight() {
    rightMotor.getPIDController().setReference(0, ControlType.kVoltage);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Encoder Value: ", getLeftEncoder());
    SmartDashboard.putNumber("Right Encoder Value: ", getRightEncoder());
  }
}