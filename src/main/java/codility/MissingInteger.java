package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class MissingInteger {

    /**
     * @param A
     * @return
     */
    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    /**
     * N is an integer within the range [1..100,000];
     * each element of array A is an integer within the range [−1,000,000..1,000,000].
     *
     * @param A
     * @return
     */
    public static int solution(int[] A) {
        Arrays.sort(A);
        int prev = 0;
        for (int i = 0; i < A.length; i++) {
            int ele = A[i];
            if (ele <= 0) {
                continue;
            }
            if (ele == prev) {
                continue;
            }
            if (ele == prev + 1) {
                prev = ele;
            } else {
                return prev + 1;
            }
        }
        return prev == 0 ? 1 : prev + 1;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, solutionprofiled(new int[]{1, 3, 6, 4, 1, 2}));
        Assert.assertEquals(4, solutionprofiled(new int[]{1, 2, 3}));
        Assert.assertEquals(4, solutionprofiled(new int[]{1, 2, 3, 15}));
        Assert.assertEquals(1, solutionprofiled(new int[]{-1, -3}));
        Assert.assertEquals(1, solutionprofiled(new int[]{-100}));
        int[] x = new int[1_000_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = -1;
        }
        Assert.assertEquals(1, solutionprofiled(x));
    }

}
