package org.firstinspires.ftc.teamcode.Commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommandScheduler {
    private List<Command> commands = new ArrayList<>();

    public void schedule(Command command) {
        command.initialize();
        commands.add(command);
    }

    public void run() {
        Iterator<Command> it = commands.iterator();

        while(it.hasNext()) {
            Command c = it.next();
            c.execute();

            if(c.isFinished()) {
                c.end();
                it.remove();
            }
        }
    }

}
