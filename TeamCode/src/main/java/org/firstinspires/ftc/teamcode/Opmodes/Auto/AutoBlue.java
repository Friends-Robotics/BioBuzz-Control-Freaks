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
import org.firstinspires.ftc.teamcode.friends.commands.FTCSpecific.Shooter.SpinUpShooterCommand;
import org.firstinspires.ftc.teamcode.friends.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.friends.subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.pedro.PedroConstants;


import Utils.Constants;
import commands.Groups.DeadlineCommandGroup;
import commands.Groups.SequentialCommandGroup;

import commands.base.Command;
import commands.base.CommandScheduler;

@Autonomous
public class AutoBlue extends OpMode {

    private final PoseFactory poseFactory = PoseFactory.degrees();

    private Follower follower;
    CommandScheduler scheduler = new CommandScheduler();
    HardwareMap hardwareMap;

    ShooterSubsystem shooter;
    DriveSubsystem drive;

    ShooterController controller;

    private final Pose startPose = poseFactory.of(24, 24, 0);
    private final Pose shootPose = poseFactory.of(24, 24, 0);

    private Path startToShoot() {
        return line(startPose, shootPose).linear(startPose, shootPose);
    }

    Command auto = new SequentialCommandGroup(
            new DeadlineCommandGroup(
                    new FollowPathCommand(follower, startToShoot(),drive),
                    new SpinUpShooterCommand(shooter, controller ,Constants.Shooter.TARGET_RPM )
            )
    );

    @Override
    public void init() {
        scheduler.cancelAll();
        follower = PedroConstants.create(hardwareMap);
        follower.setPose(startPose);
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
