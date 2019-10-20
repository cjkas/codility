package codility;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class GenomicRangeQuery {

    public static int[] solutionprofiled(String S, int[] P, int[] Q) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int[] x = solution2(S, P, Q);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    /**
     * N is an integer within the range [1..100,000];
     * M is an integer within the range [1..50,000];
     * each element of arrays P, Q is an integer within the range [0..N − 1];
     * P[K] ≤ Q[K], where 0 ≤ K < M;
     * string S consists only of upper-case English letters A, C, G, T.
     *
     * @param S
     * @param P
     * @param Q
     * @return
     */
    public static int[] solution2(String S, int[] P, int[] Q) {
        if (S.length() == 1) {
            return new int[]{toInt(S.charAt(0))};
        }
        char[] genes = S.toCharArray();
        int[] prefA = new int[genes.length];
        int[] prefC = new int[genes.length];
        int[] prefG = new int[genes.length];
        int lastA = 0;
        int lastC = 0;
        int lastG = 0;
        for (int i = 0; i < genes.length; i++) {
            char value = genes[i];
            if (value == 'A') {
                lastA += 1;
            } else if (value == 'C') {
                lastC += 1;
            } else if (value == 'G') {
                lastG += 1;
            }
            prefA[i] = lastA;
            prefC[i] = lastC;
            prefG[i] = lastG;
        }
        System.out.println("A " + Arrays.toString(prefA));
        System.out.println("C " + Arrays.toString(prefC));
        System.out.println("G " + Arrays.toString(prefG));
        int opsLen = P.length;
        int[] mif = new int[opsLen];
        for (int i = 0; i < opsLen; i++) {
            int start = P[i];
            int end = Q[i];
            int lowest = 4;
            if (start == end) {
                lowest = toInt(genes[start]);
            } else if (prefA[end] - prefA[start] > 0) {
                lowest = 1;
            } else if (prefC[end] - prefC[start] > 0) {
                lowest = 2;
            } else if (prefG[end] - prefG[start] > 0) {
                lowest = 3;
            }
            mif[i] = lowest;
        }
        return mif;
    }

    public static int[] solution(String S, int[] P, int[] Q) {
        char[] org = S.toCharArray();
        int len = P.length;
        int[] mif = new int[len];
        for (int i = 0; i < len; i++) {
            int start = P[i];
            int end = Q[i];
            char lowest = org[start];
            char onEnd = org[end];
            if (onEnd == 'A') {
                lowest = 'A';
            } else if (lowest != 'A') {
                for (int j = start + 1; j <= end; j++) {
                    char cur = org[j];
                    if (cur < lowest) {
                        lowest = cur;
                        if (lowest == 'A') {
                            break;
                        }
                    }
                }
            }
            mif[i] = toInt(lowest);
        }
        return mif;
    }

    private static int getFromCache(int[] cache, char[] org, int index) {
        int val = cache[index];
        if (val == 0) {
            int i = toInt(org[index]);
            val = i;
            cache[index] = val;
        }
        return val;
    }

    private static int toInt(char p) {
        switch (p) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
        }
        throw new RuntimeException("cant translate " + p);
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{2, 4, 1}, solutionprofiled("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
        Assert.assertArrayEquals(new int[]{2, 2, 2}, solutionprofiled("CCCCCCC", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
        Assert.assertArrayEquals(new int[]{2}, solutionprofiled("C", new int[]{0}, new int[]{0}));
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 14_000; i++) {
            b.append("CGCCT");
        }
        b.append('A').append('T');
        int[] x = new int[50_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = i;
        }
        int[] y = new int[50_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = i + 1000;
        }

        y[0] = b.length() - 1;
        solutionprofiled(b.toString(), x, y);
    }

}
