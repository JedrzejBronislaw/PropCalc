package jedrzejbronislaw.propcalc.model.molecules;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import jedrzejbronislaw.propcalc.model.molecules.Solution;
import jedrzejbronislaw.propcalc.model.molecules.substances.Substance;

public class SolutionTest_Concentration0 {

	private static Solution solution;
	
	@BeforeClass
	public static void prepare() {
		Substance substance = new Substance("", "", "", 456.7f);
		
		solution = new Solution();
		solution.setSubstance(substance);
		solution.setVolume(1); //1 ml
		solution.setConcentration(0); //0 mg/ml
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

	@Test(expected = IllegalStateException.class)
	public void testProportionOfVolume() {
		solution.proportionOfVolume();
	}
}
