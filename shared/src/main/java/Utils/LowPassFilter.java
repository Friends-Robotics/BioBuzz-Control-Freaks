package Utils;

public class LowPassFilter {
    private final double gain;
    private double filteredValue;
    private boolean initialized;

    public LowPassFilter(double gain) {
        if (gain <= 0 || gain > 1) {
            throw new IllegalArgumentException("Gain must be between 0 and 1");
        }

        this.gain = gain;
    }

    public double estimate(double input) {

        if (!initialized) {
            filteredValue = input;
            initialized = true;
            return filteredValue;
        }

        filteredValue =
                filteredValue + gain * (input - filteredValue);

        return filteredValue;
    }

    public double getValue() {
        return filteredValue;
    }

    public void reset() {
        filteredValue = 0;
        initialized = false;
    }
}
