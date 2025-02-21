package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import frc.robot.Constants;
import frc.robot.commands.ElevatorUpCommand;

public class ElevatorSubsystem extends SubsystemBase{
    private final SparkMax motor; // motor yay
    private final SparkMaxConfig config; // it has the pid and the encoder (probably (I think))
    private final ArmFeedforward feedforward = new ArmFeedforward(Constants.ElevatorFeedforwardConstants.kS, Constants.ElevatorFeedforwardConstants.kG, Constants.ElevatorFeedforwardConstants.kV, Constants.ElevatorFeedforwardConstants.kA);
    private Encoder encoder;
    private double radians = 0;

    public ElevatorSubsystem(){
       this.config = new SparkMaxConfig();
       this.motor = new SparkMax(Constants.ElevatorConstants.ELEVATE_MOTOR_ID, MotorType.kBrushless);
       this.encoder = new Encoder(Constants.ElevatorConstants.CHANNEL[0], Constants.ElevatorConstants.CHANNEL[1]);
       this.encoder.setDistancePerPulse(Constants.ElevatorConstants.ELEVATOR_CONVERTION_FACTOR);
       setDefaultCommand(new ElevatorUpCommand(this));

       config.idleMode(IdleMode.kBrake);
        config.closedLoop
            .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
            .pid(Constants.ElevatorPIDConstants.kP, Constants.ElevatorPIDConstants.kI, Constants.ElevatorPIDConstants.kD);
        motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    // makes it go to a certain position (real)
    // may not be used other than moving it to the start when finished
    public void setTargetPosition(double targetPosition) {
        motor.getClosedLoopController().setReference(feedforward.calculate(radians, targetPosition), ControlType.kPosition);
    }

    // sets a velocity to the motor (I have no idea how to make a limit for it, I am gusseing we will just fuck around and find out(not really))
    public void setTargetVelocity(double targetVelocity) {
        // if(motor.getEncoder().getPosition() == Constants.ElevatorConstants.ELEVATOR_END_POSITION && targetVelocity > 0){
        //     return;
        // } else if(motor.getEncoder().getPosition() == Constants.ElevatorConstants.ELEVATOR_START_POSITION && targetVelocity < 0){
        //     return;
        // }   
        // radians = Math.toRadians(motor.getEncoder().getPosition() * Constants.ElevatorConstants.FULL_CIRCLE);
        radians = Math.toRadians(encoder.getDistance() * Constants.ElevatorConstants.FULL_CIRCLE);
        motor.getClosedLoopController().setReference(feedforward.calculate(radians ,targetVelocity), ControlType.kVelocity);
    }

    public void stop(){
        motor.stopMotor();
    }

    public boolean finish(){
        return motor.getEncoder().getPosition() == Constants.ElevatorConstants.ELEVATOR_START_POSITION;
    }
}
