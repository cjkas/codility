package codility;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class MaxProductOfThree {

    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static int solution(int[] A) {
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;
        int l1 = Integer.MAX_VALUE, l2 = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int v = A[i];
            if (v > a) {
                c = b;
                b = a;
                a = v;
            } else if (v > b) {
                c = b;
                b = v;
            } else if (v > c) {
                c = v;
            } else if (a == 1000 && b == 1000 && c == 1000) {
                break;
            }
            if (v < 0 && (l1 > -1000 || l2 > -1000)) {
                if (v < l1) {
                    l2 = l1;
                    l1 = v;
                } else if (v < l2) {
                    l2 = v;
                }
            }
        }
        int sum = a * b * c;
        int nsum = (l1 < 0 && l2 < 0) ? l1 * l2 * a : Integer.MIN_VALUE;
        if (nsum > sum) {
            System.out.println("sum " + sum + " n " + nsum);
            return nsum;
        }
        return sum;
    }


    @Test
    public void test() {
        Assert.assertEquals(60, solutionprofiled(new int[]{-3, 1, 2, -2, 5, 6}));
        Assert.assertEquals(6, solutionprofiled(new int[]{1, 2, 3}));
        Assert.assertEquals(-1, solutionprofiled(new int[]{-1, -1, -1, -2, -5, -1000}));
        Assert.assertEquals(-2, solutionprofiled(new int[]{-1, -1, -2, -2, -5, -1000}));
        Assert.assertEquals(1000000000, solutionprofiled(new int[]{-1, -1, -2, -2, -5, -1000, 1000, 1000, 1000}));
        Assert.assertEquals(125, solutionprofiled(new int[]{-5, 5, -5, -4}));

//        int[] x = new int[100_000];
//        Random r = new Random();
//
//        for (int i = 0; i < x.length; i++) {
//            x[i] = r.nextInt(1000);
//        }
//        Assert.assertEquals(6, solutionprofiled(x));
    }

}
