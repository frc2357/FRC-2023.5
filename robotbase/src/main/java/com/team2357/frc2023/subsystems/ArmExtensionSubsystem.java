package com.team2357.frc2023.subsystems;

import com.revrobotics.CANSparkMax;
import com.team2357.frc2023.Constants.ARM_EXTENSION;
import com.team2357.frc2023.Robot;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmExtensionSubsystem extends SubsystemBase{
    private CANSparkMax m_armExtensionMotor;
    public ArmExtensionSubsystem(CANSparkMax armExtensionMotor){
        m_armExtensionMotor = armExtensionMotor;

        m_armExtensionMotor.setSmartCurrentLimit(ARM_EXTENSION.ARM_EXTENSION_STALL_AMP_LIMIT, ARM_EXTENSION.ARM_EXTENSION_FREE_AMP_LIMIT);
    }

    public void manualExtend(double speed){
        if (Math.abs(speed) > ARM_EXTENSION.ARM_EXTENSION_SPEED_LIMIT_PERCENTAGE) {
            speed = Math.copySign(ARM_EXTENSION.ARM_EXTENSION_SPEED_LIMIT_PERCENTAGE, speed);
          }
          m_armExtensionMotor.set(speed);
    }

    public void extendPercentageSpeed(double speed){
        m_armExtensionMotor.set(speed);
    }

    public double getMotorCurrent(){
        return m_armExtensionMotor.getOutputCurrent();
    }

    public void stopMotor(){
      m_armExtensionMotor.stopMotor();
    }

    public double getEncoder(){
      return m_armExtensionMotor.getEncoder().getPosition();
    }

    public void resetEncoder(){
      m_armExtensionMotor.getEncoder().setPosition(0);
    }


    @Override
  public void periodic() {
    
  }
}
