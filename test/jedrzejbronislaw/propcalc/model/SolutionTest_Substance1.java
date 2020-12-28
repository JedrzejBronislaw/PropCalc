package jedrzejbronislaw.propcalc.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import jedrzejbronislaw.propcalc.substances.Substance;

public class SolutionTest_Substance1 {

	private static Solution solution;
	
	@BeforeClass
	public static void prepare() {
		Substance substance = new Substance("", "", "", 1f);
		
		solution = new Solution();
		solution.setSubstance(substance);
		solution.setVolume(1); //1 ml
		solution.setConcentration(1); //1 mg/ml
		solution.setProportion(1);
	}
	
	@Test
	public void testMassOfSubstance() {
		assertEquals(1, solution.massOfSubstance(), 0); //1 mg
	}

	@Test
	public void testNumberOfMolecules() {
		double expected = 6.02214076e+20;
		double actual = solution.numberOfMolecules();
		
		double relativeError = (Math.abs(expected-actual)/expected);
		
		assertTrue(relativeError < 0.00001);
	}

	@Test
	public void testProportionOfVolume() {
		assertEquals(1f, solution.proportionOfVolume(), 0);
	}
}
