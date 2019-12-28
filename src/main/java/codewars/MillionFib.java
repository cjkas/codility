package codewars;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MillionFib {

    public static BigInteger solutionProfiled(BigInteger n) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        BigInteger x = fib(n);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static BigInteger fib(BigInteger n) {
        boolean minus = false;
        if (n.compareTo(BigInteger.ZERO) < 0) {
            n = n.negate();
            minus = true;
        }
        if (n.compareTo(BigInteger.ONE) <= 0) {
            return n;
        }
        BigInteger f1 = BigInteger.ZERO;
        BigInteger f2 = BigInteger.ONE;
        for (int i = 2; i <= n.intValueExact(); i++) {
            BigInteger f3 = minus ? f1.subtract(f2) : f1.add(f2);
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }

    @Test
    public void testFib0() {
        testFib(0, 0);
        testFib(1, 1);
        testFib(1, 2);
        testFib(2, 3);
        testFib(3, 4);
        testFib(5, 5);
        testFib(13, -7);
        testFib(-8, -6);
        testFib(-317811, -28);
        testFib(196418, -27);
        testFib(4181, 19);
        testFib(4181, 1_328_584);
    }

    private static void testFib(long expected, long input) {
        BigInteger found;
        try {
            found = solutionProfiled(BigInteger.valueOf(input));
        } catch (Throwable e) {
            // see https://github.com/Codewars/codewars.com/issues/21
            throw new AssertionError("exception during test: " + e, e);
        }
        assertEquals(BigInteger.valueOf(expected), found);
    }
}
