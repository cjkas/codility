package codility;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class Triangle {

    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    /**
     * A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N
     * A[P] + A[Q] > A[R],
     * A[Q] + A[R] > A[P],
     * A[R] + A[P] > A[Q].
     *
     * @param A
     * @return
     */
    public static int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        int p, q, r;
        for (int i = 0; i < A.length - 2; i++) {
            p = A[i];
            for (int j = i + 1; j < A.length - 1; j++) {
                q = A[j];
                for (int k = j + 1; k < A.length; k++) {
                    r = A[k];
                    if (p + q > r && q + r > p && r + p > q) {
                        //q > p/r
                        //r > q/p
//                        System.out.println("fnd for " + p + " " + q + " " + r);
                        return 1;
                    }

                }
            }
        }
        return 0;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, solutionprofiled(new int[]{10, 2, 5, 1, 8, 20}));
        Assert.assertEquals(0, solutionprofiled(new int[]{10, 50, 5, 1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{10, 50}));
        Assert.assertEquals(1, solutionprofiled(new int[]{10, 5, 8}));
        Assert.assertEquals(0, solutionprofiled(new int[]{}));
        Assert.assertEquals(0, solutionprofiled(new int[]{-1, -2, -5, -8, -20}));
        int[] x = new int[2_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = -i;
        }
        Assert.assertEquals(0, solutionprofiled(x));
        Random r = new Random();
        for (int j = 0; j < 50; j++) {
            for (int i = 0; i < x.length; i++) {
                x[i] = r.nextInt(100);
            }
            solutionprofiled(x);
        }

    }

}
