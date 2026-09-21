package org.firstinspires.ftc.teamcode.friends.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.friends.subsystems.DriveSubsystem;

@TeleOp
public class DriveTest extends OpMode {

    DriveSubsystem drive;
    @Override
    public void init()
    {
        drive = new DriveSubsystem(hardwareMap);
    }

    @Override
    public void loop()
    {
        drive.drive(gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x);
    }

}
