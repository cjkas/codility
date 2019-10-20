package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class OddOccurrencesInArray {
    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.NANOSECONDS);
        System.out.println("elapsed " + elapsed + "ns fnd " + x + " for " + Arrays.toString(A));
        return x;
    }

    public static int solution(int[] A) {
        if (A.length == 1) {
            System.out.println("ret " + A[0]);
            return A[0];
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length; i += 2) {
            if (i + 1 >= A.length) {
                return A[i];
            }
            if (A[i] != A[i + 1]) {
                return A[i];
            }
        }
        return -1;
    }

    public static int solution1(int[] A) {
        if (A.length == 1) {
            System.out.println("ret " + A[0]);
            return A[0];
        }
        Set<Integer> counted = new HashSet<>();
        for (int N = 0; N < A.length; N++) {
            int AV = A[N];
            if (AV < 1_000_000) {
                boolean fnd = counted.contains(AV);
                if (fnd) {
                    counted.remove(AV);
                } else {
                    counted.add(AV);
                }
            }
        }
        System.out.println("counted " + counted);
        for (Integer integer : counted) {
            return integer;
        }
//        for (Map.Entry<Integer, Integer> integerIntegerEntry : counted.entrySet()) {
//            return integerIntegerEntry.getKey();
//        }
        throw new RuntimeException("xc" + Arrays.toString(A));
    }
}
