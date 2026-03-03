// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autos;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems
    private final DriveSubsystem m_drive = new DriveSubsystem();
    private final ElevatorSubsystem m_elevator = new ElevatorSubsystem();
    private final IntakeSubsystem m_intake = new IntakeSubsystem();

    // The driver and operator controllers
    private final XboxController m_driverController =
            new XboxController(Constants.OIConstants.DRIVER_CONTROLLER_PORT);
    private final XboxController m_operatorController =
            new XboxController(Constants.OIConstants.OPERATOR_CONTROLLER_PORT);

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();

        // Configure default commands
        // Set the default drive command to arcade drive using the driver's controller
        m_drive.setDefaultCommand(
                new RunCommand(
                        () ->
                                m_drive.arcadeDrive(
                                        -m_driverController.getLeftY(),
                                        -m_driverController.getRightX()),
                        m_drive));
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link JoystickButton}, and then calling that button's
     * {@link JoystickButton#onTrue(Command)} method with the desired command.
     */
    private void configureButtonBindings() {
        // Operator controller: A button runs intake in, B button runs intake out
        new JoystickButton(m_operatorController, XboxController.Button.kA.value)
                .whileTrue(new RunCommand(m_intake::runIntakeIn, m_intake));

        new JoystickButton(m_operatorController, XboxController.Button.kB.value)
                .whileTrue(new RunCommand(m_intake::runIntakeOut, m_intake));

        // Operator controller: Right bumper raises elevator, left bumper lowers elevator
        new JoystickButton(m_operatorController, XboxController.Button.kRightBumper.value)
                .whileTrue(new RunCommand(m_elevator::raiseElevator, m_elevator));

        new JoystickButton(m_operatorController, XboxController.Button.kLeftBumper.value)
                .whileTrue(new RunCommand(m_elevator::lowerElevator, m_elevator));

        // Driver controller: X button (hold) enables precision (slow) mode
        new JoystickButton(m_driverController, XboxController.Button.kX.value)
                .onTrue(Commands.runOnce(() -> m_drive.setPrecisionMode(true)))
                .onFalse(Commands.runOnce(() -> m_drive.setPrecisionMode(false)));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return Autos.driveForwardAuto(m_drive);
    }
}
