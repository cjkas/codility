package codility;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class FishUpDown {

    public static int solutionprofiled(int[] A, int[] B) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A, B);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    /**
     * 1 == dow
     * 0 == up
     *
     * @param A
     * @param B
     * @return
     */
    public static int solution(int[] A, int[] B) {
        if (A.length == 0 || A.length == 1) {
            return A.length;
        }
        int[] dirs = B;
        int[] sizes = A;
        Stack<Integer> survived = new Stack<>();
        for (int i = 0; i < dirs.length; i++) {
            int dir = dirs[i];
            int fish = dir == 1 ? -(sizes[i] + 1) : (sizes[i] + 1);
            addFish(fish, survived);
        }
        return survived.size();
    }

    private static void addFish(int fish, Stack<Integer> survived) {
        if (survived.size() == 0 || fish < 0) {
            survived.push(fish);
            return;
        }
        if (fish > 0) { //going up
            int l = survived.peek();
            if (l < 0) {
                boolean imdead = false;
                while (!survived.isEmpty()) {
                    l = survived.peek();
                    if (l < 0) {
                        if (Math.abs(fish) > Math.abs(l)) {
                            survived.pop();
                        } else {
                            imdead = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!imdead) {
                    survived.push(fish);
                }
                return;
            }
            survived.push(fish);
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(2, solutionprofiled(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
        Assert.assertEquals(1, solutionprofiled(new int[]{4}, new int[]{0}));
        Assert.assertEquals(0, solutionprofiled(new int[]{}, new int[]{}));
        Assert.assertEquals(2, solutionprofiled(new int[]{2, 4}, new int[]{0, 1}));
        Assert.assertEquals(1, solutionprofiled(new int[]{2, 4}, new int[]{1, 0}));
        Assert.assertEquals(2, solutionprofiled(new int[]{4, 3}, new int[]{0, 0}));
        Assert.assertEquals(2, solutionprofiled(new int[]{0, 0}, new int[]{0, 1}));
        Assert.assertEquals(1, solutionprofiled(new int[]{0, 0}, new int[]{1, 0}));
        Assert.assertEquals(1, solutionprofiled(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{1, 1, 1, 1, 1, 1, 1, 0}));
        int[] x = new int[100_000];
        int[] y = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = i;
            y[i] = 1;
        }
        x[x.length - 1] = 1_000_000_000;
        y[x.length - 1] = 0;
        Assert.assertEquals(1, solutionprofiled(x, y));
    }
}
