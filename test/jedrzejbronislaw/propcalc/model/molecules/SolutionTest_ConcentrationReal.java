package jedrzejbronislaw.propcalc.model.molecules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import jedrzejbronislaw.propcalc.model.molecules.Solution;
import jedrzejbronislaw.propcalc.model.molecules.substances.Substance;

public class SolutionTest_ConcentrationReal {

	private static Solution solution;
	
	@BeforeClass
	public static void prepare() {
		Substance substance = new Substance("", "", "", 456.7f);
		
		solution = new Solution();
		solution.setSubstance(substance);
		solution.setVolume(1); //1 ml
		solution.setConcentration(12.3); //12.3 mg/ml
		solution.setProportion(1);
	}
	
	@Test
	public void testMassOfSubstance() {
		assertEquals(12.3, solution.massOfSubstance(), 0); //12.3 mg
	}

	@Test
	public void testNumberOfMolecules() {
		double expected = 1.621903467221371e+19;
		double actual = solution.numberOfMolecules();
		
		double relativeError = (Math.abs(expected-actual)/expected);
		
		assertTrue(relativeError < 0.00001);
	}

	@Test
	public void testProportionOfVolume() {
		assertEquals(37.13f, solution.proportionOfVolume(), 0.0001);
	}
}
