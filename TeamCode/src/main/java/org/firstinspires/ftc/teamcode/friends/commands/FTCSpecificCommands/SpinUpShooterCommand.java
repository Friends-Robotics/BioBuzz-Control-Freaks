package org.firstinspires.ftc.teamcode.friends.commands.FTCSpecificCommands;

import org.firstinspires.ftc.teamcode.friends.subsystems.ShooterSubsystem;

import java.util.Set;

import commands.base.Command;
import commands.base.Subsystem;

public class SpinUpShooterCommand implements Command {

    double RPM;
    double TargetRPM;
    ShooterSubsystem shooter;
    public SpinUpShooterCommand(ShooterSubsystem shooter, double RPM, double TargetRPM)
    {
        this.RPM = RPM;
        this.TargetRPM = TargetRPM;
        this.shooter = shooter;
    }

    @Override
    public void initialize() {}
    @Override
    public void execute() {}
    @Override
    public boolean isFinished() {return true;}
    @Override
    public void end(boolean interrupted) { }

    @Override
    public Set<Subsystem> getRequirements() {
        return Set.of(shooter);
    }

}
