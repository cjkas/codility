package hackerrank;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Triplets {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                alice += 1;
            } else if (a.get(i) < b.get(i)) {
                bob += 1;
            }
        }
        return list(alice, bob);
    }

    @Test
    public void test() {
        Assert.assertEquals("[1, 1]", compareTriplets(list(1, 2, 3), list(3, 2, 1)).toString());
        Assert.assertEquals("[1, 1]", compareTriplets(list(5, 6, 7), list(3, 6, 10)).toString());
        Assert.assertEquals("[2, 1]", compareTriplets(list(17, 28, 30), list(99, 16, 8)).toString());
    }

    private static List<Integer> list(int... args) {
        List list = new ArrayList<Integer>(args.length);
        for (int arg : args) {
            list.add(arg);
        }
        return list;
    }
}
