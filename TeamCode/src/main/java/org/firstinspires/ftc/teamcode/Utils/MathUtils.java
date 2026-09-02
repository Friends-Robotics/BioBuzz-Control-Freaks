package org.firstinspires.ftc.teamcode.Utils;

public class MathUtils {
    public static double normalizeAngle(double angle) {
        while (angle > Math.PI) {
            angle -= 2.0 * Math.PI;
        }

        while (angle < -Math.PI) {
            angle += 2.0 * Math.PI;
        }

        return angle;
    }

    public static double clamp(
            double min,
            double max,
            double value
    ) {
        return Math.max(min, Math.min(max, value));
    }

    public static double deadband(
            double value,
            double threshold
    ) {

        if (Math.abs(value) < threshold) {
            return 0;
        }

        return value;
    }

}
