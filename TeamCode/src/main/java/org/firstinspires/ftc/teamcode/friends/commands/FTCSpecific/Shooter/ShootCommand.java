package org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.Shooter;

import org.firstinspires.ftc.teamcode.friends.subsystems.ShooterSubsystem;

import java.util.Set;

import commands.base.Command;
import commands.base.Subsystem;

public class ShootCommand implements Command {

    ShooterSubsystem shooter;
    private double balls;
    public ShootCommand(ShooterSubsystem shooter, double balls)
    {
        this.shooter = shooter;
        this.balls = balls;
    }

    @Override
    public void initialize() {shooter.feed();}
    @Override
    public void execute() {


    }
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
