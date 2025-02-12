package frc.robot.subsystems.DeliveryCatchSubsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DeliveryCatchSubsystem extends SubsystemBase {
  // Declare vortex
  private CANSparkMax Vortex;

  public DeliveryCatchSubsystem() {
    // Set Vortex
    Vortex = new CANSparkMax(DeliveryCatchSubsystemConstants.DEVICE_ID, MotorType.kBrushless);
    Vortex.restoreFactoryDefaults();
  }

  // Starts the grabbing motor
  public void grab() {
    Vortex.set(DeliveryCatchSubsystemConstants.POWER);
  }

  // Reverses the grabbing motor, it should hopefully release the grabbed item
  public void release() {
    Vortex.set(-DeliveryCatchSubsystemConstants.POWER);
  }

  // Stops the motor when the buttons are released
  public void stop() {
    Vortex.set(0);
  }
}
//change
