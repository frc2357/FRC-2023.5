package com.team2357.frc2023.commands;

import com.team2357.frc2023.Constants;
import com.team2357.frc2023.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RetractWristCommand extends CommandBase {
    public RetractWristCommand() {
        addRequirements(Robot.s_WristSubsystem);
    }

    @Override
    public void initialize() {
        Robot.s_WristSubsystem.rotateWristPercentage(Constants.WRIST.WRIST_ROTATION_RETRACT_SPEED_PERCENTAGE);
    }

    @Override
    public boolean isFinished() {
        return Robot.s_WristSubsystem.getMotorCurrent() >= Constants.WRIST.WRIST_MOTOR_RECTRACT_STALL_CURRENT;
    }

    @Override
    public void end(boolean isInterupted) {
        Robot.s_WristSubsystem.stopMotor();
        Robot.s_WristSubsystem.resetEncoder();
    }
}
