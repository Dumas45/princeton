package study.algs4.exercise_1_1_32;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Arrays;

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
    private static final int MAX_MARKS = 9;

    public static void main(String[] args) {
        if (args.length != 3) throw new IllegalArgumentException("wrong arguments");
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);

        if (N < 1) throw new IllegalArgumentException("wrong argument N");
        if (l >= r) throw new IllegalArgumentException("wrong arguments: l and r");

        double[] values = StdIn.readAllDoubles();

        plot(N, l, r, values);
    }

    private static void plot(int N, double l, double r, double[] values) {
        if (N < 1 || l >= r) throw new IllegalArgumentException();
        if (values.length == 0) throw new IllegalArgumentException();

        double[] bounds = new double[N + 1];
        double step = (r - l) / N;
        for (int i = 0; i < N; i++) {
            bounds[i] = l + i * step;
        }
        bounds[N] = r;

        int[] counts = new int[N];
        Arrays.fill(counts, 0);

        for (double value : values) {
            int rank = rank(value, bounds);
            if (rank >= 0) {
                counts[rank] += 1;
            }
        }

        drawHistogram(l, r, counts);
    }

    private static int rank(double key, double[] bounds) {
        int low = 0;
        int high = bounds.length - 1;

        if (Double.compare(key, bounds[low]) < 0 || Double.compare(key, bounds[high]) > 0) return -1;

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            int compared = Double.compare(key, bounds[mid]);
            if (compared < 0) {
                high = mid;
            } else if (compared > 0) {
                low = mid;
            } else {
                return mid;
            }
        }

        return low;
    }

    private static void drawHistogram(double l, double r, int[] counts) {
        final double LEFT_X = 0.1;
        final double RIGHT_X = 0.9;
        final double BOTTOM_Y = 0.1;
        final double TOP_Y = 0.9;

        int sum = 0;
        int max = 0;
        for (int i : counts) {
            sum += i;
            max = Math.max(max, i);
        }

        StdDraw.line(LEFT_X - 0.05, BOTTOM_Y, RIGHT_X + 0.05, BOTTOM_Y);
        DecimalFormat df = new DecimalFormat("#.###");
        int intervals = Math.min(MAX_MARKS - 1, counts.length);
        double interval = (r - l) / intervals;
        double step = (RIGHT_X - LEFT_X) / intervals;
        for (int i = 0; i <= intervals; i++) {
            double dx = 0.1 + i * step;
            StdDraw.line(dx, BOTTOM_Y, dx, BOTTOM_Y - 0.03);
            StdDraw.text(dx, BOTTOM_Y - 0.07, df.format(l + i * interval));
        }

        StdDraw.line(LEFT_X, BOTTOM_Y - 0.05, LEFT_X, TOP_Y + 0.05);
        StdDraw.line(LEFT_X - 0.03, TOP_Y, LEFT_X, TOP_Y);
        StdDraw.text(LEFT_X - 0.05, TOP_Y - 0.05, Integer.toString(max));

        if (sum > 0) {
            step = (RIGHT_X - LEFT_X) / counts.length;
            for (int i = 0; i < counts.length; i++) {
                double x1 = LEFT_X + i * step;
                double y1 = BOTTOM_Y;
                double x2 = x1 + step;
                double y2 = BOTTOM_Y + (TOP_Y - BOTTOM_Y) * counts[i] / max;

                StdDraw.setPenColor(new Color(230, 230, 250));
                StdDraw.filledRectangle((x2 + x1) / 2, (y2 + y1) / 2, (x2 - x1) / 2, (y2 - y1) / 2);
                StdDraw.setPenColor(new Color(100, 149, 237));
                StdDraw.rectangle((x2 + x1) / 2, (y2 + y1) / 2, (x2 - x1) / 2, (y2 - y1) / 2);
            }
        }
    }
}
