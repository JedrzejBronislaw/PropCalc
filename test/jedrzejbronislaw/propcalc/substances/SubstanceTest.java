package jedrzejbronislaw.propcalc.substances;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubstanceTest {

	@Test
	public void correctMolarMass() {
		Substance substance = new Substance("name", "fullName", "formula", 10f);
		assertEquals(10, substance.getMolarMass(), 0.00001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void zeroMolarMass() {
		new Substance("name", "fullName", "formula", 0f);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeMolarMass() {
		new Substance("name", "fullName", "formula", -3f);
	}

	
	@Test(expected = NullPointerException.class)
	public void nullName() {
		new Substance(null, "fullName", "formula", 1f);
	}
	
	@Test(expected = NullPointerException.class)
	public void nullFullname() {
		new Substance("name", null, "formula", 1f);
	}
	
	@Test(expected = NullPointerException.class)
	public void nullFormula() {
		new Substance("name", "fullName", null, 1f);
	}
}
