package Utils;

public final class Constants {

    // SHOOTER
    private Constants() {

    }

    public static final class Shooter {

        public static final double MAX_POWER = 1.0;

        public static final double MIN_POWER = 0.07;

        public static final double TICKS_PER_REV = 28.0;

        public static final double RPM_TOLERANCE = 100.0;

        // PID
        public static final double kP = 0.0;
        public static final double kI = 0.0;
        public static final double kD = 0.0;

        // Feedforward
        public static final double kS = 0.0;
        public static final double kV = 0.0;
        public static final double kA = 0.0;
        public static final double kG = 0.0;
        public static final double iLimit = 0;

        // Shooting
        public static final double TARGET_RPM = 3000.0;

        // Hood
        public static final double CLOSE_HOOD = 0.0;
        public static final double FAR_HOOD = 0.25;

        // Distance interpolation
        public static final double CLOSE_DISTANCE = 20.0;
        public static final double FAR_DISTANCE = 60.0;

        public static final double RPM_LPF_GAIN = 0.2; //For every update the program moves 20% closer to making a new measurement of rpm

        private Shooter() {}
    }



}
