package commands.SimCommands;

import commands.base.Command;

public class FakeShootCommand implements Command {
    int cycle = 1;

    @Override
    public void initialize() {
        System.out.println("Shooting");
    }

    @Override
    public void execute() {
        System.out.println("Shooting.... " + cycle);
        cycle++;
    }

    @Override
    public boolean isFinished() {
        return cycle > 3;
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Shooting ended");
    }
}
