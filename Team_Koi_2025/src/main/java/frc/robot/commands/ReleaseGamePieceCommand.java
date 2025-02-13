package frc.robot.commands.DeliveryCatchCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DeliveryCatchSubsystem.DeliveryCatchSubsystem;

import frc.robot.Constants;

public class ReleaseGamePieceCommand extends CommandBase {
    private final DeliveryCatchSubsystem deliveryCatchSubsystem;

    public ReleaseGamePieceCommand(DeliveryCatchSubsystem subsystem) {
        deliveryCatchSubsystem = subsystem;
        addRequirements(deliveryCatchSubsystem);
    }

    @Override
    public void execute() {
        deliveryCatchSubsystem.work(Constants.DeliveryCatchSubsystemConstants.releasePower); //calls release
    }

    @Override
    public void end(boolean interrupted) {
        deliveryCatchSubsystem.work(0); //stops the motor when released
    }
}
