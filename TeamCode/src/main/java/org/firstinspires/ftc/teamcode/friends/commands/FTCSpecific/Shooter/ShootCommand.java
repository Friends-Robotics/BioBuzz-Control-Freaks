package org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.Shooter;

import org.firstinspires.ftc.teamcode.friends.Controllers.ShooterController;
import org.firstinspires.ftc.teamcode.friends.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.friends.subsystems.ShooterSubsystem;

import java.util.Set;

import Utils.Constants;
import commands.base.Command;
import commands.base.Subsystem;

public class ShootCommand implements Command {

    private final ShooterSubsystem shooter;
    private final ShooterController controller;
    private final IntakeSubsystem intake;
    private final double targetRPM;

    private double power;
    private int ballsShot;
    private int ballsSinceRecovery = 0;

    private boolean isFinished = false;


    private enum ShootState {
        SPINNING_UP,
        SHOOTING,
        RECOVERING,
        FINISHED

    }

    private ShootState currentState = ShootState.SPINNING_UP;

    public ShootCommand(
            ShooterSubsystem shooter,
            ShooterController controller,
            IntakeSubsystem intake,
            double targetRPM
            ) {

        this.shooter = shooter;
        this.controller = controller;
        this.intake = intake;
        this.targetRPM = targetRPM;
    }

    @Override
    public void initialize() {}
    @Override
    public void execute() {

        intake.updateBallCount();
        SetRPM();

        switch(currentState) {

            case SPINNING_UP:


                if (controller.isReady()) {

                    currentState = ShootState.SHOOTING;
                }
                break;

            case SHOOTING:


                shooter.feed();

                if (intake.ballJustLeft()) {
                    intake.removeBall();
                    ballsShot++;
                    ballsSinceRecovery++;
                }

                if (ballsShot >= Constants.Intake.MaxBalls) {
                    currentState = ShootState.FINISHED;
                }
                else if (ballsSinceRecovery >= Constants.Intake.ballsBeforeRecovery) {
                    ballsSinceRecovery = 0;
                    currentState = ShootState.RECOVERING;
                }
                break;

            case RECOVERING:

                shooter.stopFeed();

                if(controller.isReady() )
                {
                    currentState = ShootState.SHOOTING;
                }
                break;

            case FINISHED:

                isFinished = true;
                break;

        }

    }
    @Override
    public boolean isFinished() {return isFinished;}
    @Override
    public void end(boolean interrupted) {
        shooter.stopFeed();
        controller.reset();
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return Set.of(shooter, intake);
    }

    private void SetRPM()
    {
        power = controller.update(targetRPM, controller.getRPM());

        shooter.setPower(power);
    }


}
