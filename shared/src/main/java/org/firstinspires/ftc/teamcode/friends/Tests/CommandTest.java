package org.firstinspires.ftc.teamcode.friends.Tests;

import commands.base.Command;
import commands.base.CommandScheduler;
import commands.Groups.SequentialCommandGroup;
import commands.SimCommands.FakeFollowPathCommand;

public class CommandTest {

    public static void main(String[] args) {

        CommandScheduler scheduler = new CommandScheduler();

        Command auto = new SequentialCommandGroup(
                new FakeFollowPathCommand()
        );

        scheduler.schedule(auto);

        while (scheduler.isScheduled(auto)) {
            scheduler.run();
        }

        System.out.println("AUTO FINISHED");
    }
}