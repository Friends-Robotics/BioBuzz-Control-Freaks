package Utils;

public class Math {

    public static double lerp(double start, double end, double t) {
        return start + (t * (end - start));
    }
}
