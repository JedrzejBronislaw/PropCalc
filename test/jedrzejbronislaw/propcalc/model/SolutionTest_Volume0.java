package jedrzejbronislaw.propcalc.model;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import jedrzejbronislaw.propcalc.substances.Substance;

public class SolutionTest_Volume0 {

	private static Solution solution;
	
	@BeforeClass
	public static void prepare() {
		Substance substance = new Substance("", "", "", 456.7f);
		
		solution = new Solution();
		solution.setSubstance(substance);
		solution.setVolume(0); //1 ml
		solution.setConcentration(1); //1 mg/ml
		solution.setProportion(1);
	}
	
	@Test
	public void testMassOfSubstance() {
		assertEquals(0, solution.massOfSubstance(), 0); //0 mg
	}

	@Test
	public void testNumberOfMolecules() {
		assertEquals(0, solution.numberOfMolecules(), 0);
	}

	@Test
	public void testProportionOfVolume() {
		assertEquals(456.7f, solution.proportionOfVolume(), 0);
	}
}
