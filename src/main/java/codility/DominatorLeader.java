package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class DominatorLeader {

    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    // 3/2 = 1,5 ~ 1
    private static int solution(int[] A) {
        if (A.length == 0) {
            return -1;
        }
        int[] B = Arrays.copyOf(A, A.length);
        Arrays.sort(A);
        int centerIndex = (A.length - 1) / 2;
        int halfLen = A.length / 2;
        int candidate = A[centerIndex];
        int cnt = 0;
        System.out.println("candidate is " + candidate + " from index " + centerIndex);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                if (++cnt > halfLen) {
                    for (int j = 0; j < B.length; j++) {
                        if (B[j] == candidate) {
                            return j;
                        }
                    }
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(0, solutionprofiled(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
        Assert.assertEquals(-1, solutionprofiled(new int[]{}));
        Assert.assertEquals(0, solutionprofiled(new int[]{1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{1, 1}));
        Assert.assertEquals(-1, solutionprofiled(new int[]{1, 0}));
        Assert.assertEquals(1, solutionprofiled(new int[]{0, 1, 1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{1, 1, 1, 0, 0}));
        Assert.assertEquals(0, solutionprofiled(new int[]{1, 1, 0, 0, 1}));
        Assert.assertEquals(-1, solutionprofiled(new int[]{-1, 1, 1, 0, 0}));
        Assert.assertEquals(-1, solutionprofiled(new int[]{-1, 1, 1, 2, 2}));
        Assert.assertEquals(-1, solutionprofiled(new int[]{1, 1, 1, 0, 0, 0}));
        Assert.assertEquals(1, solutionprofiled(new int[]{1, 0, 1, 0, 0, 0}));
        int[] x = new int[100_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = i >= 50_000 - 1 ? Integer.MAX_VALUE : i;
        }
        Assert.assertEquals(1, solutionprofiled(x));
    }
}
