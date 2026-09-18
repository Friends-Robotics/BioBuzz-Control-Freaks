package org.firstinspires.ftc.teamcode.friends.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "Motor Test", group = "Test")
public class ShooterTest extends LinearOpMode {

    private DcMotor motor;

    private double power = 0.0;
    private boolean motorEnabled = false;

    @Override
    public void runOpMode() throws InterruptedException {

        motor = hardwareMap.get(DcMotor.class, "Motor");

        Gamepad currentGamepad1 = new Gamepad();
        Gamepad previousGamepad1 = new Gamepad();

        telemetry.addLine("Motor Test");
        telemetry.addLine("A = Toggle Motor");
        telemetry.addLine("D-pad Up/Down = Change Power");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            // Store previous and current gamepad states
            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);

            // Toggle motor on A press
            if (currentGamepad1.a && !previousGamepad1.a) {
                motorEnabled = !motorEnabled;
            }

            // Increase power
            if (currentGamepad1.dpad_up && !previousGamepad1.dpad_up) {
                power += 0.1;
            }

            // Decrease power
            if (currentGamepad1.dpad_down && !previousGamepad1.dpad_down) {
                power -= 0.1;
            }

            // Keep power between -1 and 1
            power = Math.max(-1.0, Math.min(1.0, power));

            // Run motor only when enabled
            if (motorEnabled) {
                motor.setPower(power);
            } else {
                motor.setPower(0);
            }

            telemetry.addData("Motor", motorEnabled ? "ON" : "OFF");
            telemetry.addData("Power", "%.1f", power);
            telemetry.update();
        }

        motor.setPower(0);
    }
}