package com.team2357.frc2023.commands;

import com.team2357.frc2023.Constants;
import com.team2357.frc2023.Robot;
import com.team2357.frc2023.subsystems.ArmRotationSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;
public class RotateArmToZeroCommand extends CommandBase{
    private static ArmRotationSubsystem armRotationSubsystem;
    public RotateArmToZeroCommand() {
        addRequirements(Robot.m_armRotationSubsystem);
        armRotationSubsystem = Robot.m_armRotationSubsystem;
    }

    @Override
    public void initialize() {
        armRotationSubsystem.rotate(Constants.ARM_ROTATION.ARM_ROTATION_ZERO_SPEED_PERCENTAGE);
        
    }

    @Override
    public boolean isFinished() {
        return armRotationSubsystem.getMotorCurrent() >= Constants.WRIST.WRIST_MOTOR_RECTRACT_STALL_CURRENT;
    }

    @Override
    public void end(boolean isInterupted) {
        armRotationSubsystem.stopMotor();
    }
    
}
