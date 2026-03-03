# Team 6079 — FUNGUS
## FRC 2026 REBUILT Robot Code

Robot code for Team 6079 (FUNGUS) competing in the 2026 FIRST Robotics Competition game **REBUILT**, presented by Haas.

### Game Overview
In REBUILT, robots score by:
- Shooting fuel (yellow balls) into a central hub
- Maneuvering over obstacles on the field
- Climbing structured field elements (tower) at end-game

### Project Structure
This project uses the **WPILib Command-Based** framework (Java, WPILib 2026.2.1).

```
src/main/java/frc/robot/
├── Main.java              – Robot entry point
├── Robot.java             – TimedRobot lifecycle hooks
├── RobotContainer.java    – Subsystems, commands, and button bindings
├── Constants.java         – Robot-wide constants (ports, speeds, etc.)
├── subsystems/
│   ├── Drive.java         – 4-motor tank drive (PWM Spark, ports 0–3)
│   ├── Collector.java     – Ball intake (REV SPARK MAX, CAN 3)
│   ├── CollectorArm.java  – Collector arm deployment (PWM Spark, port 6)
│   ├── Loader.java        – Ball loader / feeder (PWM Spark, port 4)
│   └── Shooter.java       – Ball shooter (PWM Spark, port 5)
└── commands/
    ├── TeleopDrive.java   – Tank drive with PS4 joysticks + triggers
    ├── RunCollector.java  – Analog-speed collector intake
    ├── RunCollectorArm.java – Collector arm retract / extend
    ├── RunLoader.java     – Fixed-speed loader feed
    ├── RunShooter.java    – Analog-speed ball shooter
    └── Autos.java         – Autonomous command factory
```

### Controller Layout

**Driver Controller (Port 0) — PS4**
| Input | Action |
|---|---|
| Left joystick Y | Left drive motors (tank) |
| Right joystick Y | Right drive motors (tank) |
| R2 trigger | Both sides forward boost |
| L2 trigger | Both sides backward boost |

**Operator Controller (Port 1) — PS4**
| Input | Action |
|---|---|
| R2 (analog, hold) | Shooter — speed proportional to trigger |
| L2 (analog, hold) | Collector — speed proportional to trigger |
| Circle (hold) | Loader — fixed speed feed |
| D-pad Up (hold) | Collector arm — retract (wind string) |
| D-pad Down (hold) | Collector arm — extend (unwind string) |

### Hardware
- **Drive:** 4× PWM Spark motor controllers (ports 0–3), 4-motor tank drive
- **Collector:** REV SPARK MAX (brushless, CAN ID 3)
- **Loader:** PWM Spark (port 4)
- **Shooter:** PWM Spark (port 5)
- **Collector Arm:** PWM Spark (port 6)
- **Controllers:** 2× PS4 controllers (USB ports 0 and 1)

### Building & Deploying
Requires **WPILib 2026** installed on your development machine.

```bash
# Build
./gradlew build

# Deploy to robot (connect to robot WiFi first)
./gradlew deploy

# Run simulation
./gradlew simulateJava
```

### Vendor Dependencies
- **WPILib New Commands** (bundled with WPILib 2026)
- **REVLib 2026.0.1** — REV Robotics SPARK MAX support
