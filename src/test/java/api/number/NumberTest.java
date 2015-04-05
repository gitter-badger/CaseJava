package api.number;

import java.text.NumberFormat;

import org.junit.Test;

public class NumberTest {

	@Test
	public void testNumberFormat() {
		NumberFormat nf = NumberFormat.getNumberInstance();
		System.out.println(nf.format(2.34569));
		System.out.println(nf.format(11112.349));
	}

}
