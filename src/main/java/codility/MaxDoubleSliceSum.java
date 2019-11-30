package codility;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class MaxDoubleSliceSum {

    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    private static int solution(int[] A) {
        if (A.length == 3) {
            return 0;
        }
        int highest = 0;
        int[] k1 = new int[A.length];
        int[] k2 = new int[A.length];
        for (int i = 1; i < A.length - 1; i++) {
            k1[i] = Math.max(A[i] + k1[i - 1], 0);
        }
        for (int i = A.length - 2; i > 0; i--) {
            k2[i] = Math.max(A[i] + k2[i + 1], 0);
        }
        for (int i = 1; i < A.length - 1; i++) {
            int v = k1[i - 1] + k2[i + 1];
            if (v > highest) {
                highest = v;
            }
        }
        return highest;
    }

    @Test
    public void test() {
        //       x         x  x
        Assert.assertEquals(17, solutionprofiled(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));
        Assert.assertEquals(17, solutionprofiled(new int[]{-1,-1,-1,-10000,1,-10000}));

//        Assert.assertEquals(0, solutionprofiled(new int[]{0}));
//        Assert.assertEquals(1, solutionprofiled(new int[]{1}));
//        Assert.assertEquals(105, solutionprofiled(new int[]{0, 1, -100, 105}));
//        Assert.assertEquals(0, solutionprofiled(new int[]{0, 0, 0}));
//        Assert.assertEquals(1, solutionprofiled(new int[]{0, 0, 1}));
//        Assert.assertEquals(1, solutionprofiled(new int[]{1, 0, 0}));
//        Assert.assertEquals(15, solutionprofiled(new int[]{1, 2, 3, 4, 5}));
//        Assert.assertEquals(0, solutionprofiled(new int[]{-231, -2, -2, -1, 0}));
//        int[] x = new int[30_000];
//        for (int i = 0; i < x.length; i++) {
//            x[i] = i;
//        }
//        Assert.assertEquals(449985000, solutionprofiled(x));
//        for (int i = 0; i < x.length; i++) {
//            x[i] = i;
//        }
//        x[344] = -10000;
//        Assert.assertEquals(0, solutionprofiled(x));
    }
}
