package org.firstinspires.ftc.teamcode.friends.commands;

public interface Command {
    void initialize();
    void execute();
    void end(boolean interrupted);
    boolean isFinished();

}
