package org.firstinspires.ftc.teamcode.friends.tests;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.friends.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.friends.subsystems.Limelight;


@TeleOp(name = "Limelight Test", group = "Test")
public class LimelightTest extends LinearOpMode {
    Limelight limelight = new Limelight(hardwareMap);
    int index = 0;
    int rate = 100;


    @Override
    public void runOpMode(){
        limelight.Start();

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()){
            limelight.Update();
            if(gamepad1.dpad_right)
            {
                index++;
            }
            if(gamepad1.dpad_left)
            {
                index--;
            }
            if(gamepad1.dpad_up)
            {
                rate += 100;
            }
            if(gamepad1.dpad_down)
            {
                rate -= 100;
            }

            limelight.Switch(index);
            limelight.SetRate(rate);

            HandleTelemetry();

        }
    }

    public void HandleTelemetry()
    {
        telemetry.addLine("------TELEMETRY------");
        telemetry.addData("Pipeline -- ", index);
        telemetry.addLine();
        telemetry.addData("Rate hz -- ", rate);
        telemetry.addLine();
        telemetry.addData("Tx -- ",limelight.tx);
        telemetry.addData("Ty -- ",limelight.ty);
        telemetry.addData("Ta -- ",limelight.ta);
        //nigeria
    }

}