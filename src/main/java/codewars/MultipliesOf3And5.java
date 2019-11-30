package codewars;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class MultipliesOf3And5 {

    public static long solutionprofiled(int number) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(number);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static int solution(int number) {
        int sum = 0;
        for (int i = 3; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
//                System.out.println(" is " + i);
                sum += i;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        Assert.assertEquals(23, solutionprofiled(10));
        Assert.assertEquals(0, solutionprofiled(3));
        Assert.assertEquals(3, solutionprofiled(4));
        Assert.assertEquals(3, solutionprofiled(5));
        Assert.assertEquals(8, solutionprofiled(6));
        Assert.assertEquals(23, solutionprofiled(Integer.MAX_VALUE));
    }
}
