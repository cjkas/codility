package codility;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class StoneWallSQ {

    public static int solutionprofiled(int[] H) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(H);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    /**
     * @return
     */
    public static int solution(int[] H) {
        Stack<Integer> b = new Stack<>();
        b.push(H[0]);
        int cnt = 1;
        int last = H[0];
        for (int i = 1; i < H.length; i++) {
            int next = H[i];
            if (last == next) { //same
                continue;
            } else if (next > last) { //bigger
//                System.out.println("im bigger  " + height + " then prev " + b.peek());
                cnt++;
            } else { //smaller
//                System.out.println("im smaller " + height + " then prev " + b.peek());
                for (int j = b.size() - 1; j >= 0; j--) {
                    int prev = b.get(j);
                    if (prev == next) {
//                        System.out.println("im smaller and eq " + height);
                        break;
                    }
                    if (prev < next || j == 0) {
//                        System.out.println("im smallest " + height);
                        cnt++;
                        break;
                    }
                }
            }
            b.push(next);
            last = next;
        }
        return cnt;
    }

    @Test
    public void test() {
        Assert.assertEquals(7, solutionprofiled(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
        Assert.assertEquals(1, solutionprofiled(new int[]{8}));
        Assert.assertEquals(1, solutionprofiled(new int[]{8, 8, 8, 8}));
        Assert.assertEquals(3, solutionprofiled(new int[]{8, 9, 10}));
        Assert.assertEquals(3, solutionprofiled(new int[]{5, 4, 3}));
        Assert.assertEquals(8, solutionprofiled(new int[]{8, 8, 5, 7, 9, 8, 9, 4, 8}));
        Assert.assertEquals(2, solutionprofiled(new int[]{1, 1, 1, 2, 2, 2, 1, 1, 1}));
        Assert.assertEquals(4, solutionprofiled(new int[]{1, 2, 1, 2, 1, 2}));
    }
}
