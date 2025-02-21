package frc.robot.subsystems;

import java.beans.Encoder;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.HandRotaionCommand;

public class HandRotaionSubSystem extends SubsystemBase {
    private SparkMax m_handRo;
    private boolean finished;
    double offset=Constants.HandRotaionConstants.HAND_DGREE_ENCODER_OFFSET;
    Encoder encoder = new Encoder();
    SparkMaxConfig config = new SparkMaxConfig();
    public HandRotaionSubSystem(){
        m_handRo=new SparkMax(Constants.HandRotaionConstants.CAN_HAND_DEGREE_ID, MotorType.kBrushless);
        config.idleMode(IdleMode.kBrake);
        config.encoder
        .positionConversionFactor(360.0);
        config.closedLoop
        .pidf(Constants.HandRotaionConstants.HAND_DGREE_SPARKMAX_Kp, Constants.HandRotaionConstants.HAND_DGREE_SPARKMAX_Ki, Constants.HandRotaionConstants.HAND_DGREE_SPARKMAX_Kd,Constants.HandRotaionConstants.HAND_DGREE_SPARKMAX_FF)
        .maxOutput(1)
        .minOutput(-1);
        m_handRo.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        m_handRo.getEncoder().setPosition(offset);
        setDefaultCommand(new HandRotaionCommand(this));
        finished=false;
    }
    public void turnArm(int speed){
        if (speed>0&&m_handRo.getEncoder().getPosition()+offset!=90) {
                m_handRo.getClosedLoopController().setReference(speed,SparkMax.ControlType.kPosition);
        }
        else if (speed<0&&m_handRo.getEncoder().getPosition()+offset!=0) {
            m_handRo.getClosedLoopController().setReference(speed,SparkMax.ControlType.kPosition);
        }
        else{
            m_handRo.set(0);
        }
        finished=true;
    }
    public boolean getFinished(){
        return finished;
    }
}
;