package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Subsystems.*;

public class DriveStraight extends Command {
    public void DriveStraight() {
        requires(Robot.driveTrain);
    }

    protected void initialize() {
        Robot.subsystem
    }
}