package codewars;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsPrime {

    public static boolean solutionProfiled(int number) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        boolean x = solution(number);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us " + x + " for " + number));
        return x;
    }

    public static boolean solution(int num) {
        if (num < 2) {
            return false;
        }
        int i = 2;
        while (i * i <= num) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Test
    public void test() {
        assertFalse("0 is not prime", solutionProfiled(0));
        assertFalse("1 is not prime", solutionProfiled(1));
        assertTrue("2 is prime", solutionProfiled(2));
        assertTrue("73 is prime", solutionProfiled(73));
        assertFalse("75 is not prime", solutionProfiled(75));
        assertFalse("-1 is not prime", solutionProfiled(-1));

        assertTrue("5 is prime", solutionProfiled(5));
        assertTrue("3 is prime", solutionProfiled(3));
        assertTrue("7 is prime", solutionProfiled(7));
        assertTrue("41 is prime", solutionProfiled(41));
        assertTrue("5099 is prime", solutionProfiled(5099));

        assertFalse("4 is not prime", solutionProfiled(4));
        assertFalse("6 is not prime", solutionProfiled(6));
        assertFalse("8 is not prime", solutionProfiled(8));
        assertFalse("9 is not prime", solutionProfiled(9));
        assertFalse("45 is not prime", solutionProfiled(45));
        assertFalse("-5 is not prime", solutionProfiled(-5));
        assertFalse("-8 is not prime", solutionProfiled(-8));
        assertFalse("-41 is not prime", solutionProfiled(-41));
    }
}
