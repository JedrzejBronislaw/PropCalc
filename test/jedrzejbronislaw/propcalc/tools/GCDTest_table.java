package jedrzejbronislaw.propcalc.tools;

import static org.junit.Assert.*;

import org.junit.Test;

public class GCDTest_table {

	@Test
	public void threeNumbers_8_12_44() {
		assertEquals(4, GCD.gcd(8, 12, 44));
	}
	
	@Test
	public void threeNumbers_prime_7_11_23() {
		assertEquals(1, GCD.gcd(7, 11, 23));
	}
	
	@Test
	public void threeNumbers_onePrime_124_11_99() {
		assertEquals(1, GCD.gcd(124, 11, 99));
	}
	
	@Test
	public void threeNumbers_multiple_124_31_310() {
		assertEquals(31, GCD.gcd(124, 31, 310));
	}
	
	@Test
	public void threeNumbers_theSame_1245_1245_1245() {
		assertEquals(1245, GCD.gcd(1245, 1245, 1245));
	}
	
	@Test
	public void threeNumbers_zero_124_0_44() {
		assertEquals(4, GCD.gcd(124, 0, 44));
	}
	
	@Test
	public void threeNumbers_zero_124_0_0() {
		assertEquals(124, GCD.gcd(124, 0, 0));
	}
	
	@Test
	public void threeNumbers_zero_0_0_0() {
		assertEquals(0, GCD.gcd(0, 0, 0));
	}
	
	@Test
	public void threeNumbers_bigPrime_1001267_751301_850397() {
		assertEquals(1, GCD.gcd(1001267, 751301, 850397));
	}
	
	@Test
	public void threeNumbers_oneBigPrime_1001262_751301_951302() {
		assertEquals(1, GCD.gcd(1001262, 751301, 951302));
	}
	
	@Test
	public void threeNumbers_bigNumbers_17757138_15778434_3250569() {
		assertEquals(21, GCD.gcd(17757138, 15778434, 3250569));
	}
	
	@Test
	public void threeNumbers_441_231_861() {
		assertEquals(21, GCD.gcd(441, 231, 861));
	}
	
	@Test
	public void fourNumbers_441_231_861_2121() {
		assertEquals(21, GCD.gcd(441, 231, 861, 2121));
	}
	
	@Test
	public void fiveNumbers_441_231_861_2121_882() {
		assertEquals(21, GCD.gcd(441, 231, 861, 2121, 882));
	}
	
	@Test
	public void elevenNumbers_441_minus231_861_2121_0_882_0_21_minus21000_861_321() {
		assertEquals(21, GCD.gcd(441, -231, 861, 2121, 0, 882, 0, 21, -21000000, 861, 231));
	}
	
	@Test
	public void oneNumber_124() {
		assertEquals(124, GCD.gcd(124));
	}
	
	@Test
	public void oneNumber_minus124() {
		assertEquals(124, GCD.gcd(-124));
	}
	
	@Test
	public void oneNumber_1() {
		assertEquals(1, GCD.gcd(1));
	}
	
	@Test
	public void oneNumber_0() {
		assertEquals(0, GCD.gcd(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void zeroNumbers() {
		GCD.gcd();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullNumbers() {
		GCD.gcd(null);
	}
	
	//negative
	
	@Test
	public void threeNumbers_minus15_50_125() {
		assertEquals(5, GCD.gcd(-15, 50, 125));
	}
	
	@Test
	public void threeNumbers_15_minus50_125() {
		assertEquals(5, GCD.gcd(15, -50, 125));
	}
	
	@Test
	public void threeNumbers_15_minus50_minus125() {
		assertEquals(5, GCD.gcd(15, -50, -125));
	}
	
	@Test
	public void threeNumbers_minus15_50_minus125() {
		assertEquals(5, GCD.gcd(-15, 50, -125));
	}
	
	@Test
	public void threeNumbers_minus15_minus50_minus50() {
		assertEquals(5, GCD.gcd(-15, -50, -50));
	}
}
