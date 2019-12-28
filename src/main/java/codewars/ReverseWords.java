package codewars;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWords {

    public static String solutionprofiled(String sq) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String x = solution(sq);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static String solution(String text) {
        if (text.length() < 1) {
            return text;
        }
        char[] chars = text.toCharArray();

        StringBuilder revString = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            boolean space = c == ' ';
            if (space) {
                revString.append(word.reverse());
                revString.append(' ');
                word = new StringBuilder();
            } else {
                word.append(c);
            }
        }
        return revString.append(word.reverse()).toString();
    }

    @Test
    public void test() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", solutionprofiled("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", solutionprofiled("apple"));
        assertEquals("a b c d", solutionprofiled("a b c d"));
        assertEquals("elbuod  decaps  sdrow", solutionprofiled("double  spaced  words"));
    }
}
