package org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.Intake;

import org.firstinspires.ftc.teamcode.friends.subsystems.IntakeSubsystem;

import java.util.Set;

import commands.base.Command;
import commands.base.Subsystem;

public class IntakeCommand implements Command {

    private final IntakeSubsystem intake;
    private int power;

    public IntakeCommand(IntakeSubsystem intake, int power) {
        this.intake = intake;
        this.power = power;

        if(power > 1 && power <-1)
        {
            throw new IllegalArgumentException("Input power between -1 and 1 silly");
        }
    }


    @Override
    public void initialize() {}
    @Override
    public void execute() {intake.intake(power);}
    @Override
    public boolean isFinished() {return false;}
    @Override
    public void end(boolean interrupted) {}

    @Override
    public Set<Subsystem> getRequirements() {
        return Set.of(intake);
    }
}
