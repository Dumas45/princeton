package study.algs4;

public class GreatestCommonDivisor {
    /**
     * Greatest common divisor
     * Euclidean algorithm
     */
    public static long gcd(long a, long b) {
        long min;
        long max;
        long tmp;
        if (a > b) {
            min = b;
            max = a;
        } else {
            min = a;
            max = b;
        }
        if (min < 0 || max < 1) throw new IllegalArgumentException();

        while (min != 0 && min != max) {
            tmp = max % min;
            if (tmp > min) {
                max = tmp;
            } else {
                max = min;
                min = tmp;
            }
        }

        return max;
    }
}
