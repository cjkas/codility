package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class FrogRiverOne {

    /**
     * N and X are integers within the range [1..100,000];
     * each element of array A is an integer within the range [1..X].
     * sec    pos
     * A[0] = 1
     * A[1] = 3
     * A[2] = 1
     * A[3] = 4
     * A[4] = 2
     * A[5] = 3
     * A[6] = 5
     * A[7] = 4
     * X=5 is 6
     *
     * @param A
     * @return
     */
    public static int solutionprofiled(int X, int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(X, A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us ") + " " + x + " for " + X + " in " + Arrays.toString(A));
        return x;
    }

    public static int solution(int X, int[] A) {
        int[] foundPositions = new int[X];
        int cnt = 0;
        for (int time = 0; time < A.length; time++) {
            int pos = A[time];
            if (pos <= X) {
                int posi = pos - 1;
                if (foundPositions[posi] == 0) {
                    cnt++;
                    foundPositions[posi] = 1;
                }
//                System.out.println(posTime + " " + fnd);
                if (cnt == X) {
                    return time;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, solutionprofiled(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
        Assert.assertEquals(14, solutionprofiled(12, new int[]{12, 33, 11, 4, 2, 3, 5, 4, 10, 8, 9, 7, 5, 6, 1, 9}));
        Assert.assertEquals(-1, solutionprofiled(12, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
        Assert.assertEquals(-1, solutionprofiled(12, new int[]{}));
        Assert.assertEquals(1, solutionprofiled(1, new int[]{2, 1, 1, 1}));

    }

}
