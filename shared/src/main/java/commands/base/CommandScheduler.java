package commands.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CommandScheduler {
    private List<Command> commands = new ArrayList<>();
    private Map<Subsystem, Command> requirements = new HashMap<>();

    public void schedule(Command command) {
        if (commands.contains(command)) {
            return;
        }

        for (Subsystem subsystem : command.getRequirements()) {

            Command occupyingCommand = requirements.get(subsystem);

            if (occupyingCommand != null) {
                cancel(occupyingCommand);
            }
        }

        command.initialize();
        commands.add(command);

        for (Subsystem subsystem : command.getRequirements()) {
            requirements.put(subsystem, command);
        }
    }

    public void run() {

        Iterator<Command> it = commands.iterator();

        while (it.hasNext()) {

            Command command = it.next();

            command.execute();

            if (command.isFinished()) {

                command.end(false);

                for (Subsystem subsystem : command.getRequirements()) {

                    if (requirements.get(subsystem) == command) {
                        requirements.remove(subsystem);
                    }
                }

                it.remove();
            }
        }
    }
    public void cancelAll() {
        for (Command command : commands) {
            command.end(true);
        }

        commands.clear();
    }

    public void cancel(Command command) {
        if (!commands.remove(command)) {
            return;
        }

        command.end(true);

        for (Subsystem subsystem : command.getRequirements()) {

            if (requirements.get(subsystem) == command) {
                requirements.remove(subsystem);
            }
        }
    }

    public boolean isScheduled(Command command) {
        return commands.contains(command);
    }

}
