// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.DriveSubsystem;

/**
 * Factory class for autonomous routines for FRC Team 6079's 2026 Rebuilt robot.
 *
 * <p>Each method returns a {@link Command} that can be scheduled during autonomous.
 */
public final class Autos {
    /** Prevent instantiation. */
    private Autos() {}

    /**
     * A simple autonomous command that drives the robot forward for a set time.
     *
     * @param drive the drive subsystem
     * @return a command that drives forward and then stops
     */
    public static Command driveForwardAuto(DriveSubsystem drive) {
        return Commands.sequence(
                // Drive forward at auto speed for 2 seconds
                Commands.run(
                                () -> drive.arcadeDrive(AutoConstants.AUTO_DRIVE_SPEED, 0),
                                drive)
                        .withTimeout(2.0),
                // Stop the drive
                Commands.runOnce(drive::stopDrive, drive));
    }

    /**
     * An autonomous command that drives forward, pauses, then drives back.
     *
     * @param drive the drive subsystem
     * @return a command that drives forward and back
     */
    public static Command driveForwardAndBackAuto(DriveSubsystem drive) {
        return Commands.sequence(
                Commands.run(
                                () -> drive.arcadeDrive(AutoConstants.AUTO_DRIVE_SPEED, 0),
                                drive)
                        .withTimeout(2.0),
                Commands.waitSeconds(0.5),
                Commands.run(
                                () -> drive.arcadeDrive(-AutoConstants.AUTO_DRIVE_SPEED, 0),
                                drive)
                        .withTimeout(2.0),
                Commands.runOnce(drive::stopDrive, drive));
    }

    /**
     * Does nothing during autonomous. Useful for testing or as a placeholder.
     *
     * @return a command that does nothing
     */
    public static Command doNothingAuto() {
        return Commands.none();
    }
}
