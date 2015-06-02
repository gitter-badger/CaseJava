package api.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.junit.Assert;
import org.junit.Test;

public class NumberTest {

    @Test
    public void testNumberFormat() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        Assert.assertEquals("2.346", nf.format(2.34569));
        Assert.assertEquals("11,112.349", nf.format(11112.349));
        DecimalFormat df = new DecimalFormat(",000.##");
        Assert.assertEquals("111,111.23", df.format(111111.234));
    }

    @Test
    public void testNumberEquals() {
        BigDecimal one = new BigDecimal(1);
        int result = one.compareTo(new BigDecimal(1));
        Assert.assertEquals(result, 0);
    }

}
