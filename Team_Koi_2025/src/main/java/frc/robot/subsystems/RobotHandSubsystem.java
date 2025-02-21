package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class RobotHandSubsystem extends SubsystemBase {
    SparkMaxConfig config = new SparkMaxConfig();
    private SparkMax m_SparkMax;    
    public RobotHandSubsystem(){
        m_SparkMax=new SparkMax(Constants.RobotHandConstants.MOTOR_ID, MotorType.kBrushless);
        m_SparkMax.configure(config, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);
        }

        // change the power of the hand motor
        public void powerHand(double power, int dir){
            //we will check the speed in real time bcz idk what the speed the vortex should be
            if (dir<0) {
                m_SparkMax.set(-power);
            }
            else if(dir>0){
                m_SparkMax.set(power);
            }
            else{
                m_SparkMax.set(0);
            }
  
        }
}
