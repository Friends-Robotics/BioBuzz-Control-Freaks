package commands.UtilCommands;

import commands.base.Command;

public class WaitCommand implements Command {

    private long startTime;
    private final double duration;

    public WaitCommand(double duration) {
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
        return System.currentTimeMillis() - startTime >= duration * 1000;
    }

    @Override
    public void end(boolean interrupted) {

    }

}
