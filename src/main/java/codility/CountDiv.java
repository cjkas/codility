package codility;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class CountDiv {

    public static int solutionprofiled(int A, int B, int K) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A, B, K);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }


    public static int solution(int A, int B, int K) {
        double x = ((B - A) / (double) K) + (A % K == 0 ? 1 : A / (double)K);
        System.out.println(x);
        return (int) x;
//        return x;
//        int dividers = 0;
//        for (int i = A; i <= B; i++) {
//            if ( i % K == 0) {
//                dividers++;
////                System.out.println(i);
//            }
//        }
//        return dividers;
    }


    @Test
    public void test() {
        Assert.assertEquals(3, solutionprofiled(6, 11, 2));
        Assert.assertEquals(4, solutionprofiled(6, 12, 2));
        Assert.assertEquals(166, solutionprofiled(5, 5001, 30));
        Assert.assertEquals(1, solutionprofiled(7, 7, 7));
        Assert.assertEquals(1, solutionprofiled(6, 6, 3));
        Assert.assertEquals(0, solutionprofiled(5, 5, 7));
        Assert.assertEquals(2_000_000_001, solutionprofiled(0, 2_000_000_000, 1));
        Assert.assertEquals(1, solutionprofiled(0, 2_000_000_000 - 1, 2_000_000_000));
        Assert.assertEquals(2, solutionprofiled(0, 2_000_000_000, 2_000_000_000));
        Assert.assertEquals(2, solutionprofiled(0, 2_000_000_000, 2_000_000_000 - 1));
        Assert.assertEquals(1000000000, solutionprofiled(2, 2_000_000_000, 2));
        Assert.assertEquals(1, solutionprofiled(0, 1, 11));
        Assert.assertEquals(20, solutionprofiled(11, 345, 17));
    }

}
