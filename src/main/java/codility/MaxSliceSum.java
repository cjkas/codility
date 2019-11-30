package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class MaxSliceSum {

    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    private static int solution(int[] A) {
        int maxSum = A[0];
        int[] psum = new int[A.length];
        int prev = 0;
        boolean neg = false;
        boolean pos = false;
        for (int i = 0; i < A.length; i++) {
            int sum = prev + A[i];
            psum[i] = sum;
            prev = sum;
            if (A[i] < 0) {
                neg = true;
            } else if (A[i] > 0) {
                pos = true;
            }
        }
        if (!neg) {
            return IntStream.of(A).sum();
        }
        if (!pos) {
            Arrays.sort(A);
            return A[A.length - 1];
        }
        for (int i = 0; i < A.length ; i++) {
            int x = (i == 0 ? 0 : psum[i - 1]);
            for (int j = i; j < A.length; j++) {
                int r = psum[j] - x;
//                System.out.println(i + "," + j + " = " + r);
                if (r > maxSum) {
                    maxSum = r;
                }
            }
        }
        return maxSum;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, solutionprofiled(new int[]{3, 2, -6, 4, 0}));
        Assert.assertEquals(0, solutionprofiled(new int[]{0}));
        Assert.assertEquals(1, solutionprofiled(new int[]{1}));
        Assert.assertEquals(105, solutionprofiled(new int[]{0, 1, -100, 105}));
        Assert.assertEquals(0, solutionprofiled(new int[]{0, 0, 0}));
        Assert.assertEquals(1, solutionprofiled(new int[]{0, 0, 1}));
        Assert.assertEquals(1, solutionprofiled(new int[]{1, 0, 0}));
        Assert.assertEquals(15, solutionprofiled(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(0, solutionprofiled(new int[]{-231, -2, -2, -1, 0}));
        int[] x = new int[30_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = i;
        }
        Assert.assertEquals(449985000, solutionprofiled(x));
        for (int i = 0; i < x.length; i++) {
            x[i] = i;
        }
        x[344] = -10000;
        Assert.assertEquals(0, solutionprofiled(x));
    }
}
