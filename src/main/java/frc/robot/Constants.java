// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    /** Constants related to drive motor controllers. */
    public static final class DriveConstants {
        public static final int LEFT_FRONT_MOTOR_PORT = 0;
        public static final int LEFT_BACK_MOTOR_PORT = 1;
        public static final int RIGHT_FRONT_MOTOR_PORT = 2;
        public static final int RIGHT_BACK_MOTOR_PORT = 3;

        /** Maximum drive speed scaling factor in precision mode. */
        public static final double PRECISION_MODE_SCALE = 0.3;
    }

    /** Constants related to the elevator subsystem. */
    public static final class ElevatorConstants {
        public static final int ELEVATOR_MOTOR_PORT = 4;
        public static final int ELEVATOR_LIMIT_SWITCH_BOTTOM = 0;
        public static final int ELEVATOR_LIMIT_SWITCH_TOP = 1;

        /** Elevator raise speed (0 to 1). */
        public static final double ELEVATOR_RAISE_SPEED = 0.5;

        /** Elevator lower speed (0 to 1). */
        public static final double ELEVATOR_LOWER_SPEED = 0.3;
    }

    /** Constants related to the intake subsystem. */
    public static final class IntakeConstants {
        public static final int INTAKE_MOTOR_PORT = 5;

        /** Intake speed when running in (0 to 1). */
        public static final double INTAKE_IN_SPEED = 0.8;

        /** Intake speed when running out (0 to 1). */
        public static final double INTAKE_OUT_SPEED = 0.6;
    }

    /** Constants related to operator interface (OI) devices. */
    public static final class OIConstants {
        public static final int DRIVER_CONTROLLER_PORT = 0;
        public static final int OPERATOR_CONTROLLER_PORT = 1;
    }

    /** Constants related to autonomous routines. */
    public static final class AutoConstants {
        /** Drive forward speed during autonomous (0 to 1). */
        public static final double AUTO_DRIVE_SPEED = 0.5;
    }
}
