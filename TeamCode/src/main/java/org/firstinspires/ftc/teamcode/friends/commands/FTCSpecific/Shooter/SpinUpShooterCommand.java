package org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.Shooter;

import org.firstinspires.ftc.teamcode.friends.Controllers.ShooterController;
import org.firstinspires.ftc.teamcode.friends.subsystems.ShooterSubsystem;

import java.util.Set;

import commands.UtilCommands.RunCommand;
import commands.UtilCommands.WaitUntilCommand;
import commands.base.Command;
import commands.base.Subsystem;

public class SpinUpShooterCommand implements Command {

    private final ShooterSubsystem shooter;
    private final ShooterController controller;
    private final double targetRPM;

    public SpinUpShooterCommand(
            ShooterSubsystem shooter,
            ShooterController controller,
            double targetRPM) {

        this.shooter = shooter;
        this.controller = controller;
        this.targetRPM = targetRPM;
    }

    @Override
    public void initialize() {
        controller.reset();
    }

    @Override
    public void execute() {
        double power = controller.update(
                targetRPM,
                shooter.getRPM()
        );

        shooter.setPower(power);
    }

    @Override
    public boolean isFinished() {
        return false; //Continues to run until the deadlinecommand terminates it
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            shooter.setPower(0);
        }
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return Set.of(shooter);
    }

}
