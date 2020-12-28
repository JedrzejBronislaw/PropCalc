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

}
