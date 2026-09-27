package org.firstinspires.ftc.teamcode.friends.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.friends.Controllers.ShooterController;
import org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.Shooter.ShootCommand;
import org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.Shooter.SpinUpShooterCommand;
import org.firstinspires.ftc.teamcode.friends.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.friends.subsystems.ShooterSubsystem;

import Utils.Constants;
import commands.base.Command;
import commands.base.CommandScheduler;

@TeleOp
public class AutoShootTest extends OpMode {

    ShooterSubsystem shooter;
    IntakeSubsystem intake;
    CommandScheduler scheduler;

    ShooterController controller;

    Command shootCommand;
    Command spinShooterCommand;

    Gamepad currentGamepad1 = new Gamepad();
    Gamepad previousGamepad1 = new Gamepad();


    public void init()
    {
        scheduler = new CommandScheduler();
        shooter = new ShooterSubsystem(hardwareMap);
        intake = new IntakeSubsystem(hardwareMap);
        controller = new ShooterController();

        shootCommand = new ShootCommand(shooter, controller,intake, Constants.Shooter.TARGET_RPM);
        spinShooterCommand = new SpinUpShooterCommand(shooter, controller, Constants.Shooter.TARGET_RPM);
    }

    public void start()
    {

    }

    public void loop()
    {
        if (currentGamepad1.a && !previousGamepad1.a) {
            scheduler.schedule(shootCommand);
        }

        if (currentGamepad1.b && !previousGamepad1.b) {
            scheduler.schedule(spinShooterCommand);
        }

        scheduler.run();

        previousGamepad1.copy(currentGamepad1);
    }
}
