package org.firstinspires.ftc.teamcode.friends.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import commands.base.Subsystem;

public class ShooterSubsystem implements Subsystem {

    private DcMotorEx shooterMotor1;
    private DcMotorEx shooterMotor2;
    private Servo feeder;
    private Servo hood;

    private final double FEEDER_UP_POSITION = 0.45;
    private final double FEEDER_DOWN_POSITION = 0.0;

    public static double SHOOTER_TICKS_PER_REV = 28;
    public static double MAX_POWER = 1;
    public static double MIN_POWER = 0.07;

    public ShooterSubsystem(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap){
        shooterMotor1 = hardwareMap.get(DcMotorEx.class, "Shooter1");
        shooterMotor2 = hardwareMap.get(DcMotorEx.class, "Shooter2");

        feeder = hardwareMap.get(Servo.class, "feeder");
        hood = hardwareMap.get(Servo.class, "hood");
    }

    public void setPower(double power) {
        if (power < MIN_POWER) power = MIN_POWER;
        else if (power > MAX_POWER) power = MAX_POWER;

        shooterMotor1.setPower(power);
        shooterMotor2.setPower(power);
    }

    public double getRPM() {
        return (getVelocity() * 60.0) / SHOOTER_TICKS_PER_REV;
    }

    public double getVelocity() { return (shooterMotor1.getVelocity() + shooterMotor2.getVelocity()) / 2.0; }

    public void setHoodPosition(double position) { hood.setPosition(position); }

    public void feed() { feeder.setPosition(FEEDER_UP_POSITION); }

    public void stopFeed() { feeder.setPosition(FEEDER_DOWN_POSITION); }

    public double getCurrent(CurrentUnit currentUnit) {
        return shooterMotor1.getCurrent(currentUnit) + shooterMotor2.getCurrent(currentUnit);
    }
}
