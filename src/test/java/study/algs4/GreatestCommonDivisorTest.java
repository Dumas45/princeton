package study.algs4;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static study.algs4.GreatestCommonDivisor.gcd;

class GreatestCommonDivisorTest {
    @Test
    void testGCD() {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        for (int i = 0; i < 1000000; i++) {
            int a = tlr.nextInt(1, 1111);
            int b = tlr.nextInt(1, 1111);
            assertEquals(gcd_greedy(a, b), gcd(a, b));
        }
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
}
