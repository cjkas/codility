package codility;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class MinPerimeterRectangle {

    public static int solutionprofiled(int A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    private static int solution(int N) {
        int div1 = 0;
        int i = 1;
        while (i * i <= N) {
            if (N % i == 0) {
//                System.out.print(i + ",");
                div1 = i;
            }
            i++;
        }
        int div2 = N / div1;
        System.out.println(div1 + " + " + div2 + " = " + (div1 * div2));
        return 2 * (div1 + div2);
    }

    @Test
    public void test() {
        Assert.assertEquals(22, solutionprofiled(30));
        Assert.assertEquals(4, solutionprofiled(1));
        Assert.assertEquals(28, solutionprofiled(33));
        Assert.assertEquals(126500, solutionprofiled(1_000_000_000));
    }
}
