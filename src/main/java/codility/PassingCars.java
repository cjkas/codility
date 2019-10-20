package codility;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class PassingCars {

    /**
     * @param A
     * @return
     */
    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution2(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    /**
     * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
     * <p>
     * N is an integer within the range [1..100,000];
     * each element of array A is an integer that can have one of the following values: 0, 1.
     */
    public static int solution0(int[] A) {
        int sump = 0;
        for (int i = 0; i < A.length; i++) {
            int car = A[i];
            if (car == 0) {
                for (int j = i; j < A.length; j++) {
                    car = A[j];
                    if (car == 1) {
                        sump += 1;
                    }
                }
            }
            if (sump >= 1_000_000_000) {
                return -1;
            }
        }
        return sump;
    }

    public static int solution1(int[] A) {
        int sum1r = IntStream.of(A).filter(i -> i == 1).sum();
        int sump = 0;
        for (int i = 0; i < A.length; i++) {
            int car = A[i];
            if (car == 0) {
                sump += sum1r;
            } else if (car == 1) {
                sum1r -= 1;
            }
            if (sump >= 1_000_000_000) {
                return -1;
            }
        }

        return sump;
    }

    public static int solution2(int[] A) {
        int cnt0 = 0;
        int sump = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                cnt0 += 1;
            } else if (A[i] == 1) {
                sump += cnt0;
            }
            if (sump >= 1_000_000_000) {
                return -1;
            }
        }

        return sump;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, solutionprofiled(new int[]{0, 1, 0, 1, 1}));
        Assert.assertEquals(13, solutionprofiled(new int[]{1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0}));
        Assert.assertEquals(5, solutionprofiled(new int[]{0, 1, 0, 1, 1}));
        Assert.assertEquals(1, solutionprofiled(new int[]{0, 1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{1, 0}));
        Assert.assertEquals(0, solutionprofiled(new int[]{0, 0}));
        Assert.assertEquals(0, solutionprofiled(new int[]{0}));
        Assert.assertEquals(0, solutionprofiled(new int[]{}));
        Assert.assertEquals(0, solutionprofiled(new int[]{1}));
        Assert.assertEquals(13, solutionprofiled(new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1}));
        int[] x = new int[100_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = i % 2 == 0 ? 0 : 1;
        }
        Assert.assertEquals(-1, solutionprofiled(x));

        x = new int[70_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = i % 2 == 0 ? 0 : 1;
        }
        Assert.assertEquals(612517500, solutionprofiled(x));
    }

}
