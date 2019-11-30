package codility;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class CountFactors {

    public static int solutionprofiled(int A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    private static int solution(int N) {

        int factors = 0;
        int i = 1;
        while (i * i < N) {
            if (N % i == 0) {
                factors += 2;
            }
            i++;
        }
        if (i * i == N) {
            factors++;
        }

        return factors;
    }

    @Test
    public void test() {
        Assert.assertEquals(8, solutionprofiled(24));
        Assert.assertEquals(1, solutionprofiled(1));
        Assert.assertEquals(2, solutionprofiled(2));
        Assert.assertEquals(9, solutionprofiled(100));
        Assert.assertEquals(20, solutionprofiled(2_000));
        Assert.assertEquals(2, solutionprofiled(113));
        Assert.assertEquals(4, solutionprofiled(15));
        Assert.assertEquals(64, solutionprofiled(10_000_000));
    }
}
