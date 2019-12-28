package codewars;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareDigits {

    public static int solutionprofiled(Integer sq) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Integer x = solution(sq);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static int solution(int sentence) {
        String[] x = (sentence + "").split("");
        StringBuilder b = new StringBuilder();
        for (String c : x) {
            b.append(Integer.parseInt(c) * Integer.parseInt(c));
        }
        return Integer.parseInt(b.toString());
    }

    @Test
    public void test() {
        assertEquals(811181, solutionprofiled(9119));
    }
}
