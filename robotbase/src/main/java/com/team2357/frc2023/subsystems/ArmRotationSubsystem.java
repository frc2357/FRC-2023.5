package com.team2357.frc2023.subsystems;

import com.revrobotics.CANSparkMax;
import com.team2357.frc2023.Constants.ARM_ROTATION;
import com.team2357.frc2023.Robot;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmRotationSubsystem extends SubsystemBase {
  private CANSparkMax m_rotationMotor;

  public ArmRotationSubsystem(CANSparkMax rotationMotor) {
    m_rotationMotor = rotationMotor;

    m_rotationMotor.setSmartCurrentLimit(ARM_ROTATION.ARM_ROTATION_STALL_AMP_LIMIT, ARM_ROTATION.ARM_ROTATION_FREE_AMP_LIMIT);
  }

  public void manualRotate(double speedPercentage) {
    if (Math.abs(speedPercentage) > ARM_ROTATION.ARM_ROTATION_SPEED_LIMIT_PERCENTAGE) {
      speedPercentage = Math.copySign(ARM_ROTATION.ARM_ROTATION_SPEED_LIMIT_PERCENTAGE, speedPercentage);
    }
    m_rotationMotor.set(speedPercentage);
  }

  public void rotatePercentageSpeed(double speedPercentage){
    m_rotationMotor.set(speedPercentage);
  }

  public void stopMotor(){
    m_rotationMotor.stopMotor();
  }

  public double getMotorCurrent(){
    return m_rotationMotor.getOutputCurrent();
  }

  public double getEncoder(){
    return m_rotationMotor.getEncoder().getPosition();
  }

  public void resetEncoder(){
    m_rotationMotor.getEncoder().setPosition(0);
  }

  @Override
  public void periodic() {
    
  }
}
