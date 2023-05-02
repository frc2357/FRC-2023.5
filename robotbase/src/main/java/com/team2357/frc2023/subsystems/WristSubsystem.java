package com.team2357.frc2023.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.team2357.frc2023.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WristSubsystem extends SubsystemBase{
    private CANSparkMax m_wristMotor;
    public WristSubsystem(){
        m_wristMotor = new CANSparkMax(Constants.CAN_ID.WRIST_ROTATION_MOTOR, MotorType.kBrushless);
    }

    public void manualRotateWrist(double speedPercentage){
        if(Math.abs(speedPercentage)>Constants.WRIST.WRIST_ROTATION_SPEED_LIMIT_PERCENTAGE){
            speedPercentage = Math.copySign(Constants.WRIST.WRIST_ROTATION_SPEED_LIMIT_PERCENTAGE, speedPercentage);
        }
        m_wristMotor.set(speedPercentage);
    }

    public void rotateWristPercentage(double speedPercentage){
        m_wristMotor.set(speedPercentage);
    }

    public double getMotorCurrent(){
        return m_wristMotor.getOutputCurrent();
    }

    public void stopMotor(){
        m_wristMotor.stopMotor();
    }

    public double getEncoder(){
        return m_wristMotor.getEncoder().getPosition();
      }
  
      public void resetEncoder(){
        m_wristMotor.getEncoder().setPosition(0);
      }

    @Override
    public void periodic(){

    }
}
