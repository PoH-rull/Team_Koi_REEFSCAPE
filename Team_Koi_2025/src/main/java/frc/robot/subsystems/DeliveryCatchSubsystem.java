package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DeliveryCatchSubsystem extends SubsystemBase {
  // Declare vortex
  public SparkMax Vortex;

  public DeliveryCatchSubsystem() {
    // Set Vortex
    Vortex = new SparkMax(Constants.DeliveryCatchSubsystemConstants.DEVICE_ID, MotorType.kBrushless);
    Vortex.restoreFactoryDefaults();
  }

  // Starts the grabbing motor
  public void powerEngine(int power, int powerDir) { //power - voltage precentage, powerDir - true=positive false=negative
    if (powerDir != null) Vortex.inverted(powerDir < 0); // set power direcation acording to parameters
    Vortex.setVoltage(power); // set voltage to power the engine
  }
}
