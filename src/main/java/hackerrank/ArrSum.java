package hackerrank;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class ArrSum {

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
