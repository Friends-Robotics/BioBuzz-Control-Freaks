package commands.Groups;

import commands.base.Command;

import java.util.Iterator;

public class ParallelCommandGroup extends CommandGroup {

    public ParallelCommandGroup(Command... commands) {
        super(commands);
        checkForConflicts();
    }

    @Override
    public void initialize() {
        for (Command command : commands) {
            command.initialize();
        }
    }

    @Override
    public void execute() {

        Iterator<Command> iterator = commands.iterator();

        while (iterator.hasNext()) {

            Command command = iterator.next();

            command.execute();

            if (command.isFinished()) {
                command.end(false);
                iterator.remove();
            }
        }
    }

    @Override
    public boolean isFinished() {
        return commands.isEmpty();
    }

    @Override
    public void end(boolean interrupted) {

        if (interrupted) {

            for (Command command : commands) {
                command.end(true);
            }

            commands.clear();
        }
    }
}
