package org.firstinspires.ftc.teamcode.friends.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import commands.base.Subsystem;

public class IntakeSubsystem implements Subsystem {

    private final DcMotor intakeMotor;

    public IntakeSubsystem(HardwareMap hardwareMap)
    {
        intakeMotor = hardwareMap.get(DcMotor.class,"intake");

        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    public void intake(double power) {
        intakeMotor.setPower(power);
    }

    public void outtake(double power) {
        intakeMotor.setPower(-power);
    }

    public void stop() {
        intakeMotor.setPower(0);
    }




}
