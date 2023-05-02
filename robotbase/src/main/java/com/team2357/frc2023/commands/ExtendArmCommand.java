package com.team2357.frc2023.commands;

import com.team2357.frc2023.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtendArmCommand extends CommandBase{
    public ExtendArmCommand(){
        addRequirements(Robot.s_armExtensionSubsystem);
    }
    @Override
    public void initialize(){
        Robot.s_armRotationSubsystem.manualRotate(Robot.s_operatorControls.getLeftY());
    }
}
