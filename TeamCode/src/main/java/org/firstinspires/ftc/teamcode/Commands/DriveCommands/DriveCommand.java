package org.firstinspires.ftc.teamcode.Commands.DriveCommands;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Commands.Command;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;

public class DriveCommand implements Command {
    private final DriveSubsystem drive;
    private final Gamepad gamepad;

    public DriveCommand(DriveSubsystem drive, Gamepad gamepad) {
        this.drive = drive;
        this.gamepad = gamepad;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        drive.drive(
                -gamepad.left_stick_y,
                gamepad.left_stick_x,
                gamepad.right_stick_x
        );
    }

    @Override
    public void end() {
        drive.stop();
    }

    @Override
    public boolean isFinished() {
        return false; //Never finishes
    }

}
