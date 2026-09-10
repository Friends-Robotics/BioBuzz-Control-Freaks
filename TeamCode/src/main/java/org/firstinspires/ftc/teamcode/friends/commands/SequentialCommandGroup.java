package org.firstinspires.ftc.teamcode.friends.commands;

import java.util.Arrays;
import java.util.List;

public class SequentialCommandGroup implements Command {
    private final List<Command> commands;
    private int currentCommand = 0;
    public SequentialCommandGroup(Command... commands) {
        this.commands = Arrays.asList(commands);
    }

    @Override
    public void initialize() {

        currentCommand = 0;

        if(!commands.isEmpty()){
            commands.get(0).initialize();
        }
    }

    @Override
    public void execute() {

        if(currentCommand >= commands.size()) {
            return;
        }

        Command command = commands.get(currentCommand);

        command.execute();

        if(command.isFinished()) {
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

    public void end(boolean interrupted) {

        if(interrupted && currentCommand < commands.size()) {
            commands.get(currentCommand).end(true);
        }
    }




}
