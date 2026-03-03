// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

/**
 * Intake subsystem for FRC Team 6079's 2026 Rebuilt robot.
 *
 * <p>Controls a roller intake used to acquire and eject game pieces.
 */
public class IntakeSubsystem extends SubsystemBase {
    private final PWMSparkMax m_intakeMotor =
            new PWMSparkMax(IntakeConstants.INTAKE_MOTOR_PORT);

    /** Creates a new IntakeSubsystem. */
    public IntakeSubsystem() {}

    /**
     * Runs the intake inward to acquire a game piece.
     */
    public void runIntakeIn() {
        m_intakeMotor.set(IntakeConstants.INTAKE_IN_SPEED);
    }

    /**
     * Runs the intake outward to eject/score a game piece.
     */
    public void runIntakeOut() {
        m_intakeMotor.set(-IntakeConstants.INTAKE_OUT_SPEED);
    }

    /**
     * Stops the intake motor.
     */
    public void stopIntake() {
        m_intakeMotor.stopMotor();
    }

    @Override
    public void periodic() {
        // Periodic updates can be added here (e.g., sensor readings)
    }
}
