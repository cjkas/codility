package hackerrank;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DiagonaDiff {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int diag1 = 0;
        int diag2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> ints = arr.get(i);
            diag1 += ints.get(i);
            diag2 += ints.get(arr.size() - i -1 );
        }
        int dif = diag1 - diag2;
        if (dif < 0) {
            return Math.abs(dif);
        }
        return dif;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, diagonalDifference(list(list(1, 2, 3), list(2, 3, 4), list(5, 6, 7))));
    }

    private static <T> List<T> list(T... args) {
        List list = new ArrayList<T>(args.length);
        for (T arg : args) {
            list.add(arg);
        }
        return list;
    }
}
