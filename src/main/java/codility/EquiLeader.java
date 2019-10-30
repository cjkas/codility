package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class EquiLeader {

    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    private static int solution(int[] A) {
        if (A.length == 1) {
            return 0;
        }
        int equiLeaders = 0;
        for (int i = 1; i < A.length; i++) {
            int[] l1 = Arrays.copyOfRange(A, 0, i);
            int l = fndLeader(l1);
            int[] l2 = Arrays.copyOfRange(A, i, A.length);
            int r = fndLeader(l2);
//            System.out.println(Arrays.toString(l1) + " and " + Arrays.toString(l2));
            if (l != Integer.MIN_VALUE && r != Integer.MAX_VALUE && l == r) {
                equiLeaders++;
            }
        }
        return equiLeaders;
    }

    private static int fndLeader(int[] A) {
        if (A.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (A.length == 1) {
            return A[0];
        }
        Arrays.sort(A);
        int centerIndex = (A.length - 1) / 2;
        int halfLen = A.length / 2;
        int candidate = A[centerIndex];
        int cnt = 0;
//        System.out.println("candidate is " + candidate + " from index " + centerIndex);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                if (++cnt > halfLen) {
                    return candidate;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, solutionprofiled(new int[]{4, 3, 4, 4, 4, 2}));
        Assert.assertEquals(0, solutionprofiled(new int[]{4}));
        Assert.assertEquals(1, solutionprofiled(new int[]{1, 1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{1, 2}));
        Assert.assertEquals(2, solutionprofiled(new int[]{1, 1, 1}));
        Assert.assertEquals(3, solutionprofiled(new int[]{1, 1, 1, 1}));
        int[] x = new int[100_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = i;
        }
        Assert.assertEquals(0, solutionprofiled(x));
    }
}
