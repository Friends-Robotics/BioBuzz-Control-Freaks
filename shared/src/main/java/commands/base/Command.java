package commands.base;

import java.util.Set;

public interface Command {
    void initialize();
    void execute();
    void end(boolean interrupted);
    boolean isFinished();

    default Set<Subsystem> getRequirements() {
        return Set.of();
    }

}
