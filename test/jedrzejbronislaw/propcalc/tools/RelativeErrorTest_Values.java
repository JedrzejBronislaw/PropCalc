package jedrzejbronislaw.propcalc.tools;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RelativeErrorTest_Values {

	@Test
	public void test100_100() {
		RelativeError relativeError = new RelativeError(100, 100);
		
		assertEquals(0, relativeError.value(), 0.00000001);
	}
	
	@Test
	public void test100_90() {
		RelativeError relativeError = new RelativeError(100, 90);
		
		assertEquals(0.1, relativeError.value(), 0.00000001);
	}
	
	@Test
	public void test100_110() {
		RelativeError relativeError = new RelativeError(100, 110);
		
		assertEquals(0.1, relativeError.value(), 0.00000001);
	}
	
	@Test
	public void test100_99() {
		RelativeError relativeError = new RelativeError(100, 99);
		
		assertEquals(0.01, relativeError.value(), 0.00000001);
	}
	
	@Test
	public void test90_100() {
		RelativeError relativeError = new RelativeError(90, 100);
		
		assertEquals(0.11111111, relativeError.value(), 0.00000001);
	}
	
	@Test
	public void test1000000_999999() {
		RelativeError relativeError = new RelativeError(1000000, 999999);
		
		assertEquals(1e-6, relativeError.value(), 0.00000001);
	}
	
	//zero
	
	@Test(expected = IllegalArgumentException.class)
	public void test0_90() {
		new RelativeError(0, 90);
	}
	
	@Test
	public void test100_0() {
		RelativeError relativeError = new RelativeError(100, 0);
		
		assertEquals(1, relativeError.value(), 0.00000001);
	}
	
	@Test
	public void test0_0() {
		RelativeError relativeError = new RelativeError(0, 0);
		
		assertEquals(0, relativeError.value(), 0.00000001);
	}
	
	//negative values
	
	@Test
	public void testMinus100_90() {
		RelativeError relativeError = new RelativeError(-100, 90);
		
		assertEquals(1.9, relativeError.value(), 0.00000001);
	}
	
	@Test
	public void testMinus100_100() {
		RelativeError relativeError = new RelativeError(-100, 100);
		
		assertEquals(2, relativeError.value(), 0.00000001);
	}
	
	@Test
	public void testMinus100_Minus90() {
		RelativeError relativeError = new RelativeError(-100, -90);
		
		assertEquals(0.1, relativeError.value(), 0.00000001);
	}
	
	@Test
	public void test100_Minus90() {
		RelativeError relativeError = new RelativeError(100, -90);
		
		assertEquals(1.9, relativeError.value(), 0.00000001);
	}
}
