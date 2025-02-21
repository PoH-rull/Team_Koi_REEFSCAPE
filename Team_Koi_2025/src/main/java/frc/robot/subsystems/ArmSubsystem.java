package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {

    private final SparkMax armMotor;
    private final SparkMaxConfig config;
    private double armAngle;
    private double offset=Constants.ArmConstants.ENCODER_OFFSET;
    private boolean finished;

    public ArmSubsystem() {
        // Initialize the motor with the specified ID and motor type
        armMotor = new SparkMax(Constants.ArmConstants.MOTOR_ID, SparkMax.MotorType.kBrushless);

        // Create a new configuration object
        config = new SparkMaxConfig();

        // Set the idle mode to brake
        config.idleMode(IdleMode.kBrake);
        config.closedLoop
        .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
        .pidf(Constants.ArmConstants.Kp, Constants.ArmConstants.Ki, Constants.ArmConstants.Kd, Constants.ArmConstants.FF);

        // Apply the configuration to the motor controller
        armMotor.configure(config, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);

        // Reset the encoder position to zero
        armMotor.getEncoder().setPosition(offset);
        finished=false;
    }

    public void moveArm(double speed) {
        // Limit the speed to the defined maximum
        speed = Math.copySign(Math.min(Math.abs(speed), Constants.ArmConstants.SPEED_LIMIT), speed);
        armAngle = getArmAngle();

        // Move the arm only if it's within the allowed angle range
        if ((speed > 0 && armAngle < Constants.ArmConstants.MAX_ANGLE) || (speed < 0 && armAngle > Constants.ArmConstants.MIN_ANGLE)) {
            armMotor.getClosedLoopController().setReference(speed,SparkMax.ControlType.kPosition);
        } else {
            armMotor.set(0);
        }
        finished=true;
    }

    public double getArmAngle() {
        // Calculate the arm angle based on the encoder position
        armAngle = armMotor.getEncoder().getPosition() * 360.0+offset;
        SmartDashboard.putNumber("Arm Angle", armAngle);
        return armAngle;
    }

    public void stopArm() {
        // Stop the arm motor
        armMotor.set(0);
    }
    public boolean getFinished(){
        return finished;
    }
}
