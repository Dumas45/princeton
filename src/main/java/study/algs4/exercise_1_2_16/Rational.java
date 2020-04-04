package study.algs4.exercise_1_2_16;

import java.util.Objects;

import static java.lang.Long.signum;
import static java.lang.Math.abs;

/**
 * Exercise 1.2.16
 *
 * Implement an immutable data type Rational
 * for rational numbers that supports addition,
 * subtraction, multiplication, and division.
 */
public class Rational {
    private final long numerator;
    private final long denominator;

    public Rational(long numerator, long denominator) {
        long sign = signum(numerator) * signum(denominator);
        numerator = abs(numerator);
        denominator = abs(denominator);
        long gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        this.numerator = sign * numerator;
        this.denominator = denominator;
    }

    /**
     * sum of this number and b
     */
    public Rational plus(Rational b) {
        throw new UnsupportedOperationException();
    }

    /**
     * difference of this number and b
     */
    public Rational minus(Rational b) {
        throw new UnsupportedOperationException();
    }

    /**
     * product of this number and b
     */
    public Rational times(Rational b) {
        throw new UnsupportedOperationException();
    }

    /**
     * quotient of this number and b
     */
    public Rational dividedBy(Rational b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return numerator == rational.numerator &&
                denominator == rational.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "(" + numerator + "/" + denominator + "=" + (double) numerator / denominator + ")";
    }

    /**
     * Greatest common divisor
     * Euclidean algorithm
     */
    private static long gcd(long a, long b) {
        if (a < 1 || b < 1) throw new IllegalArgumentException();

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

    public static void main(String[] args) {
        Rational r = new Rational(158, 34);
        System.out.println(r);
    }
}
