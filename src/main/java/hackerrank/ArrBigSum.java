package hackerrank;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.Assert;
import org.junit.Test;

public class ArrBigSum {

    static long aVeryBigSum(long[] ar) {

        return LongStream.of(ar).sum();
    }


    static int simpleArraySum(int[] ar) {
        /*
         * Write your code here.
         */
        return IntStream.of(ar).sum();
    }

    @Test
    public void test() {
        //GIVEN

        Assert.assertEquals(5, simpleArraySum(new int[]{1, 1, 3}));
        //WHEN
        Assert.assertEquals(1, simpleArraySum(new int[]{1}));
        Assert.assertEquals(0, simpleArraySum(new int[]{}));

        //THEN

    }
}
