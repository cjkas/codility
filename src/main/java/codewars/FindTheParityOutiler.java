package codewars;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FindTheParityOutiler {

    public static int solutionProfiled(int[] integers) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(integers);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static int solution(int[] integers) {
        int lastEven = 0;
        int lastOdd = 0;
        int evenCnt = 0;
        int oddCnt = 0;
        for (int integer : integers) {
            if (integer % 2 == 0) {
                lastEven = integer;
                evenCnt++;
            } else {
                lastOdd = integer;
                oddCnt++;
            }
            if (evenCnt > 1 && oddCnt > 0) {
                return lastOdd;
            }
            if (oddCnt > 1 && evenCnt > 0) {
                return lastEven;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] exampleTest1 = {2, 6, 8, -10, 3};
        int[] exampleTest2 = {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        assertEquals(3, solutionProfiled(exampleTest1));
        assertEquals(206847684, solutionProfiled(exampleTest2));
        assertEquals(0, solutionProfiled(exampleTest3));
    }
}
