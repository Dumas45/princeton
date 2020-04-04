package study.algs4;

import java.util.concurrent.ThreadLocalRandom;

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

    private static void test() {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        for (int i = 0; i < 1000000; i++) {
            int a = tlr.nextInt(1, 1111);
            int b = tlr.nextInt(1, 1111);
            if (gcd(a, b) != gcd_greedy(a, b)) {
                throw new RuntimeException(a + ", " + b);
            }
        }
        System.out.println("OK");
    }

    private static int gcd_greedy(int a, int b) {
        if (a < 1 || b < 1) throw new IllegalArgumentException();

        for (int c = Math.max(a, b); c > 0 ; c--) {
            if (a % c == 0 && b % c == 0) {
                return c;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        test();
    }
}
