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
    public static class OperatorConstants {
        public static final int kDriverControllerPort = 0;
        public static final double DEADBAND        = 0.1;
        public static final double LEFT_Y_DEADBAND = 0.1;
        public static final double RIGHT_X_DEADBAND = 0.1;
        public static final double TURN_CONSTANT    = 6;
    }
    public static final class DrivebaseConstants
    {

        public static final double WHEEL_LOCK_TIME = 10; // seconds
    }
  public static final class RobotConstants{
    public static final double ROBOT_MASS = (148 - 20.3) * 0.453592; // 32lbs * kg per pound
    public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0,Units.inchesToMeters(8)),ROBOT_MASS);
    public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag
    public static final double MAX_SPEED  = Units.feetToMeters(14.5);
  }


  public static class ElevatorConstants{
    public static final int ELEVATE_MOTOR_ID = 0;
    public static final int ELEVATOR_START_POSITION = 0;
    public static final int ELEVATOR_END_POSITION = 0;
    public static final double ELEVATOR_SPEED = 10;
    public static final double FULL_CIRCLE = 360;
    public static final int ELEVATOR_CONVERTION_FACTOR = 1000;
    public static final int[] CHANNEL = {0,1};
  }

  public static class ElevatorPIDConstants{
    public static final int kP = 0, kI = 0, kD = 0;
  }

  public static class ElevatorFeedforwardConstants{
    public static final int kS = 0, kG = 0, kV = 0, kA = 0;;
  }

  public static final class HandRotaionConstants{
    public static final int CAN_HAND_DEGREE_ID=0;
    public static final double HAND_DGREE_SPARKMAX_Kp=0.246;
    public static final double HAND_DGREE_SPARKMAX_Ki=0;
    public static final double HAND_DGREE_SPARKMAX_Kd=0;    
  } 

    public static final class RobotHandConstants {
        public static final int MOTOR_ID = 17;
        public static final double GRAB_POWER = 1;
        public static final double IDLE_POWER = 0.1;
        public static final double RELEASE_POWER = 0.2;
        public static final double STOPING_POWER = 0;
    }


}
