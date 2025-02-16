package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DeliveryCatchSubsystem extends SubsystemBase {
  // Declare vortex
  private SparkFlex Vortex;

  public DeliveryCatchSubsystem() {
    // Set Vortex
    Vortex = new SparkFlex(Constants.DeliveryCatchSubsystemConstants.DEVICE_ID, MotorType.kBrushless);
    Vortex.restoreFactoryDefaults();
  }

  // Starts the grabbing motor
  public void powerEngine(int power, boolean powerDir) { //power - voltage precentage, powerDir - true=positive false=negative
    Vortex.inverted(!powerDir); // set power direcation acording to parameters
    Vortex.setVoltage(power); // set voltage to power the engine
  }
}
