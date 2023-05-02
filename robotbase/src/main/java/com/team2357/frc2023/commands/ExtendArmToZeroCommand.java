package com.team2357.frc2023.commands;

import com.team2357.frc2023.subsystems.ArmExtensionSubsystem;
import com.team2357.frc2023.Robot;
import com.team2357.frc2023.Constants;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtendArmToZeroCommand extends CommandBase{
    private static ArmExtensionSubsystem armExtensionSubsystem;
    public ExtendArmToZeroCommand(){
    addRequirements(Robot.m_armExtensionSubsystem);
        armExtensionSubsystem = Robot.m_armExtensionSubsystem;
    }

    @Override
    public void initialize() {
        armExtensionSubsystem.extend(Constants.ARM_EXTENSION.ARM_EXTENSION_ZERO_SPEED_PERCENTAGE);
        
    }

    @Override
    public boolean isFinished() {
        return armExtensionSubsystem.getMotorCurrent() >= Constants.WRIST.WRIST_MOTOR_RECTRACT_STALL_CURRENT;
    }

    @Override
    public void end(boolean isInterupted) {
        armExtensionSubsystem.stopMotor();
    }
    
}
