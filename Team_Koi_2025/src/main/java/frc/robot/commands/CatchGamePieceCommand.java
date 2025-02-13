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
        deliveryCatchSubsystem.work(Constants.DeliveryCatchSubsystemConstants.power); // Calls the work() method
    }

    @Override
    public void end(boolean interrupted) {
        deliveryCatchSubsystem.stop(); // Stops motor when command ends
    }
}
