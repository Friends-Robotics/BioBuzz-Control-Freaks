package org.firstinspires.ftc.teamcode.friends.Tests;

import Utils.Constants;
import commands.Groups.DeadlineCommandGroup;
import commands.Groups.ParallelCommandGroup;
import commands.Groups.RaceCommandGroup;
import commands.SimCommands.FakeIntakeCommand;
import commands.SimCommands.FakeShootCommand;
import commands.SimCommands.FakeSpinupCommand;
import commands.UtilCommands.TimeoutCommand;
import commands.UtilCommands.WaitCommand;
import commands.base.Command;
import commands.base.CommandScheduler;
import commands.Groups.SequentialCommandGroup;
import commands.SimCommands.FakeFollowPathCommand;

public class CommandTest {

    public static void main(String[] args) {

        CommandScheduler scheduler = new CommandScheduler();

        Command auto = new SequentialCommandGroup(
                new FakeShootCommand(),
                new FakeFollowPathCommand(),
                new TimeoutCommand(new FakeIntakeCommand(), 3),
                new DeadlineCommandGroup(
                        new FakeFollowPathCommand(),
                        new FakeSpinupCommand()
                ),
                new FakeShootCommand(),
                new FakeFollowPathCommand(),
                new TimeoutCommand(new FakeIntakeCommand(), 3),
                new DeadlineCommandGroup(
                        new FakeFollowPathCommand(),
                        new FakeSpinupCommand()
                ),
                new FakeShootCommand()
        );

        scheduler.schedule(auto);

        while (scheduler.isScheduled(auto)) {
            scheduler.run();
        }

        System.out.println("AUTO FINISHED");
    }
}