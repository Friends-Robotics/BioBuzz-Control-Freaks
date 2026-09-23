package commands.Groups;

import java.util.Iterator;

import commands.base.Command;

public class RaceCommandGroup extends CommandGroup {

    public RaceCommandGroup(Command... commands) {
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
                for(Command command1 : commands)
                {
                    command1.end(true);
                    iterator.remove();
                }

                commands.clear();
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
