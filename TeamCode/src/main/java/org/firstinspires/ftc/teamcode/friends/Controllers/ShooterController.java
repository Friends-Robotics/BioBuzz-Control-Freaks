package org.firstinspires.ftc.teamcode.friends.Controllers;

import com.qualcomm.robotcore.util.ElapsedTime;

import Utils.Constants;
import Utils.LowPassFilter;

public class ShooterController {

    private final PIDF pidf;
    private final LowPassFilter rpmFilter;
    private final ElapsedTime readyTimer = new ElapsedTime();

    private double targetRPM;
    private double currentRPM;
    private double output;

    public ShooterController() {
        pidf = new PIDF(
                Constants.Shooter.kP,
                Constants.Shooter.kI,
                Constants.Shooter.kD,
                Constants.Shooter.kS,
                Constants.Shooter.kV,
                0,
                0,
                Constants.Shooter.iLimit
        );

        pidf.setOutputBounds(
                0,
                Constants.Shooter.MAX_POWER
        );

        rpmFilter = new LowPassFilter(
                Constants.Shooter.RPM_LPF_GAIN
        );
    }

    /**
     * Update shooter control.
     */
    public double update(double targetRPM, double measuredRPM) {

        this.targetRPM = targetRPM;
        currentRPM = rpmFilter.estimate(measuredRPM);

        output = pidf.calculate(
                targetRPM,
                currentRPM,
                targetRPM,
                0
        );

        return output;
    }

    /**
     * Returns whether the shooter is currently at its target RPM.
     */
    public boolean isAtTargetRPM() {
        return Math.abs(currentRPM - targetRPM)
                <= Constants.Shooter.RPM_TOLERANCE;
    }

    /**
     * Returns true when the shooter has been at the target RPM
     * consistently for the required amount of time.
     */
    public boolean isReady() {
        return isAtTargetRPM()
                && readyTimer.seconds() >= 0.5;
    }

    public double getRPM() {
        return currentRPM;
    }

    public double getTargetRPM() {
        return targetRPM;
    }

    public double getPower() {
        return output;
    }

    public void reset() {
        pidf.reset();
        rpmFilter.reset();
        readyTimer.reset();

        targetRPM = 0;
        currentRPM = 0;
        output = 0;
    }
}
