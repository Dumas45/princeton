package exercise_1_1_32;

import edu.princeton.cs.introcs.stdlib.StdIn;

/**
 * Exercise 1.1.32 Histogram.
 * Suppose that the standard input stream is a sequence of
 * double values. Write a program that takes an integer N
 * and two double values l and r from the command line and
 * uses StdDraw to plot a histogram of the count of the
 * numbers in the standard input stream that fall in each
 * of the N intervals defined by dividing (l, r) into N
 * equal-sized intervals.
 *
 * @author Alexei
 */
public class Histogram {
    public static void main(String[] args) {
        if (args.length != 3) throw new IllegalArgumentException("wrong arguments");
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);

        if (N < 1) throw new IllegalArgumentException("wrong argument N");
        if (l >= r) throw new IllegalArgumentException("wrong arguments: l and r");

        plot(N, l, r);
    }

    private static void plot(int N, double l, double r) {
        System.out.println("N = " + N);
        System.out.println("l = " + l);
        System.out.println("r = " + r);

        while (!StdIn.isEmpty()) {
            System.out.println(StdIn.readDouble());
        }
    }
}
