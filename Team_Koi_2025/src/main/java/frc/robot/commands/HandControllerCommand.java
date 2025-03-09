package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RobotHandSubsystem;
import frc.robot.Constants;
import frc.robot.Constants.RobotHandConstants;;

public class HandControllerCommand extends Command {
    private final RobotHandSubsystem m_HandSubsystem;
    private final int exec_dir; //direction for the grabbing/releasing
    private final int end_dir;
    public HandControllerCommand(RobotHandSubsystem hand, int exec_dir, int end_dir){
        m_HandSubsystem=hand;
        addRequirements(hand);
        this.exec_dir = exec_dir;
        this.end_dir = end_dir;
    }
    
    @Override
    public void execute(){
        m_HandSubsystem.powerHand(exec_dir, end_dir); //Apply grabbing power positively
    }

    @Override
    public void end(boolean interrupted){
        m_HandSubsystem.powerHand(end_dir != 0 ? RobotHandConstants.IDLE_POWER : RobotHandConstants.STOPING_POWER, 1); //Apply idle power positively to keep the object grabbed
    }

}