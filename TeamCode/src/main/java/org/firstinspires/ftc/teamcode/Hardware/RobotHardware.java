package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class RobotHardware {


    public RobotHardware(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap) {
        DriveHardware(hardwareMap);
        LiftHardware(hardwareMap);


    }

    public void DriveHardware(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap) {

        final DcMotor BRM, BLM, FRM, FLM;

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

    public void LiftHardware(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap)
    {
        final DcMotor M;

        M = hardwareMap.get(DcMotor.class, "Lift");
        M.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        M.setDirection(DcMotorSimple.Direction.FORWARD);

    }



}
