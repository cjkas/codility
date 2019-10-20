package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class MinAvgTwoSlice {

    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }


    public static int solution(int[] A) {
        int[] pref = new int[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            pref[i] = sum;
        }
//        System.out.println("prefs" + Arrays.toString(pref));
        int lowestIndex = 0;
        float lowestAvg = Float.MAX_VALUE;
        float lowestRng = 0;
        for (int sliceRange = 1; sliceRange < A.length; sliceRange++) {
            for (int startIndex = 0; startIndex < A.length - sliceRange; startIndex++) {
                int dif = startIndex > 0 ? pref[startIndex - 1] : 0;
                float divide = (float) (sliceRange + 1);
                float avg = (pref[startIndex + sliceRange] - dif) / divide;
//                System.out.println("ls " + startIndex + " " + (startIndex + sliceRange) + "=" + avg + " _ " + (pref[startIndex + sliceRange] - dif) + " / " + (divide));
                if (avg < lowestAvg) {
                    lowestAvg = avg;
                    lowestIndex = startIndex;
                    lowestRng = sliceRange;
                }
            }

        }
//        System.out.println("lowestIndex " + lowestIndex + " lavg " + lowestAvg + " sl " + lowestRng);
        return lowestIndex;
    }


    @Test
    public void test() {
        Assert.assertEquals(1, solutionprofiled(new int[]{4, 2, 2, 5, 1, 5, 8}));
        Assert.assertEquals(7, solutionprofiled(new int[]{4, 2, 2, 5, 1, 5, 5, 1, 1}));
        Assert.assertEquals(9, solutionprofiled(new int[]{4, 2, 2, 5, 1, 5, 5, 1, 1, 1, -2, 10000}));
        Assert.assertEquals(0, solutionprofiled(new int[]{1, 1}));
        Assert.assertEquals(0, solutionprofiled(new int[]{-1, -2}));
        Assert.assertEquals(6, solutionprofiled(new int[]{-1, -2, -5, -2, -100, -100, -1000, -10000, 100000}));
        Assert.assertEquals(10, solutionprofiled(new int[]{-1, -2, -5, -2, -100, -100, -1000, -10000, 100000, -1000, -1000, -20000}));
        int[] x = new int[100_000];
        Arrays.fill(x, -10_000);
        x[2] = 100_000;
        x[1000] = 100_000;
//        Assert.assertEquals(1001, solutionprofiled(x));
    }

}
