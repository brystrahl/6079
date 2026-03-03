// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

/**
 * The drive subsystem for FRC Team 6079's 2026 Rebuilt robot.
 *
 * <p>Uses a differential (tank) drive with two motors per side,
 * controlled via arcade drive during teleop.
 */
public class DriveSubsystem extends SubsystemBase {
    // Drive motors
    private final PWMSparkMax m_leftFront = new PWMSparkMax(DriveConstants.LEFT_FRONT_MOTOR_PORT);
    private final PWMSparkMax m_leftBack = new PWMSparkMax(DriveConstants.LEFT_BACK_MOTOR_PORT);
    private final PWMSparkMax m_rightFront = new PWMSparkMax(DriveConstants.RIGHT_FRONT_MOTOR_PORT);
    private final PWMSparkMax m_rightBack = new PWMSparkMax(DriveConstants.RIGHT_BACK_MOTOR_PORT);

    // Differential drive - uses lambdas to drive both left and right motors together
    private final DifferentialDrive m_drive =
            new DifferentialDrive(
                    output -> {
                        m_leftFront.set(output);
                        m_leftBack.set(output);
                    },
                    output -> {
                        m_rightFront.set(output);
                        m_rightBack.set(output);
                    });

    private boolean m_precisionMode = false;

    /** Creates a new DriveSubsystem. */
    public DriveSubsystem() {
        // Right side motors are inverted to match physical orientation;
        // inversion is handled by DifferentialDrive internally.
    }

    /**
     * Drives the robot using arcade drive (forward/turn inputs).
     *
     * @param forward the commanded forward movement [-1, 1]
     * @param rotation the commanded rotation [-1, 1]
     */
    public void arcadeDrive(double forward, double rotation) {
        double scale = m_precisionMode ? DriveConstants.PRECISION_MODE_SCALE : 1.0;
        m_drive.arcadeDrive(forward * scale, rotation * scale);
    }

    /**
     * Drives the robot using tank drive (left/right side inputs).
     *
     * @param leftSpeed the commanded speed for the left side [-1, 1]
     * @param rightSpeed the commanded speed for the right side [-1, 1]
     */
    public void tankDrive(double leftSpeed, double rightSpeed) {
        m_drive.tankDrive(leftSpeed, rightSpeed);
    }

    /**
     * Stops all drive motors.
     */
    public void stopDrive() {
        m_drive.stopMotor();
    }

    /**
     * Enables or disables precision (slow) mode.
     *
     * @param enabled true to enable precision mode
     */
    public void setPrecisionMode(boolean enabled) {
        m_precisionMode = enabled;
    }

    /**
     * Returns whether precision mode is currently active.
     *
     * @return true if precision mode is active
     */
    public boolean isPrecisionMode() {
        return m_precisionMode;
    }

    @Override
    public void periodic() {
        // Periodic updates (e.g., logging) can be added here
    }
}
