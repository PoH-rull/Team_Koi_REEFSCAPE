package frc.robot.commands.DeliveryCatchCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DeliveryCatchSubsystem.DeliveryCatchSubsystem;

import frc.robot.Constants;

public class CatchGamePieceCommand extends CommandBase {
    private final DeliveryCatchSubsystem deliveryCatchSubsystem;

    public CatchGamePieceCommand(DeliveryCatchSubsystem subsystem) {
        deliveryCatchSubsystem = subsystem;
        addRequirements(deliveryCatchSubsystem);
    }

    @Override
    public void execute() {
        deliveryCatchSubsystem.powerEngine(Constants.DeliveryCatchSubsystemConstants.power, 1); // power the engine positively
    }

    @Override
    public void end(boolean interrupted) {
        deliveryCatchSubsystem.powerEngine(Constants.DeliveryCatchSubsystemConstants.idlePower, 1); // moves motor to idle power
    }
}
