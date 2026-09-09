package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class LiftSubsystem {
    private final DcMotorEx BottomMotor1, BottomMotor2;

    public void Lift(){

    }

    public LiftSubsystem(DcMotorEx bottomMotor1, DcMotorEx bottomMotor2) {
        BottomMotor1 = bottomMotor1;
        BottomMotor2 = bottomMotor2;
    }
}
