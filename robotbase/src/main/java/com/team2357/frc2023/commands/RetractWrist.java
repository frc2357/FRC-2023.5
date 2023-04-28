package com.team2357.frc2023.commands;

import com.team2357.frc2023.Constants;
import com.team2357.frc2023.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RetractWrist extends CommandBase {
    public RetractWrist() {
        addRequirements(Robot.m_WristSubsystem);
    }

    @Override
    public void initialize() {
        Robot.m_WristSubsystem.rotateWrist(Constants.WRIST.WRIST_ROTATION_RETRACT_SPEED_PERCENTAGE);
    }

    @Override
    public boolean isFinished() {
        return Robot.m_WristSubsystem.getMotorCurrent() >= Constants.WRIST.WRIST_MOTOR_RECTRACT_STALL_CURRENT;
    }

    @Override
    public void end(boolean isInterupted) {
        Robot.m_WristSubsystem.stopMotor();
    }
}
