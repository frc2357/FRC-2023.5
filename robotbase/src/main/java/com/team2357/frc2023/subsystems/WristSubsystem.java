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

    public void manualRotateWrist(double speed){
        if(Math.abs(speed)>Constants.WRIST.WRIST_ROTATION_SPEED_LIMIT_PERCENTAGE){
            speed = Math.copySign(Constants.WRIST.WRIST_ROTATION_SPEED_LIMIT_PERCENTAGE, speed);
        }
        m_wristMotor.set(speed);
    }

    public void rotateWrist(double speed){
        m_wristMotor.set(speed);
    }

    public double getMotorCurrent(){
        return m_wristMotor.getOutputCurrent();
    }

    public void stopMotor(){
        m_wristMotor.stopMotor();
    }

    @Override
    public void periodic(){

    }
}
