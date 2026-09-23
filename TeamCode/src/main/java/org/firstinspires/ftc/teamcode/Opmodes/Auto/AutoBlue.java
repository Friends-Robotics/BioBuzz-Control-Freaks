package org.firstinspires.ftc.teamcode.Opmodes.Auto;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.pedroPathing.Paths.BluePaths;

import commands.Groups.SequentialCommandGroup;
import commands.SimCommands.FakeFollowPathCommand;
import commands.SimCommands.FakeIntakeCommand;
import commands.base.Command;
import commands.base.CommandScheduler;

@Autonomous
public class AutoBlue extends OpMode {

    private Follower follower;
    CommandScheduler scheduler = new CommandScheduler();

    Command auto = new SequentialCommandGroup(
            new FakeFollowPathCommand(),
            new FakeIntakeCommand()
    );

    @Override
    public void init() {
        scheduler.cancelAll();
        follower = Constants.create(hardwareMap);
        follower.setPose();
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
        // add your other methods needed in loop here
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
