// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final double ROBOT_MASS = 81 * 0.453592; // 32lbs * kg per pound
  public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0,Units.inchesToMeters(8)),ROBOT_MASS);
  public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag
  public static final double MAX_SPEED  = Units.feetToMeters(14.5);

    public static class OperatorConstants {
        public static final int kDriverControllerPort = 0;
        public static final double DEADBAND        = 0.3;
        public static final double LEFT_Y_DEADBAND = 0.1;
        public static final double RIGHT_X_DEADBAND = 0.1;
        public static final double TURN_CONSTANT    = 6;
      
    }
    public static final class DrivebaseConstants
    {

        public static final double WHEEL_LOCK_TIME = 10; // seconds
    }
  public static final class RobotConstants{

  }


  public static class ElevatorConstants{
    public static final int ELEVATE_MOTOR_ID = 0;
    public static final int ELEVATOR_START_POSITION = 0;
    public static final int ELEVATOR_END_POSITION = 0;
  }

  public static class ElevatorPIDConstants{
    public static final double kP = 0, kI = 0, kD = 0;
  }

  public static class ArmConstants{
    public static final int MOTOR_ID = 25; 
    public static final double MAX_ANGLE = 269; 
    public static final double MIN_ANGLE = 350; 
    public static final double SPEED_LIMIT = 0.5;
    public static final double ENCODER_OFFSET=84;
    public static final int ENCODER_PORT=2;
    public static final double Kp=0.0069,Ki=0,Kd=0,FF=0;
  }


  public static class ElevatorFeedforwardConstants{
    public static final double kS = 0, kG = 0, kV =0.0021141649048626, kA = 0;;
  }

  public static final class HandRotaionConstants{
    public static final int CAN_HAND_DEGREE_ID=21;
    public static final double HAND_DGREE_SPARKMAX_Kp=0.0543;
    public static final double HAND_DGREE_SPARKMAX_Ki=0;
    public static final double HAND_DGREE_SPARKMAX_Kd=0;
    public static final double HAND_DGREE_SPARKMAX_FF=0.0021141649048626;
    public static final double HAND_DGREE_ENCODER_OFFSET=165.118504;
    public static final int HAND_DGREE_ENCODER_PORT=0;
  } 

    public static final class RobotHandConstants {
        public static final int MOTOR_ID = 20;
        public static final double GRAB_POWER = 1;
        public static final double IDLE_POWER = 0.1;
        public static final double RELEASE_POWER = 0.2;
        public static final double STOPING_POWER = 0;
    }
  public static class MotorConstants {
      public static final int NEO_MOTOR_COUNTS_PER_REV = 42;
  }

  public static final class Convert {
      public static final double INCHES_TO_METERS = Units.inchesToMeters(1);
  }

  public static final class GearRatio {
    public static final class SwerveModule {
        public static final double STEERING_GEAR_RATIO = 12.8;  // Common steering gear ratio
        public static final double DRIVE_GEAR_RATIO = 6.75;    // Typical for swerve drive
    }
}

public static final class MotorAttributes {
    public static final class Neo {
        public static final int COUNTS_PER_REVOLUTION_SparkMax = 42; // Neo encoders have 42 CPR
    }

    public static final class Vortex {
        public static final int COUNTS_PER_REVOLUTION_SparkFlex = 2048; // Assuming Falcon 500/Vortex equivalent
    }
}


}
