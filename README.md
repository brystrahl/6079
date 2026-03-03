# 6079 FUNGUS — 2026 Rebuilt Robot Code

This repository contains the Java robot code for **FRC Team 6079 (FUNGUS)** competing in the **2026 FRC Rebuilt season**.

## Project Structure

```
src/main/java/frc/robot/
├── Main.java               — Robot entry point
├── Robot.java              — Main robot class (TimedRobot)
├── RobotContainer.java     — Subsystem instantiation, button bindings, autos
├── Constants.java          — All hardware port numbers and tuning constants
├── subsystems/
│   ├── DriveSubsystem.java     — Differential (tank) drive with arcade control
│   ├── ElevatorSubsystem.java  — Single-stage elevator with limit switch safety
│   └── IntakeSubsystem.java    — Roller intake for game piece acquisition/scoring
└── commands/
    └── Autos.java              — Autonomous command factory methods
```

## Hardware

| Component         | Controller   | PWM Port |
|-------------------|--------------|----------|
| Left Front Drive  | Spark MAX    | 0        |
| Left Back Drive   | Spark MAX    | 1        |
| Right Front Drive | Spark MAX    | 2        |
| Right Back Drive  | Spark MAX    | 3        |
| Elevator          | Spark MAX    | 4        |
| Intake            | Spark MAX    | 5        |

| Sensor                   | DIO Port |
|--------------------------|----------|
| Elevator Bottom Limit SW | 0        |
| Elevator Top Limit SW    | 1        |

## Controls

### Driver Controller (Port 0)
- **Left Stick Y**: Forward/Backward
- **Right Stick X**: Turn
- **X Button (hold)**: Precision (slow) mode

### Operator Controller (Port 1)
- **A Button (hold)**: Run intake in
- **B Button (hold)**: Run intake out
- **Right Bumper (hold)**: Raise elevator
- **Left Bumper (hold)**: Lower elevator

## Building and Deploying

This project uses the [WPILib](https://docs.wpilib.org/) Gradle build system.

```bash
# Build the project
./gradlew build

# Deploy to the RoboRIO (robot must be connected)
./gradlew deploy
```

Requires [WPILib 2026](https://docs.wpilib.org/en/stable/docs/zero-to-robot/step-2/wpilib-setup.html) to be installed.
