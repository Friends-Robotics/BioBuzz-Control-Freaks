package commands.UtilCommands;

import java.util.function.BooleanSupplier;

import commands.base.Command;

public class ConditionalCommand implements Command{

    private final BooleanSupplier condition;
    private final Command ifCommand;
    private final Command elseCommand;
    private Command selectedCommand;
    public ConditionalCommand(BooleanSupplier condition, Command ifCommand, Command elseCommand) {
        if(ifCommand == null || elseCommand == null)
        {
            throw new IllegalArgumentException("One of the commands is null");
        }
        this.condition = condition;
        this.ifCommand = ifCommand;
        this.elseCommand = elseCommand;
    }

    @Override
    public void initialize() {

        if(condition.getAsBoolean())
        {
            selectedCommand = ifCommand;
        }
        else{
            selectedCommand = elseCommand;
        }
        selectedCommand.initialize();
    }

    @Override
    public void execute() {
        selectedCommand.execute();
    }

    @Override
    public boolean isFinished() {
        return selectedCommand.isFinished();
    }

    @Override
    public void end(boolean interrupted) {
        selectedCommand.end(interrupted);
    }
}
