// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class ElevatorDownCommand extends Command {
  private final ElevatorSubsystem m_subsystem;

  public ElevatorDownCommand(ElevatorSubsystem subsystem) {
    this.m_subsystem = subsystem;
    addRequirements(subsystem);
  }

  
  public void initialize() {
    m_subsystem.setTargetPosition(Constants.ElevatorConstants.ELEVATOR_START_POSITION);
  }

  // CHAT DID I DO IT? DID I COOK?

  @Override
  public void execute() {
      m_subsystem.setTargetVelocity(-Constants.ElevatorConstants.ELEVATOR_SPEED);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return m_subsystem.finish();
  }
}