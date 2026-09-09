package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem {

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
