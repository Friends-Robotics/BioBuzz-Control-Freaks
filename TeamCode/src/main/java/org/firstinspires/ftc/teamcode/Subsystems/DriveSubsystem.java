package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class DriveSubsystem {

    private DcMotorEx frontLeftMotor;
    private DcMotorEx backLeftMotor;
    private DcMotorEx frontRightMotor;
    private DcMotorEx backRightMotor;
    public static final double DEADBAND = 0.05;
    public static final double SPEED_MULTIPLIER = 0.8;
    public static final double STRAFE_SPEED_MULTIPLIER = 0.9;
    public static final double MAX_ACCEL = 0.3;

    private double lastFL = 0;
    private double lastBL = 0;
    private double lastFR = 0;
    private double lastBR = 0;

    public DriveSubsystem(DcMotorEx frontLeftMotor, DcMotorEx backLeftMotor, DcMotorEx frontRightMotor, DcMotorEx backRightMotor) {
        this.frontLeftMotor = frontLeftMotor;
        this.backLeftMotor = backLeftMotor;
        this.frontRightMotor = frontRightMotor;
        this.backRightMotor = backRightMotor;
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

        frontLeftMotor.setPower(lastFL);
        backLeftMotor.setPower(lastBL);
        frontRightMotor.setPower(lastFR);
        backRightMotor.setPower(lastBR);
    }

    public void stop() {
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);

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
