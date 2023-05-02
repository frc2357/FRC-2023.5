package com.team2357.frc2023.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.team2357.frc2023.Constants;
import com.team2357.frc2023.Robot;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmExtensionSubsystem extends SubsystemBase{
    private CANSparkMax m_armExtensionMotor;
    public ArmExtensionSubsystem(){
        m_armExtensionMotor = new CANSparkMax(Constants.CAN_ID.ARM_EXTENSION_MOTOR, MotorType.kBrushless);

        m_armExtensionMotor.setSmartCurrentLimit(Constants.ARM_ROTATION.ARM_ROTATION_STALL_AMP_LIMIT, Constants.ARM_ROTATION.ARM_ROTATION_FREE_AMP_LIMIT);
    }

    public void manualExtend(double speed){
        if (Math.abs(speed) > Constants.ARM_EXTENSION.ARM_EXTENSION_SPEED_LIMIT_PERCENTAGE) {
            speed = Math.copySign(Constants.ARM_EXTENSION.ARM_EXTENSION_SPEED_LIMIT_PERCENTAGE, speed);
          }
          m_armExtensionMotor.set(speed);
    }

    public void extend(double speed){
        m_armExtensionMotor.set(speed);
    }

    public double getMotorCurrent(){
        return m_armExtensionMotor.getOutputCurrent();
    }

    public void stopMotor(){
      m_armExtensionMotor.stopMotor();
    }


    @Override
  public void periodic() {
    if(!RobotState.isDisabled()){
      manualExtend(Robot.m_operatorControls.getRightY());
    }
  }
}
