package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class CyclicRotation {
        public static int[] solutionprofiled(int[] A, int K) {
            Stopwatch stopwatch = Stopwatch.createStarted();
            int[] x = solution(A, K);
            long elapsed = stopwatch.stop().elapsed(TimeUnit.NANOSECONDS);
            System.out.println("elapsed " + elapsed + "ns fnd " + Arrays.toString(A) + " to " + Arrays.toString(x) + " stp " + K);
            return x;
        }

    /**
     * can be empty
     * @param A min and max
     * @param K min and max
     * @return
     */
    public static int[] solution(int[] A, int K) {
        int len = A.length;
        if (len != 0 && K > len) {
            int r = K / len;
            K -= r * len;
        }
        if (len == 1 || K == 0 || K == len || len == 0) {
            return A;
        }
//        System.out.println("step is " + K);
        int[] rotated = new int[len];
        for (int i = 0; i < len; i++) {
            int step = i + K;
            if (step >= len) {
                step -= len;
            }
            rotated[step] = A[i];
        }

        return rotated;
    }

}
