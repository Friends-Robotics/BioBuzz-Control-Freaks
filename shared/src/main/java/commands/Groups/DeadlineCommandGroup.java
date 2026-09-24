package commands.Groups;

import java.util.Iterator;

import commands.base.Command;

public class DeadlineCommandGroup extends CommandGroup{

    Command firstcommand;

    public DeadlineCommandGroup(Command firstcommand, Command... commands) {
        super(commands);
        this.firstcommand = firstcommand;
        checkForConflicts();
    }

    @Override
    public void initialize() {
        for (Command command : commands) {
            command.initialize();
        }
        firstcommand.initialize();
    }

    @Override
    public void execute() {

        Iterator<Command> iterator = commands.iterator();
        firstcommand.execute();

        while (iterator.hasNext()) {

            Command command = iterator.next();

            command.execute();

            if (firstcommand.isFinished()) {

                firstcommand.end(false);

                for (Command other : commands) {
                    if (other != firstcommand) {
                        other.end(true);
                    }
                }


                commands.clear();

                return;
            }

            if (command.isFinished()) {
                command.end(false);
                iterator.remove();
            }
        }
    }

    @Override
    public boolean isFinished() {
        return firstcommand.isFinished();
    }

    @Override
    public void end(boolean interrupted) {

        if (interrupted) {

            for (Command command : commands) {
                command.end(true);
            }

            firstcommand.end(true);
            commands.clear();
        }
    }
}
