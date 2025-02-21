package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class ArmCommand extends Command{
    private final ArmSubsystem m_ArmSubsystem;
    public ArmCommand(ArmSubsystem subsystem){
        m_ArmSubsystem=subsystem;
        addRequirements(subsystem);
    }
    public void execute(double speed){
        m_ArmSubsystem.moveArm(speed);
    }
    @Override
    public boolean isFinished() {
        return m_ArmSubsystem.getFinished();
    }
}
