package codility;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class Distinct {

    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solutionv2(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static int solution(int[] A) {
        return (int) IntStream.of(A)
                .distinct()
                .count();
    }

    public static int solutionv2(int[] A) {
        Arrays.sort(A);
        int res = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int next = A[i];
            if (next != prev) {
                res++;
                prev = next;
            }
        }
        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, solutionprofiled(new int[]{2, 1, 1, 2, 3, 1}));
        Assert.assertEquals(4, solutionprofiled(new int[]{2, 1, 1, 2, 3, -100}));
        Assert.assertEquals(1, solutionprofiled(new int[]{1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{}));
        Assert.assertEquals(2, solutionprofiled(new int[]{1, 2}));
        Assert.assertEquals(2, solutionprofiled(new int[]{-1_000_000, 1_000_000}));
        int[] y = new int[100_000];
        Arrays.fill(y, 1_000_000);
        Assert.assertEquals(1, solutionprofiled(y));

        int[] x = new int[100_000];
        Random r = new Random();

        for (int i = 0; i < x.length; i++) {
            x[i] = r.nextInt(1_000_000);
        }
        Assert.assertEquals(6, solutionprofiled(x));
    }

}
