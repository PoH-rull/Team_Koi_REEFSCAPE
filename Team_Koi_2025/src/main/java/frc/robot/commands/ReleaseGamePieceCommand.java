package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DeliveryCatchSubsystem;

import frc.robot.Constants;

public class ReleaseGamePieceCommand extends Command {
    private final DeliveryCatchSubsystem deliveryCatchSubsystem;

    public ReleaseGamePieceCommand(DeliveryCatchSubsystem subsystem) {
        deliveryCatchSubsystem = new DeliveryCatchSubsystem();
        addRequirements(deliveryCatchSubsystem);
    }

    @Override
    public void execute() {
        deliveryCatchSubsystem.powerEngine(Constants.DeliveryCatchSubsystemConstants.releasePower, -1); // power the engine positively
    }

    @Override
    public void end(boolean interrupted) {
        deliveryCatchSubsystem.Vortex.stopMotor();
    }
}
