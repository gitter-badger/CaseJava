package api.test.number;

import java.text.NumberFormat;

import org.junit.Assert;
import org.junit.Test;

public class NumberTest {
	
	NumberFormat nf;

	@Test
	public void testNumberFormat() {
		nf = NumberFormat.getNumberInstance();
		Assert.assertEquals("2.346", nf.format(2.34569));
		Assert.assertEquals("11,112.349", nf.format(11112.349));
	}

}
