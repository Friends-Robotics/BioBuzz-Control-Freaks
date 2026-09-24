package commands.SimCommands;

import commands.base.Command;

public class FakeIntakeCommand implements Command {
    int cycle = 0;
    @Override
    public void initialize() {
        System.out.println("Intake started");
    }

    @Override
    public void execute() {
        System.out.println("Intaking.... " + cycle);
        cycle++;
    }

    @Override
    public boolean isFinished() {
        return cycle >= 10;
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Intake ended");
    }
    //diddy stuck his BBC into epsteins bum..
}
