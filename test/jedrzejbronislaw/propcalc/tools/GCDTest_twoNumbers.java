package jedrzejbronislaw.propcalc.tools;

import static org.junit.Assert.*;

import org.junit.Test;

public class GCDTest_twoNumbers {

	@Test
	public void twoNumbers_8_12() {
		assertEquals(4, GCD.gcd(8, 12));
	}
	
	@Test
	public void twoNumbers_prime_7_11() {
		assertEquals(1, GCD.gcd(7, 11));
	}
	
	@Test
	public void twoNumbers_onePrime_124_11() {
		assertEquals(1, GCD.gcd(124, 11));
	}
	
	@Test
	public void twoNumbers_multiple_124_31() {
		assertEquals(31, GCD.gcd(124, 31));
	}
	
	@Test
	public void twoNumbers_theSame_1245_1245() {
		assertEquals(1245, GCD.gcd(1245, 1245));
	}
	
	@Test
	public void twoNumbers_zero_124_0() {
		assertEquals(124, GCD.gcd(124, 0));
	}
	
	@Test
	public void twoNumbers_zero_0_0() {
		assertEquals(0, GCD.gcd(0, 0));
	}
	
	@Test
	public void twoNumbers_bigPrime_1001267_751301() {
		assertEquals(1, GCD.gcd(1001267, 751301));
	}
	
	@Test
	public void twoNumbers_oneBigPrime_1001262_751301() {
		assertEquals(1, GCD.gcd(1001262, 751301));
	}
	
	@Test
	public void twoNumbers_bigNumbers_84755478_75413654() {
		assertEquals(2, GCD.gcd(84755478, 75413654));
	}
	
	@Test
	public void twoNumbers_441_231() {
		assertEquals(21, GCD.gcd(441, 231));
	}
	
	@Test
	public void twoNumbers_1_1000000000() {
		assertEquals(1, GCD.gcd(1, 1000000000));
	}
	
	//negative
	
	@Test
	public void twoNumbers_minus15_50() {
		assertEquals(5, GCD.gcd(-15, 50));
	}
	
	@Test
	public void twoNumbers_15_minus50() {
		assertEquals(5, GCD.gcd(15, -50));
	}
	
	@Test
	public void twoNumbers_minus15_minus50() {
		assertEquals(5, GCD.gcd(-15, -50));
	}
}
