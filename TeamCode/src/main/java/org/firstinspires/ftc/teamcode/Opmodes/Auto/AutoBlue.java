package org.firstinspires.ftc.teamcode.Opmodes.Auto;

import static com.pedropathing.api.Paths.line;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.friends.Controllers.ShooterController;
import org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.FollowPathCommand;
import org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.Intake.IntakeCommand;
import org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.Shooter.ShootCommand;
import org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.Shooter.SpinUpShooterCommand;
import org.firstinspires.ftc.teamcode.friends.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.friends.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.friends.subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.pedro.PedroConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.Paths.BluePaths;


import Utils.Constants;
import commands.Groups.DeadlineCommandGroup;
import commands.Groups.SequentialCommandGroup;

import commands.base.Command;
import commands.base.CommandScheduler;

@Autonomous
public class AutoBlue extends OpMode {

    private final PoseFactory poseFactory = PoseFactory.degrees();
    BluePaths paths;

    private Follower follower;
    CommandScheduler scheduler = new CommandScheduler();
    HardwareMap hardwareMap;

    ShooterSubsystem shooter;
    DriveSubsystem drive;
    IntakeSubsystem intake;

    ShooterController controller;


    Command auto = new SequentialCommandGroup(
            new ShootCommand(shooter, controller, intake,Constants.Shooter.TARGET_RPM),
            new DeadlineCommandGroup(
                    new FollowPathCommand(follower, paths.startToScore(), drive),
                    new IntakeCommand(intake, 1)
            )
    );

    @Override
    public void init() {
        scheduler.cancelAll();
        drive = new DriveSubsystem(hardwareMap);
        intake = new IntakeSubsystem(hardwareMap);
        shooter = new ShooterSubsystem(hardwareMap);
        follower = PedroConstants.create(hardwareMap);
        follower.setPose(paths.startPose);
        follower.update();
    }
    @Override
    public void start() {
        scheduler.schedule(auto);
    }
    @Override
    public void loop() {
        follower.update();
        scheduler.run();
        HandleTelemetry();
    }
    void HandleTelemetry()
    {
        telemetry.addData("X", follower.pose().x());
        telemetry.addData("Y", follower.pose().y());
        telemetry.addData("Heading", Math.toDegrees(follower.pose().heading()));
        telemetry.addData("Follower Mode", follower.mode());
        telemetry.update();
    }

}
//noah is so cute i love him so much..
