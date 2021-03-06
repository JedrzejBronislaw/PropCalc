package jedrzejbronislaw.propcalc.model.molecules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import jedrzejbronislaw.propcalc.model.molecules.Solution;
import jedrzejbronislaw.propcalc.model.molecules.substances.Substance;
import jedrzejbronislaw.propcalc.tools.RelativeError;

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
		RelativeError relativeError = new RelativeError(6.5931035e+18, solution.numberOfMolecules());

		assertTrue(relativeError.isLessThan(0.00001));
	}

	@Test
	public void testProportionOfVolume() {
		assertEquals(456.7f, solution.proportionOfVolume(), 0);
	}
}
