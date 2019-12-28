package codewars;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Test;


public class DigitalRoot {

    public static int solutionProfiled(int number) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(number);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us " + x + " for " + number));
        return x;
    }

    public static int solution(int n) {
        int ret = 0;
        while (n > 0) {
            ret += n % 10;
            n = n / 10;
            if (n == 0) {
                if (ret > 9) {
                    n = ret;
                    ret = 0;
                } else {
                    return ret;
                }
            }
        }
        return ret;
    }

    @Test
    public void test() {
        assertEquals(7, solutionProfiled(16));
        assertEquals(6, solutionProfiled(456));
    }
}
