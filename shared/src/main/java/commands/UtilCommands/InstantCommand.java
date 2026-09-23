package commands.UtilCommands;

import commands.base.Command;


public class InstantCommand implements Command {

    private final Runnable action;

    public InstantCommand(Runnable action) {
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
        return true;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
