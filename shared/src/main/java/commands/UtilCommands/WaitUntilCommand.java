package commands.UtilCommands;

import java.util.function.BooleanSupplier;

import commands.base.Command;

public class WaitUntilCommand implements Command {
    private final BooleanSupplier condition;

    public WaitUntilCommand(BooleanSupplier condition) {
        this.condition = condition;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return condition.getAsBoolean();
    }

    @Override
    public void end(boolean interrupted) {

    }
}
