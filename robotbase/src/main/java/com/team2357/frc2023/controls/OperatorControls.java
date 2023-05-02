package com.team2357.frc2023.controls;

import com.team2357.frc2023.Constants.OPERATOR_CONTROLS;
import com.team2357.frc2023.commands.RetractWristCommand;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OperatorControls {

    private XboxController m_controller;

    private JoystickButton m_leftTrigger;
    private JoystickButton m_rightTrigger;

    private JoystickButton m_leftBumper;
    private JoystickButton m_rightBumper;

    private JoystickButton m_aButton;
    private JoystickButton m_bButton;
    private JoystickButton m_xButton;
    private JoystickButton m_yButton;

    public OperatorControls(XboxController controller) {

        m_controller = controller;

        m_leftTrigger = new JoystickButton(controller, XboxController.Axis.kLeftTrigger.value);
        m_rightTrigger = new JoystickButton(controller, XboxController.Axis.kRightTrigger.value);

        m_aButton = new JoystickButton(controller, XboxController.Button.kA.value);
        m_bButton = new JoystickButton(controller, XboxController.Button.kB.value);
        m_xButton = new JoystickButton(controller, XboxController.Button.kX.value);
        m_yButton = new JoystickButton(controller, XboxController.Button.kY.value);

        mapControls();
    }

    public double getLeftY() {
        return getDeadzonedValue(m_controller.getLeftY(), OPERATOR_CONTROLS.OPERATOR_CONTROL_LEFT_Y_DEADZONE);

    }

    public double getRightY() {
        return getDeadzonedValue(m_controller.getRightY(), OPERATOR_CONTROLS.OPERATOR_CONTROL_RIGHT_Y_DEADZONE);
    }

    private void mapControls() {

        m_leftTrigger.onTrue(new RetractWristCommand());

    }

    private double getDeadzonedValue(double value, double deadzone) {
        if (Math.abs(value) > deadzone) {
            return value;
        }
        return 0;
    }

}
