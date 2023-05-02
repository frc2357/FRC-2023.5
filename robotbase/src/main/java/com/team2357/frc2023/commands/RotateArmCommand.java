package com.team2357.frc2023.commands;

import com.team2357.frc2023.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RotateArmCommand extends CommandBase{
    public RotateArmCommand(){
        addRequirements(Robot.s_armRotationSubsystem);
    }
    @Override
    public void initialize(){
        Robot.s_armRotationSubsystem.manualRotate(Robot.s_operatorControls.getLeftY());
    }
    
}
