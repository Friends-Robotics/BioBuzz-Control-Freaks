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


                command.end(false);


                for (Command other : commands) {
                    if (other != command) {
                        other.end(true);
                    }
                }

                // The race is over
                commands.clear();

                return;
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