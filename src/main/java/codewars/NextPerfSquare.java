package codewars;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class NextPerfSquare {

    public static long solutionprofiled(long sq) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        long x = solution(sq);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static long solution(long sq) {
        double d = Math.sqrt(sq);
        if (d != (long) d) {
            return -1;
        }
        return ((long) d + 1) * ((long) d + 1);
    }

    @Test
    public void test() {
        Assert.assertEquals(-1, solutionprofiled(114));
        Assert.assertEquals(144, solutionprofiled(121));
        Assert.assertEquals(676, solutionprofiled(625));
    }
}
