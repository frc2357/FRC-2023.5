package com.team2357.frc2023.subsystems;

import java.time.Period;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.team2357.frc2023.Constants;
import com.team2357.frc2023.Robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmExtensionSubsystem extends SubsystemBase{
    private CANSparkMax m_armExtensionMotor;
    public ArmExtensionSubsystem(){
        m_armExtensionMotor = new CANSparkMax(Constants.CAN_ID.ARM_EXTENSION_MOTOR, MotorType.kBrushless);

        m_armExtensionMotor.setSmartCurrentLimit(60, 30);
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
        return m_armExtensionMotor.getAppliedOutput();
    }


    @Override
  public void periodic() {
    manualExtend(Robot.m_operatorControls.getRightY());

  }
}
