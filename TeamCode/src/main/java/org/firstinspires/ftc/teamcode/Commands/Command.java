package org.firstinspires.ftc.teamcode.Commands;

public interface Command {
    void initialize();
    void execute();
    void end();
    boolean isFinished();

}
