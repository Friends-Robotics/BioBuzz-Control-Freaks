package commands.Groups;


import commands.base.Command;
import commands.base.Subsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class CommandGroup implements Command {

    protected final List<Command> commands = new ArrayList<>();

    public CommandGroup(Command... commands) {
        for (Command command : commands) {
            this.commands.add(command);
        }

    }

    @Override
    public Set<Subsystem> getRequirements() {

        Set<Subsystem> requirements = new HashSet<>();

        for (Command command : commands) {
            requirements.addAll(command.getRequirements());
        }

        return requirements;
    }

    protected void checkForConflicts() {

        for(Command command : commands) {
            for(Subsystem subsystem : command.getRequirements())
            {
                if(!getRequirements().add(subsystem))
                {
                    throw new IllegalArgumentException("Can't have commands that contain the same subsystem for this group silly...");
                }
            }

        }
    }


}
