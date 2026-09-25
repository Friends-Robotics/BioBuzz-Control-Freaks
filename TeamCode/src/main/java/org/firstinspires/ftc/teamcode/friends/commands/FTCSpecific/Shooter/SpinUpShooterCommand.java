package org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.Shooter;

import org.firstinspires.ftc.teamcode.friends.subsystems.ShooterSubsystem;

import java.util.Set;

import commands.UtilCommands.RunCommand;
import commands.UtilCommands.WaitUntilCommand;
import commands.base.Command;
import commands.base.Subsystem;

public class SpinUpShooterCommand implements Command {


    double TargetRPM;
    ShooterSubsystem shooter;
    public SpinUpShooterCommand(ShooterSubsystem shooter, double TargetRPM)
    {

        this.TargetRPM = TargetRPM;
        this.shooter = shooter;
    }

    @Override
    public void initialize() {shooter.setRPM(TargetRPM);}
    @Override
    public void execute() {shooter.setRPM(TargetRPM);}
    @Override
    public boolean isFinished() {return false;}
    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public Set<Subsystem> getRequirements() {
        return Set.of(shooter);
    }

}
