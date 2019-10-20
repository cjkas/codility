package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class TapeEquilibrium {

    /**
     * N is an integer within the range [2..100,000];
     * each element of array A is an integer within the range [−1,000..1,000].
     *
     * @param A
     * @return
     */
    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us ") + " " + x + " in " + Arrays.toString(A));
        return x;
    }

    // (A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
//    P = 1, difference = |3 − 10| = 7
//    P = 2, difference = |4 − 9| = 5
//    P = 3, difference = |6 − 7| = 1
//    P = 4, difference = |10 − 3| = 7
//    3  1 2 4 3
    public static int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        int len = A.length;
        int lsum = A[0];
        int rsum = IntStream.of(A).sum()-A[0];
        int minVal = Integer.MAX_VALUE;
        for (int p = 1; p < len-1; p++) { //7
            lsum += A[p];
            rsum -= A[p];
            int x = Math.abs(lsum - rsum);
            System.out.println(" for p=" + (p) + " " + lsum + " - " + rsum + "=" + x);
            if (x < minVal) {
                minVal = x;
                if (minVal == 1) {
                    return 1;
                }
            }
        }
//        System.out.println("abs " + minVal);
        return minVal;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, solutionprofiled(new int[]{3, 1, 2, 4, 3}));
        Assert.assertEquals(2, solutionprofiled(new int[]{2}));
        Assert.assertEquals(1, solutionprofiled(new int[]{3, 2}));
        Assert.assertEquals(0, solutionprofiled(new int[]{0}));
        Assert.assertEquals(0, solutionprofiled(new int[]{}));
        Assert.assertEquals(3, solutionprofiled(new int[]{3, 3, 2, 1}));
        Assert.assertEquals(122218, solutionprofiled(new int[]{122224, 3, 2, 1}));
        Assert.assertEquals(996, solutionprofiled(new int[]{-1000, 2, 1, 1}));
        Assert.assertEquals(2000, solutionprofiled(new int[]{-1000, 1000}));
        int[] x = new int[99_990];
        for (int i = 0; i < 99_990; i++) {
            x[i] = i + 1;
        }
//        Assert.assertEquals(3030, solutionprofiled(x));


    }

}
