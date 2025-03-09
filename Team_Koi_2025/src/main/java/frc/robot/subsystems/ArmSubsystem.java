package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {

    private final SparkMax armMotor;
    private final SparkMaxConfig config;
    private double armAngle;
    private double offset=Constants.ArmConstants.ENCODER_OFFSET;
    private boolean finished;
    DutyCycleEncoder encoder;
    private final PIDController pidController;

    public ArmSubsystem() {
        pidController=new PIDController(Constants.ArmConstants.Kp, Constants.ArmConstants.Ki, Constants.ArmConstants.Kd);
        // Initialize the motor with the specified ID and motor type
        armMotor = new SparkMax(Constants.ArmConstants.MOTOR_ID, SparkMax.MotorType.kBrushless);
        encoder=new DutyCycleEncoder(Constants.ArmConstants.ENCODER_PORT, 360, Constants.ArmConstants.ENCODER_OFFSET);
        pidController.setTolerance(1);
        // Create a new configuration object
        config = new SparkMaxConfig();

        // Set the idle mode to brake
        config.idleMode(IdleMode.kBrake);
        config.inverted(false);
        // Apply the configuration to the motor controller
        armMotor.configure(config, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);

        // Reset the encoder position to zero
        finished=false;
    }

    public void moveArm(double target,boolean inverted) {
        // Limit the speed to the defined maximum
        armAngle = getArmAngle();
        //SmartDashboard.putNumber("Arm setpoint", target);
        // Move the arm only if it's within the allowed angle range
        if((target <= Constants.ArmConstants.MIN_ANGLE && target >= Constants.ArmConstants.MAX_ANGLE)){
            armMotor.set(pidController.calculate(armAngle,target));
            finished=false;
        } else {
            finished=true;
        }
    }

    public double getArmAngle() {
        // Calculate the arm angle based on the encoder position
        armAngle = encoder.get();
        return armAngle;
    }

    public void stopArm() {
        // Stop the arm motor
        armMotor.set(0);
    }
    public boolean encoderConnected(){
        return encoder.isConnected();
    }
    public boolean getFinished(){
        return finished;
    }
    private double getFF(){
        return Constants.ArmConstants.FF * Math.sin(Units.degreesToRadians(getArmAngle()) ) ;
    }
    @Override
    public void periodic() {
        int currentAramAngle=(int)getArmAngle();
        SmartDashboard.putNumber("P Arm Gain",Constants.ArmConstants.Kp);
        SmartDashboard.putNumber("D Arm Gain", Constants.ArmConstants.Kd);
        SmartDashboard.putNumber("FF Arm Gain", Constants.ArmConstants.FF);
        SmartDashboard.putNumber("Arm angle position", currentAramAngle);
        SmartDashboard.putBoolean("Arm angle encoder connected", encoderConnected());
        SmartDashboard.putNumber("setPoint", 290);
        SmartDashboard.putNumber("error", 290-currentAramAngle);
    }
}
