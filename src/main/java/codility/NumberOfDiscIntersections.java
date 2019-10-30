package codility;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfDiscIntersections {

    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution2(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    /**
     * @param A
     * @return
     */
    public static int solution(int[] A) {
        int ints = 0;
        for (int i = 0; i < A.length; i++) {
            long rad = A[i];
            long start = i - rad;
            long end = i + rad;
            for (int j = i + 1; j < A.length; j++) {
                long rad1 = A[j];
                long start1 = j - rad1;
                long end1 = j + rad1;
                boolean startInside = (start1 >= start && start1 <= end);
                boolean endInside = (end1 >= start && end1 <= end);
                boolean covers = (start1 < start && end1 > end);
                if (startInside
                        || endInside
                        || covers
                ) {
                    ints++;
//                    System.out.println(i + " with " + j + " at " + startInside + "," + endInside + "," + covers);
                }
            }
        }
        return ints;
    }

    /**
     * @param A
     * @return 1 2 3 4 5 6 7 8 9
     * 2 3 4 5 6 7 8
     * 4 5 6
     * 1 2 3
     * 7 8 9
     */
    public static int solution2(int[] A) {
        int ints = 0;
        int[] r = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            r[i] = A[i] + i;
        }

        return ints;
    }

    @Test
    public void test() {
        //1 6 4  4 8  5     8 6 5 4 4 1   5 3 3
        Assert.assertEquals(11, solutionprofiled(new int[]{1, 5, 2, 1, 4, 0}));
        Assert.assertEquals(0, solutionprofiled(new int[]{}));
        Assert.assertEquals(0, solutionprofiled(new int[]{1}));
        Assert.assertEquals(3, solutionprofiled(new int[]{1, 0, 1}));
        Assert.assertEquals(2, solutionprofiled(new int[]{0, 1, 0}));
        Assert.assertEquals(0, solutionprofiled(new int[]{0, 0, 0}));
        Assert.assertEquals(3, solutionprofiled(new int[]{0, 0, 0, Integer.MAX_VALUE}));
        int[] x = new int[100_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = i + 1000;
        }
        Assert.assertEquals(704982704, solutionprofiled(x));
    }
}
