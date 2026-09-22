package commands.UtilCommands;

import commands.base.Command;

public class WaitCommand implements Command {

    private long startTime;
    private long duration;

    public WaitCommand(long duration) {
        this.duration = duration;
    }

    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() - startTime >= duration;
    }

    @Override
    public void end(boolean interrupted) {

    }

}
