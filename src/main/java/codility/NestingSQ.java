package codility;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class NestingSQ {

    public static int solutionprofiled(String S) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(S);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    /**
     * @return
     */
    public static int solution(String S) {
        if (S.length() == 0) {
            return 1;
        }
        if (S.length() % 2 != 0) {
            return 0;
        }
        if (S.startsWith(")")) {
            return 0;
        }
        if (S.endsWith("(")) {
            return 0;
        }
        int started = 0;
        int half = S.length() / 2;
//        System.out.println("h" + half);
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                started++;
                if (started > half) {
//                    System.out.println("half " + started);
                    return 0;
                }
            } else {
                started--;
                if (started < 0) {
                    return 0;
                }
            }
        }
//        System.out.println("stated " + started);
        return started == 0 ? 1 : 0;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, solutionprofiled("(()(())())"));
        Assert.assertEquals(0, solutionprofiled("())"));
        Assert.assertEquals(0, solutionprofiled(")))((("));
        Assert.assertEquals(0, solutionprofiled("(())))"));
        Assert.assertEquals(1, solutionprofiled(""));
        Assert.assertEquals(0, solutionprofiled(")"));
        Assert.assertEquals(0, solutionprofiled("("));
        Assert.assertEquals(0, solutionprofiled(")))"));
        Assert.assertEquals(0, solutionprofiled("((("));
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            x.append(i < 500_000 ? '(' : ')');
        }
        Assert.assertEquals(1, solutionprofiled(x.toString()));
        x = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            x.append(i <= 500_000 ? '(' : ')');
        }
        Assert.assertEquals(0, solutionprofiled(x.toString()));
    }
}
