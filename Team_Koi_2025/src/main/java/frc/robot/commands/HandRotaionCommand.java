package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HandRotaionSubSystem;

public class HandRotaionCommand extends Command {
    public final HandRotaionSubSystem handRoSubsystem;
    private Timer timer = new Timer();
    public HandRotaionCommand(HandRotaionSubSystem handRo){
        handRoSubsystem=handRo;
        addRequirements(handRo);
        timer.reset();
    }

    public void execute(int speed){
        handRoSubsystem.turnArm(speed);
  }
    @Override
    public boolean isFinished() {
        //when the motor got to the right angle
        return handRoSubsystem.getFinished();
    }
}
