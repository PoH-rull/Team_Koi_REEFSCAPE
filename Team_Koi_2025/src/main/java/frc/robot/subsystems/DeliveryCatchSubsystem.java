package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DeliveryCatchSubsystem extends SubsystemBase {
  // Declare vortex
  public SparkMax Vortex;

  public DeliveryCatchSubsystem() {
    // Set Vortex
    Vortex = new SparkMax(Constants.DeliveryCatchSubsystemConstants.DEVICE_ID, MotorType.kBrushless);
  }

  // Starts the grabbing motor
  public void powerEngine(double power, int powerDir) { //power - voltage precentage, powerDir - true=positive false=negative
    Vortex.setInverted(powerDir < 0); // set power direcation acording to parameters
    Vortex.setVoltage(power); // set voltage to power the engine
  }
}
