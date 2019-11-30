package codility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class Peaks {

    public static int solutionprofiled(int[] A) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(A);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    private static int solution(int[] A) {
        int blocks = 0;
        if (A.length < 6) {
            return blocks;
        }
        List<Integer> dividers = divs(A.length);
        System.out.println("divs " + dividers + " for " + A.length);
        if (dividers.size() == 0) {
            return blocks;
        }
        for (int divider : dividers) { //every divider
            int step = A.length / divider;
            boolean isOk = true;
            for (int i = 1; i < A.length; i += step) { //every block
                boolean hasMax = false;
                for (int j = i; j < i + step; j++) {
                    if (j + 1 >= A.length) {
                            continue;
                    }
                    int a = A[j - 1];
                    int b = A[j];
                    int c = A[j + 1];
//                    System.out.print(step + ":" + a + "," + b + "," + c + "=");
                    if (a < b && b > c) {
                        hasMax = true;
//                        System.out.println(hasMax);
                        break;
                    }
//                    System.out.println(hasMax);
                }
                System.out.println("divider " + divider + " len " + step + ", block " + i / step + " " + hasMax);
                if (!hasMax) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                blocks = divider;
            }
            System.out.print("  \r\n");
        }
        return blocks;
    }

    private static List<Integer> divs(int N) {
        int i = 3;
        List<Integer> divs = new ArrayList<>();
        while (i * i < N) {
            if (N % i == 0) {
                divs.add(i);
                divs.add(N / i);
            }
            i++;
        }
        if (i * i == N) {
            divs.add(i);
        }
        return divs;
    }


    @Test
    public void test() {
        Assert.assertEquals(3, solutionprofiled(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
        Assert.assertEquals(3, solutionprofiled(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 2, 3, 6}));
        Assert.assertEquals(0, solutionprofiled(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 3, 3, 6}));
    }
}
