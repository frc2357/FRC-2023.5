package com.team2357.frc2023.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.team2357.frc2023.Constants;
import com.team2357.frc2023.Robot;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmRotationSubsystem extends SubsystemBase {
  private CANSparkMax m_rotationMotor;

  public ArmRotationSubsystem() {
    m_rotationMotor = new CANSparkMax(Constants.CAN_ID.ARM_ROTATION_MOTOR, MotorType.kBrushless);

    m_rotationMotor.setSmartCurrentLimit(60, 30);
  }

  public void manualRotate(double speed) {
    if (Math.abs(speed) > Constants.ARM_ROTATION.ARM_ROTATION_SPEED_LIMIT_PERCENTAGE) {
      speed = Math.copySign(Constants.ARM_ROTATION.ARM_ROTATION_SPEED_LIMIT_PERCENTAGE, speed);
    }
    m_rotationMotor.set(speed);
  }

  public void rotate(double speed){
    m_rotationMotor.set(speed);
  }

  public void stopMotor(){
    m_rotationMotor.stopMotor();
  }

  public double getMotorCurrent(){
    return m_rotationMotor.getOutputCurrent();
  }

  @Override
  public void periodic() {
    if(!RobotState.isDisabled()){
      manualRotate(Robot.m_operatorControls.getLeftY());
    }
  }
}
