package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class ArmCommand extends Command{
    private final ArmSubsystem m_ArmSubsystem;
    private final double angle;
    private final boolean inverted;
    public ArmCommand(ArmSubsystem subsystem,double anglle,boolean invertedd){
        m_ArmSubsystem=subsystem;
        angle=anglle;
        inverted=invertedd;
        addRequirements(subsystem);
    }
    public void execute(){
        m_ArmSubsystem.moveArm(angle,inverted);
        System.out.println("I DO STUFF");
    }

   // public void end(boolean interrupted){
    //    m_ArmSubsystem.stopArm();
    //    System.out.println("I ENDED");
   // }

    @Override
    public boolean isFinished() {
        return m_ArmSubsystem.getFinished();
    }
}
