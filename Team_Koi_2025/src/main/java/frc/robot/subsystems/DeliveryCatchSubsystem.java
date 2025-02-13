package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DeliveryCatchSubsystem extends SubsystemBase {
  // Declare vortex
  private CANSparkMax Vortex;

  public DeliveryCatchSubsystem() {
    // Set Vortex
    Vortex = new CANSparkMax(Constants.DeliveryCatchSubsystemConstants.DEVICE_ID, MotorType.kBrushless);
    Vortex.restoreFactoryDefaults();
  }

  // Starts the grabbing motor
  public void work(int power) {
    Vortex.set(power);
  }

  // Stops the motor when the buttons are released
  public void idle() {
    Vortex.set(Constants.DeliveryCatchSubsystemConstants.idlePower);
  }
}
//change
