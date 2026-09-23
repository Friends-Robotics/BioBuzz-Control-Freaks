package commands.UtilCommands;

import commands.base.Command;

public class RunCommand implements Command {
    private final Runnable action;

    public RunCommand(Runnable action) {
        this.action = action;

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        action.run();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
