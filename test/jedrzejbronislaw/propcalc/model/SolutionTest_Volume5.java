package jedrzejbronislaw.propcalc.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import jedrzejbronislaw.propcalc.substances.Substance;

public class SolutionTest_Volume5 {

	private static Solution solution;
	
	@BeforeClass
	public static void prepare() {
		Substance substance = new Substance("", "", "", 456.7f);
		
		solution = new Solution();
		solution.setSubstance(substance);
		solution.setVolume(5); //5 ml
		solution.setConcentration(1); //1 mg/ml
		solution.setProportion(1);
	}
	
	@Test
	public void testMassOfSubstance() {
		assertEquals(5, solution.massOfSubstance(), 0); //5 mg
	}

	@Test
	public void testNumberOfMolecules() {
		double expected = 6.5931035e+18;
		double actual = solution.numberOfMolecules();
		
		double relativeError = (Math.abs(expected-actual)/expected);
		
		assertTrue(relativeError < 0.00001);
	}

	@Test
	public void testProportionOfVolume() {
		assertEquals(456.7f, solution.proportionOfVolume(), 0);
	}
}
