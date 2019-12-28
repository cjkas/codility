package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class OnesAndZeros {

    public static int solutionprofiled(List<Integer> binary) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(binary);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static int solution(List<Integer> binary) {
        String collect = binary.stream().map(String::valueOf).collect(Collectors.joining(""));
        int x = Integer.parseInt(collect, 2);
        return x;
    }

    @Test
    public void test() {
        assertEquals(1, solutionprofiled(new ArrayList<>(Arrays.asList(0,0,0,1))));
        assertEquals(15, solutionprofiled(new ArrayList<>(Arrays.asList(1,1,1,1))));
        assertEquals(6, solutionprofiled(new ArrayList<>(Arrays.asList(0,1,1,0))));
        assertEquals(9, solutionprofiled(new ArrayList<>(Arrays.asList(1,0,0,1))));
    }
}
