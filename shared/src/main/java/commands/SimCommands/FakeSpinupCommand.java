package commands.SimCommands;

import commands.base.Command;

public class FakeSpinupCommand implements Command {

    int RPM = 0;

    @Override
    public void initialize() {
        System.out.println("SPINNING UP");
    }

    @Override
    public void execute() {
        System.out.println("Shooting, RPM: " + RPM);
        RPM+= 100;
    }

    @Override
    public boolean isFinished() {
        return RPM >= 3300;
    }

    @Override
    public void end(boolean interrupted) {

        if(!interrupted)
        {
            System.out.println("Reached RPM");
        }
        else{
            System.out.println("Cancelled RPM: " + RPM);
        }
    }
}
