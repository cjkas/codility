package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class PermMissingElem {

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

    private static int solution(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 1;
        }
        if (len == 1) {
            if (A[0] > 1) {
                return A[0] - 1;
            } else {
                return A[0] + 1;
            }
        }
        Arrays.sort(A);
        int prev = A[0];
        if (prev != 1) {
            return 1;
        }
//        System.out.println("s" + Arrays.toString(A));
        for (int i = 1; i < len; i++) {
            int v = A[i];
            if (prev + 1 != v) {
                return prev + 1;
            }
            prev = v;
        }
        return prev + 1;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, solutionprofiled(new int[]{2, 3, 1, 5}));
        Assert.assertEquals(1, solutionprofiled(new int[]{2}));
        Assert.assertEquals(1, solutionprofiled(new int[]{3, 2}));
        Assert.assertEquals(1, solutionprofiled(new int[]{0}));
        Assert.assertEquals(3, solutionprofiled(new int[]{4, 2, 1}));
        Assert.assertEquals(4, solutionprofiled(new int[]{3, 2, 1}));
    }

}
