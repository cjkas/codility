package codility;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class MaxProfit {

    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    private static int solution(int[] A) {
        int sell = 0;
        int buy = 0;
        int sellCandidate;
        int buyCandidate = 300_000;
        int profit = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int b = A[i];
            if (b < buyCandidate) {
                buyCandidate = b;
                sellCandidate = b;
                for (int j = i + 1; j < A.length; j++) {
                    int s = A[j];
//                System.out.println(buyCandidate + "," + sellCandidate + " profit ");
                    if (s > sellCandidate) {
                        sellCandidate = s;
                    }
                }
                if (profit < (sellCandidate - buyCandidate)) {
                    sell = sellCandidate;
                    buy = buyCandidate;
                    profit = sell - buy;
                }
            }

        }
        int p = sell - buy;
        return Math.max(p, 0);
    }

    private static int solution2(int[] A) {
        int highest = 0;
        int lowest = 0;
        for (int i = 0; i < A.length - 1; i++) {

        }
        return highest;
    }

    @Test
    public void test() {
        Assert.assertEquals(356, solutionprofiled(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
        Assert.assertEquals(0, solutionprofiled(new int[]{}));
        Assert.assertEquals(0, solutionprofiled(new int[]{0, 0, 0}));
        Assert.assertEquals(1, solutionprofiled(new int[]{0, 0, 1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{1, 0, 0}));
        Assert.assertEquals(4, solutionprofiled(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(3, solutionprofiled(new int[]{2, 3, 4, 5, 1}));
        Assert.assertEquals(4, solutionprofiled(new int[]{2, 3, 4, 5, 1, 5}));
        int[] x = new int[50_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = i;
        }
        Assert.assertEquals(49999, solutionprofiled(x));
        for (int i = 0; i < x.length; i++) {
            x[i] = 50_000 - i;
        }
        Assert.assertEquals(0, solutionprofiled(x));
    }
}
