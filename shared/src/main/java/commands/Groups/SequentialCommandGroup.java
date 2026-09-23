package commands.Groups;

import commands.base.Command;

public class SequentialCommandGroup extends CommandGroup {

    private int currentCommand = 0;

    public SequentialCommandGroup(Command... commands) {
        super(commands);
    }

    @Override
    public void initialize() {
        if (!commands.isEmpty()) {
            commands.get(0).initialize();
        }
    }

    @Override
    public void execute() {

        if (currentCommand >= commands.size()) {
            return;
        }

        Command command = commands.get(currentCommand);

        command.execute();

        if (command.isFinished()) {

            command.end(false);

            currentCommand++;

            if (currentCommand < commands.size()) {
                commands.get(currentCommand).initialize();
            }
        }
    }

    @Override
    public boolean isFinished() {
        return currentCommand >= commands.size();
    }

    @Override
    public void end(boolean interrupted) {

        if (interrupted && currentCommand < commands.size()) {
            commands.get(currentCommand).end(true);
        }
    }
}
