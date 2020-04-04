package study.algs4.exercise_1_1_31;

import edu.princeton.cs.algs4.StdRandom;

import java.awt.Color;

import static edu.princeton.cs.algs4.StdDraw.circle;
import static edu.princeton.cs.algs4.StdDraw.filledCircle;
import static edu.princeton.cs.algs4.StdDraw.line;
import static edu.princeton.cs.algs4.StdDraw.setPenColor;

/**
 * Exercise 1.1.31 Random connections.
 * Write a program that takes as command-line arguments an integer N
 * and a double value p (between 0 and 1), plots N equally spaced dots
 * of size .05 on the circumference of a circle, and then, with
 * probability p for each pair of points, draws a gray line connecting
 * them.
 *
 * @author Alexei
 */
public class RandomConnections {
    private static final double CENTER_X = 0.5;
    private static final double CENTER_Y = 0.5;
    private static final double RADIUS = 0.42;
    private static final double DOT_RADIUS = 0.025;
    private static final double START_ANGLE = Math.PI / 6;
    private final static Color GRAY = new Color(128, 128, 128);

    public static void main(String[] args) {
        if (args.length != 2) throw new IllegalArgumentException("wrong arguments");
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        if (N < 1) throw new IllegalArgumentException("wrong argument N");
        if (p < 0 || p > 1) throw new IllegalArgumentException("wrong argument p");

        plot(N, p);
    }

    /**
     * Plots N equally spaced dots of size .05 on the circumference of a circle,
     * and then, with probability p for each pair of points, draws a gray line
     * connecting them.
     * @param N Number of dots
     * @param p probability of lines
     */
    private static void plot(int N, double p) {
        Dot[] dots = new Dot[N];

        circle(CENTER_X, CENTER_Y, RADIUS);

        for (int i = 0; i < N; i++) {
            double angle = START_ANGLE + i * (2 * Math.PI / N);
            double x = CENTER_X + RADIUS * Math.cos(angle);
            double y = CENTER_Y + RADIUS * Math.sin(angle);
            dots[i] = new Dot(x, y);
            filledCircle(x, y, DOT_RADIUS);
        }

        setPenColor(GRAY);

        for (int i = 0; i < N - 1; i++)
            for (int k = i + 1; k < N; k++)
                if (StdRandom.uniform() <= p)
                    line(dots[i].x, dots[i].y, dots[k].x, dots[k].y);
    }

    private static class Dot {
        double x;
        double y;

        Dot(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
