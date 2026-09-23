package org.firstinspires.ftc.teamcode.friends.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import commands.base.Subsystem;

public class DriveSubsystem implements Subsystem{

    private final DcMotor BRM;
    private final DcMotor BLM;
    private final DcMotor FRM;
    private final DcMotor FLM;

    public static final double DEADBAND = 0.05;
    public static final double SPEED_MULTIPLIER = 0.8;
    public static final double STRAFE_SPEED_MULTIPLIER = 0.9;
    public static final double MAX_ACCEL = 0.3;

    private double lastFL = 0;
    private double lastBL = 0;
    private double lastFR = 0;
    private double lastBR = 0;

    public DriveSubsystem(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap) {
        FRM = hardwareMap.get(DcMotor.class, "FRM");
        FRM.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FRM.setDirection(DcMotorSimple.Direction.FORWARD);

        FLM = hardwareMap.get(DcMotor.class, "FLM");
        FLM.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FLM.setDirection(DcMotorSimple.Direction.REVERSE);

        BRM = hardwareMap.get(DcMotor.class, "BRM");
        BRM.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BRM.setDirection(DcMotorSimple.Direction.FORWARD);

        BLM = hardwareMap.get(DcMotor.class, "BLM");
        BLM.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BLM.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void drive( double drive, double strafe, double rotate)
    {
        drive = Math.abs(drive) < DEADBAND ? 0 : drive;
        strafe = Math.abs(strafe) < DEADBAND ? 0 : strafe;
        rotate = Math.abs(rotate) < DEADBAND ? 0 : rotate;

        double targetFL = drive + (strafe * STRAFE_SPEED_MULTIPLIER) + rotate;
        double targetBL = drive - (strafe * STRAFE_SPEED_MULTIPLIER) + rotate;
        double targetFR = drive - (strafe * STRAFE_SPEED_MULTIPLIER) - rotate;
        double targetBR = drive + (strafe * STRAFE_SPEED_MULTIPLIER) - rotate;

        double max = Math.max(Math.abs(targetFL),
                Math.max(Math.abs(targetBL),
                        Math.max(Math.abs(targetFR),
                                Math.abs(targetBR))));

        if (max > 1.0) {
            targetFL /= max; targetBL /= max; targetFR /= max; targetBR /= max;
        }

        lastFL = ramp(lastFL, targetFL * SPEED_MULTIPLIER);
        lastBL = ramp(lastBL, targetBL * SPEED_MULTIPLIER);
        lastFR = ramp(lastFR, targetFR * SPEED_MULTIPLIER);
        lastBR = ramp(lastBR, targetBR * SPEED_MULTIPLIER);

        FLM.setPower(lastFL);
        BLM.setPower(lastBL);
        FRM.setPower(lastFR);
        BRM.setPower(lastBR);
    }

    public void stop() {
        FLM.setPower(0);
        BLM.setPower(0);
        FRM.setPower(0);
        BRM.setPower(0);

        lastFL = 0;
        lastBL = 0;
        lastFR = 0;
        lastBR = 0;
    }

    private double ramp(double current, double target) {
        double delta = target - current;
        if (Math.abs(delta) > MAX_ACCEL) {
            return current + (Math.signum(delta) * MAX_ACCEL);
        } else {
            return target;
        }
    }
}
