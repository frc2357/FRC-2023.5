package com.team2357.frc2023.commands;

import com.team2357.frc2023.Constants;
import com.team2357.frc2023.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtendArmToZeroCommand extends CommandBase{
    public ExtendArmToZeroCommand(){
    addRequirements(Robot.s_armExtensionSubsystem);
    }

    @Override
    public void initialize() {
        Robot.s_armExtensionSubsystem.extendPercentageSpeed(Constants.ARM_EXTENSION.ARM_EXTENSION_ZERO_SPEED_PERCENTAGE);
        
    }

    @Override
    public boolean isFinished() {
        return Robot.s_armExtensionSubsystem.getMotorCurrent() >= Constants.ARM_EXTENSION.ARM_EXTENSION_STALL_AMP_LIMIT;
    }

    @Override
    public void end(boolean isInterupted) {
        Robot.s_armExtensionSubsystem.stopMotor();
        Robot.s_armExtensionSubsystem.resetEncoder();
    }
    
}
