package codewars;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class Tribonacci {

    public static double[] solutionProfiled(double[] s, int n) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        double[] x = solution(s, n);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static double[] solution(double[] s, int n) {
    }

    private
    double precision = 1e-10;

    @Test
    public void test() {
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, solutionProfiled(new double[]{1, 1, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, solutionProfiled(new double[]{0, 0, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, solutionProfiled(new double[]{0, 1, 1}, 10), precision);

    }
}
