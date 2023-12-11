 


package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  
  private CANSparkMax rMotor = new CANSparkMax(Constants.OperatorConstants.RMOTOR, MotorType.kBrushless);
  private CANSparkMax leftMotor = new CANSparkMax(Constants.OperatorConstants.LMOTOR, MotorType.kBrushless);

  
  private DifferentialDrive drive;
  
  public DriveSubsystem() {

    
    driveTrainBrakeMode();

    
    drive = new DifferentialDrive(leftMotor, rMotor);
    
  }

  public void driveTrainBrakeMode() {
    rMotor.setIdleMode(IdleMode.kBrake);
    leftMotor.setIdleMode(IdleMode.kBrake);
  }

  public void manualDrive(double move, double turn) {

    drive.arcadeDrive(move, turn);

  }

  public void configureMotors() {
    rMotor.setInverted(false);
    leftMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    
  }
}