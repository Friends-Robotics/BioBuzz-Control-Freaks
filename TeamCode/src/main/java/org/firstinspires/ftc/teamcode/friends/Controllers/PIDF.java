package org.firstinspires.ftc.teamcode.friends.Controllers;

import com.pedropathing.controllers.PIDController;
import com.qualcomm.robotcore.util.Range;

public class PIDF extends PIDController {

    private double kS;
    private double kV;
    private double kA;
    private double kG;

    private double minOutput = 0.0;
    private double maxOutput = 1.0;

    public PIDF(
            double kP,
            double kI,
            double kD,
            double kS,
            double kV,
            double kA,
            double kG,
            double integralLimit
    ) {
        super(kP, kI, kD);

        this.kS = kS;
        this.kV = kV;
        this.kA = kA;
        this.kG = kG;
    }

    @Override
    public double calculate(double target, double state) {
        return calculate(target, state, 0, 0);
    }

    public double calculate(
            double target,
            double state,
            double targetVel,
            double targetAccel
    ) {
        double pidOutput = super.calculate(target, state);

        double staticFF = Math.signum(target - state) * kS;
        double velocityFF = targetVel * kV;
        double accelerationFF = targetAccel * kA;
        double gravityFF = kG;

        double output =
                pidOutput
                        + staticFF
                        + velocityFF
                        + accelerationFF
                        + gravityFF;

        return Range.clip(output, minOutput, maxOutput);
    }

    public void setOutputBounds(double minOutput, double maxOutput) {
        this.minOutput = minOutput;
        this.maxOutput = maxOutput;
    }

    public void setkS(double kS) {
        this.kS = kS;
    }

    public void setkV(double kV) {
        this.kV = kV;
    }

    public void setkA(double kA) {
        this.kA = kA;
    }

    public void setkG(double kG) {
        this.kG = kG;
    }
}