package codewars;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PangramChecker {

    public static boolean solutionprofiled(String sq) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        boolean x = solution(sq);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    static char[] alf = "abcdefghijklmnoprstuvwxyz".toCharArray();

    public static boolean solution(String sentence) {
        String text = sentence.toLowerCase();
        if (text.length() < alf.length) {
            return false;
        }
        for (char c : alf) {
            if (text.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(true, solutionprofiled("The quick brown fox jumps over the lazy dog."));
        assertEquals(false, solutionprofiled("You shall not pass!"));
    }
}
