package jedrzejbronislaw.propcalc.model;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class SolutionTest_SubstanceNull {

	private static Solution solution;
	
	@BeforeClass
	public static void prepare() {
		solution = new Solution();
		solution.setSubstance(null);
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
		assertEquals(0, solution.numberOfMolecules(), 0);
	}

	@Test(expected = IllegalStateException.class)
	public void testProportionOfVolume() {
		solution.proportionOfVolume();
	}
}
