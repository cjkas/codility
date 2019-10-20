package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class MaxCounters {

    /**
     * N and M are integers within the range [1..100,000];
     * each element of array A is an integer within the range [1..N + 1].
     *
     * @param A
     * @return
     */
    public static int[] solutionprofiled(int N, int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int[] x = solution(N, A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us ") + " " + x + " in " + Arrays.toString(A));
        return x;
    }

    /**
     * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
     * if A[K] = N + 1 then operation K is max counter.
     *
     * @param N
     * @param A
     * @return
     */
    public static int[] solution(int N, int[] A) {
        int[] operations = A;
        int length = N;
        int maxop = length + 1;
        int[] res = new int[length];
        int max = 0;
        int lastMaxingAt = max;
        boolean maxit = false;
        for (int i = 0; i < operations.length; i++) {
            int op = operations[i];
            if (op >= 1 && op <= length) {
                int index = op - 1;
                int val = res[index];
                if (lastMaxingAt > 0 && val == 0) {
                    val = lastMaxingAt;
                }
                val += 1;
                if (maxit) {
                    maxit = false;
                    res = new int[length];
                    val = max + 1;
                }
                if (val > max) {
                    max = val;
                }
                res[index] = val;
            } else if (op == maxop) {
                if (lastMaxingAt == max) {
                    continue;
                }
//                Arrays.fill(res, max);
                maxit = true;
                lastMaxingAt = max;
            }
//            System.out.println(Arrays.toString(res) + " for " + op);
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                res[i] = lastMaxingAt;
            }
        }
        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals("[3, 2, 2, 4, 2]", Arrays.toString(solutionprofiled(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
        Assert.assertEquals("[1]", Arrays.toString(solutionprofiled(1, new int[]{1, 2})));
        int[] t = new int[50_000];
        for (int i = 0; i < 50_000; i++) {
            t[i] = 5;
            if (i > 2_000) {
                t[i] = 50_001;
            }
        }

        Assert.assertTrue(IntStream.of(solutionprofiled(50_000, t)).allMatch(x -> x == 2001));
    }

}
