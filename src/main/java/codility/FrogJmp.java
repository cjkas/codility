package codility;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class FrogJmp {

    /**
     * 1..1000000
     * X<=Y
     *
     * @param X 10
     * @param Y 85
     * @param D 30
     * @return 3
     */
    public static int solutionprofiled(int X, int Y, int D) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(X, Y, D);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.NANOSECONDS);
        System.out.println("elapsed " + elapsed + " X " + X + ", Y " + Y + ",D " + D + " is " + x);
        return x;
    }

    public static int solution(int X, int Y, int D) {
        if (X == Y) {
            return 0;
        }
        double dist = Y - X;
        if (dist == 0) {
            return 0;
        }
        double step = D;
        if (step == 1) {
            return (int) dist;
        }
        if (dist <= step) {
            return 1;
        }
        double ceil = Math.ceil(dist / step);
        System.out.println("c "+dist/step);
        return (int) ceil;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, solutionprofiled(10, 85, 30));
        Assert.assertEquals(3, solutionprofiled(10, 81, 30));
        Assert.assertEquals(5, solutionprofiled(10, 60, 10));
        Assert.assertEquals(0, solutionprofiled(10, 10, 5));
        Assert.assertEquals(1, solutionprofiled(10, 11, 1));
        Assert.assertEquals(1, solutionprofiled(10, 14, 5));
        Assert.assertEquals(1, solutionprofiled(10, 15, 5));
        Assert.assertEquals(1, solutionprofiled(10, 15, 5));
        Assert.assertEquals(1_000_000_000 - 1, solutionprofiled(1, 1_000_000_000, 1));
        Assert.assertEquals( 1, solutionprofiled(1_000_000_000-2, 1_000_000_000, 1_000_000_000));


    }

}
