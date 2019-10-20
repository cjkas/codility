package hackerrank;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ClimbingTheLeaderboard {

    static int[] climbingTheLeaderboard(int[] scores, int[] alice) {
        int[] x = new int[scores.length];
        int prev = -1;
        int last = 1;
        int inc = 0;
        for (int i = 0; i < scores.length; i++) {
            if (prev == scores[i]) {
                continue;
            }
            x[inc] = scores[i];
            prev = x[inc];
            last += 1;
            inc += 1;
        }

        int[] res = new int[alice.length];
        Arrays.fill(res, last);
        for (int i = 0; i < alice.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (alice[i] >= x[j]) {
                    res[i] = j + 1;
                    break;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{6, 5, 4, 2, 1}, climbingTheLeaderboard(new int[]{100, 90, 90, 80, 75, 60}, new int[]{50, 65, 77, 90, 102}));
        Assert.assertArrayEquals(new int[]{1}, climbingTheLeaderboard(new int[]{100}, new int[]{100}));
        Assert.assertArrayEquals(new int[]{1}, climbingTheLeaderboard(new int[]{100}, new int[]{99}));
        Assert.assertArrayEquals(new int[]{2}, climbingTheLeaderboard(new int[]{100}, new int[]{101}));
    }
}
