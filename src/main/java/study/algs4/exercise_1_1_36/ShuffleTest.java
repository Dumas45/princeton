package study.algs4.exercise_1_1_36;

import edu.princeton.cs.introcs.StdRandom;

/**
 * Exercise 1.1.36 Empirical shuffle check
 * @author Alexei
 */
public class ShuffleTest {
    public static void main(String[] args) {
        int M, N;
        try {
            M = Integer.parseInt(args[0]);
            N = Integer.parseInt(args[1]);
        } catch (RuntimeException e) {
            throw new RuntimeException("Wrong arguments! Should be M and N, where M is shuffled array length, and N is number of tries", e);
        }

        test(M, N);
    }

    private static void test(final int M, final int N) {
        int[][] m = new int[M][M];

        for (int attempt = 0; attempt < N; attempt++) {
            int[] a = new int[M];
            for (int i = 0; i < M; i++) a[i] = i;
            shuffle(a);
            for (int i = 0; i < M; i++) {
                m[a[i]][i] += 1;
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (j > 0) System.out.print(' ');
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    private static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            int r = i + StdRandom.uniform(N - i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
