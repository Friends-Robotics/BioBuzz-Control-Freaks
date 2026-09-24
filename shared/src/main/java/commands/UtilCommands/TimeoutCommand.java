package commands.UtilCommands;

import commands.base.Command;

public class TimeoutCommand implements Command {

    private long startTime;
    private final double timeout;
    private final Command command;
    private boolean timedOut;

    public TimeoutCommand(Command command, double timeout) {
        this.command = command;
        this.timeout = timeout;
    }

    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
        command.initialize();
    }

    @Override
    public void execute() {
        command.execute();
    }

    @Override
    public boolean isFinished() {
        if (command.isFinished()) {
            timedOut = false;
            return true;
        }
        else if ((System.currentTimeMillis() - startTime) / 1000.0 >= timeout) {
            timedOut = true;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void end(boolean interrupted) {
        command.end(interrupted || timedOut);
    }
}
