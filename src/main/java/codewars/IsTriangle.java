package codewars;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IsTriangle {

    public static boolean solutionprofiled(int a, int b, int c) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        boolean x = solution(a, b, c);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static boolean solution(int a, int b, int c) {
        int[] x = new int[3];
        x[0] = a;
        x[1] = b;
        x[2] = c;
        Arrays.sort(x);
        return x[0] + x[1] > x[2];
    }

    @Test
    public void test() {
        assertEquals(true, solutionprofiled(1, 2, 2));
        assertEquals(false, solutionprofiled(7, 2, 2));
    }
}
