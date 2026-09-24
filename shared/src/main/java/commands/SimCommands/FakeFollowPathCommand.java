package commands.SimCommands;

import commands.base.Command;

public class FakeFollowPathCommand implements Command {

    private int cycles;
    @Override
    public void initialize() {
        System.out.println("Path started");
    }

    @Override
    public void execute() {
        cycles++;
        System.out.println("Following Path...." );

    }

    @Override
    public boolean isFinished() {
        return cycles >= 100;
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Path ended");
    }
}
