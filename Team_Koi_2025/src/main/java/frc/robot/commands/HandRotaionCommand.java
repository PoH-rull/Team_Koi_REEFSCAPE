package frc.robot.commands;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HandRotaionSubSystem;

public class HandRotaionCommand extends Command {
    public final HandRotaionSubSystem handRoSubsystem;
    private double degree;
    private boolean inverted;
    public HandRotaionCommand(HandRotaionSubSystem handRo,double angle,boolean invertedd){
        handRoSubsystem=handRo;
        degree=angle;
        inverted=invertedd;
        addRequirements(handRo);
    }

    public void execute(){
        handRoSubsystem.turnArm(degree,inverted);
  }
    @Override
    public boolean isFinished() {
        //when the motor got to the right angle
        return (Math.abs((degree-handRoSubsystem.getPosition())))<=5;
    }
}
