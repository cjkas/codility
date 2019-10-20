package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class PermCheck {

    /**
     * N is an integer within the range [0..100,000];
     * the elements of A are all distinct;
     * each element of array A is an integer within the range [1..(N + 1)].
     *
     * @param A
     * @return
     */
    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.NANOSECONDS);
        System.out.println("elapsed " + elapsed + " " + x + " in " + Arrays.toString(A));
        return x;
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        if (A.length == 0) {
            return 0;
        }
        if (A[0] != 1) {
            return 0;
        }
        int prev = A[0];
        for (int i = 1; i < A.length; i++) {
            if (prev + 1 != A[i]) {
                return 0;
            }
            prev = A[i];
        }
        return 1;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, solutionprofiled(new int[]{2, 3, 1, 5, 4}));
        Assert.assertEquals(0, solutionprofiled(new int[]{2}));
        Assert.assertEquals(0, solutionprofiled(new int[]{3, 2}));
        Assert.assertEquals(0, solutionprofiled(new int[]{0}));
        Assert.assertEquals(0, solutionprofiled(new int[]{}));
        Assert.assertEquals(0, solutionprofiled(new int[]{3, 3, 2, 1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{122224, 3, 2, 1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{3, 2, 1, 1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{3, 2, 2, 1}));
        Assert.assertEquals(1, solutionprofiled(new int[]{3, 2, 1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{4, 1, 3}));
    }

}
