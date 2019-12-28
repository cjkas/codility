package codewars;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EqualSidesOfAnArray {

    public static int solutionProfiled(int[] arr) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(arr);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static int solution(int[] arr) {
        int sum = IntStream.of(arr).sum();
        int suml = 0;
        for (int i = 0; i < arr.length; i++) {
            suml += i > 0 ? arr[i - 1] : 0;
            int sumr = sum - suml - arr[i];
            if (suml == sumr) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(3, solutionProfiled(new int[]{1, 2, 3, 4, 3, 2, 1}));
        assertEquals(1, solutionProfiled(new int[]{1, 100, 50, -51, 1, 1}));
        assertEquals(-1, solutionProfiled(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(3, solutionProfiled(new int[]{20, 10, 30, 10, 10, 15, 35}));
        assertEquals(-1, solutionProfiled(new int[]{-8505, -5130, 1926, -9026}));
        assertEquals(1, solutionProfiled(new int[]{2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6, solutionProfiled(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
        assertEquals(0, solutionProfiled(new int[]{-30, -20, 10, 10}));
    }
}
