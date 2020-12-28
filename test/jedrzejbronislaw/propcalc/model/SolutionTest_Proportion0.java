package jedrzejbronislaw.propcalc.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import jedrzejbronislaw.propcalc.substances.Substance;

public class SolutionTest_Proportion0 {

	private static Solution solution;
	
	@BeforeClass
	public static void prepare() {
		Substance substance = new Substance("", "", "", 456.7f);
		
		solution = new Solution();
		solution.setSubstance(substance);
		solution.setVolume(1); //1 ml
		solution.setConcentration(1); //1 mg/ml
		solution.setProportion(0);
	}
	
	@Test
	public void testMassOfSubstance() {
		assertEquals(1, solution.massOfSubstance(), 0); //1 mg
	}

	@Test
	public void testNumberOfMolecules() {
		double expected = 1.3186207e+18;
		double actual = solution.numberOfMolecules();
		
		double relativeError = (Math.abs(expected-actual)/expected);
		
		assertTrue(relativeError < 0.00001);
	}

	@Test
	public void testProportionOfVolume() {
		assertEquals(0, solution.proportionOfVolume(), 0);
	}
}
