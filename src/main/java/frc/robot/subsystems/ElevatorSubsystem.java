// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorConstants;

/**
 * Elevator subsystem for FRC Team 6079's 2026 Rebuilt robot.
 *
 * <p>Controls a single-stage elevator used to raise and lower game pieces
 * to scoring positions. Limit switches protect the elevator from over-travel.
 */
public class ElevatorSubsystem extends SubsystemBase {
    private final PWMSparkMax m_elevatorMotor =
            new PWMSparkMax(ElevatorConstants.ELEVATOR_MOTOR_PORT);

    private final DigitalInput m_bottomLimitSwitch =
            new DigitalInput(ElevatorConstants.ELEVATOR_LIMIT_SWITCH_BOTTOM);
    private final DigitalInput m_topLimitSwitch =
            new DigitalInput(ElevatorConstants.ELEVATOR_LIMIT_SWITCH_TOP);

    /** Creates a new ElevatorSubsystem. */
    public ElevatorSubsystem() {}

    /**
     * Raises the elevator upward. Stops automatically if the top limit switch is triggered.
     */
    public void raiseElevator() {
        if (!isAtTop()) {
            m_elevatorMotor.set(ElevatorConstants.ELEVATOR_RAISE_SPEED);
        } else {
            stopElevator();
        }
    }

    /**
     * Lowers the elevator downward. Stops automatically if the bottom limit switch is triggered.
     */
    public void lowerElevator() {
        if (!isAtBottom()) {
            m_elevatorMotor.set(-ElevatorConstants.ELEVATOR_LOWER_SPEED);
        } else {
            stopElevator();
        }
    }

    /**
     * Stops the elevator motor.
     */
    public void stopElevator() {
        m_elevatorMotor.stopMotor();
    }

    /**
     * Returns whether the elevator is at the bottom limit.
     *
     * @return true if the bottom limit switch is triggered
     */
    public boolean isAtBottom() {
        return !m_bottomLimitSwitch.get(); // Limit switches are normally open (NO)
    }

    /**
     * Returns whether the elevator is at the top limit.
     *
     * @return true if the top limit switch is triggered
     */
    public boolean isAtTop() {
        return !m_topLimitSwitch.get(); // Limit switches are normally open (NO)
    }

    @Override
    public void periodic() {
        // Safety: stop elevator if limit switches are hit
        if (isAtTop() && m_elevatorMotor.get() > 0) {
            stopElevator();
        }
        if (isAtBottom() && m_elevatorMotor.get() < 0) {
            stopElevator();
        }
    }
}
