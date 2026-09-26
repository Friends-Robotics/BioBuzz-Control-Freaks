package org.firstinspires.ftc.teamcode.friends.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import commands.base.Subsystem;

public class IntakeSubsystem implements Subsystem {

    private final DcMotor intakeMotor;

    //Ball Tracker
    private final DigitalChannel beamBreak;
    private int ballCount = 0;
    private boolean ballJustLeft;
    private boolean previousBeamState = false;
    public IntakeSubsystem(HardwareMap hardwareMap)
    {
        intakeMotor = hardwareMap.get(DcMotor.class,"intake");

        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        beamBreak = hardwareMap.get(DigitalChannel.class, "beamBreak");
        beamBreak.setMode(DigitalChannel.Mode.INPUT);

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



    public void updateBallCount() {
        boolean beamBroken = isBallDetected();

        // Ball has just entered
        if (beamBroken && !previousBeamState) {
            ballCount++;
        }

        // Ball has just left
        ballJustLeft = !beamBroken && previousBeamState;

        previousBeamState = beamBroken;
    }


    public boolean ballJustLeft()
    {
        return ballJustLeft;
    }


    public boolean isBallDetected() {
        return !beamBreak.getState();
    }

    public int getBallCount() {
        return ballCount;
    }

    public void removeBall() {
        if (ballCount > 0) {
            ballCount--;
        }
    }

    public void resetBallCount() {
        ballCount = 0;
    }




}
