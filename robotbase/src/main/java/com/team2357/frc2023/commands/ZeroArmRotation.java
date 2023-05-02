package com.team2357.frc2023.commands;

import com.team2357.frc2023.Constants;
import com.team2357.frc2023.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;
public class ZeroArmRotation extends CommandBase{
    public ZeroArmRotation() {
        addRequirements(Robot.s_armRotationSubsystem);
    }

    @Override
    public void initialize() {
        Robot.s_armRotationSubsystem.rotatePercentageSpeed(Constants.ARM_ROTATION.ARM_ROTATION_ZERO_SPEED_PERCENTAGE);
        
    }

    @Override
    public boolean isFinished() {
        return Robot.s_armRotationSubsystem.getMotorCurrent() > Constants.ARM_ROTATION.ARM_ROTATION_STALL_AMP_LIMIT;
    }

    @Override
    public void end(boolean isInterupted) {
        Robot.s_armRotationSubsystem.stopMotor();
        Robot.s_armRotationSubsystem.resetEncoder();
    }
    
}
