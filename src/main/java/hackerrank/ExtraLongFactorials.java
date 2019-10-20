package hackerrank;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class ExtraLongFactorials {

    static String extraLongFactorials(int n) {
        BigInteger r = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            r = r.multiply(new BigInteger(i + ""));
        }
        System.out.println(r);
        return r.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("15511210043330985984000000", extraLongFactorials(25));
        Assert.assertEquals("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000", extraLongFactorials(100));
        Assert.assertEquals("1", extraLongFactorials(1));
        Assert.assertEquals("2", extraLongFactorials(2));
    }
}
