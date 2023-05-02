// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.team2357.frc2023;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kOperatorControllerPort = 0;
  }

  public static class CAN_ID{

    public static final String DRIVE_CANBUS = "CANivore";

    public static final int PNEUMATICS_HUB = 1;

    public static final int PIGEON = 5;

    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 11;
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 12;
    public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 19;

    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 13;
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 14;
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 20;

    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 15;
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 16;
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 21;

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 17;
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 18;
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 22;

    public static final int MASTER_INTAKE_MOTOR = 23;
    public static final int FOLLOWER_INTAKE_MOTOR = 24;
    public static final int INTAKE_WINCH_MOTOR = 25;

    public static final int ARM_ROTATION_MOTOR = 26;

    public static final int ARM_EXTENSION_MOTOR = 27;

    public static final int CLAW_ROLLER_MOTOR = 29;
    public static final int WRIST_ROTATION_MOTOR = 30;
    
  }

  public static class ARM_ROTATION{
    public static final double ARM_ROTATION_SPEED_LIMIT_PERCENTAGE = 0.5;
    public static final double ARM_ROTATION_ZERO_SPEED_PERCENTAGE = 0.4;
    public static final int  ARM_ROTATION_STALL_AMP_LIMIT = 50;
    public static final int ARM_ROTATION_FREE_AMP_LIMIT = 30;

  }

  public static class ARM_EXTENSION{
    public static final double ARM_EXTENSION_SPEED_LIMIT_PERCENTAGE = 0.4;
    public static final double ARM_EXTENSION_ZERO_SPEED_PERCENTAGE = 0.4;

  }

  public static class WRIST{
    public static final double WRIST_ROTATION_SPEED_LIMIT_PERCENTAGE = 0.5;
    public static final double WRIST_ROTATION_RETRACT_SPEED_PERCENTAGE = 0.3;
    public static final int WRIST_MOTOR_RECTRACT_STALL_CURRENT = 20;
  }

  public static class OPERATOR_CONTROLS{
    public static final double OPERATOR_CONTROL_LEFT_Y_DEADZONE = 0.06;
    public static final double OPERATOR_CONTROL_RIGHT_Y_DEADZONE = 0.06;
  }
  
}