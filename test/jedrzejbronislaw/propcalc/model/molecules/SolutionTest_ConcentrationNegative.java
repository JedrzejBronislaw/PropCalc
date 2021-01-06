package jedrzejbronislaw.propcalc.model.molecules;

import org.junit.Test;

import jedrzejbronislaw.propcalc.model.molecules.Solution;

public class SolutionTest_ConcentrationNegative {

	@Test(expected = IllegalArgumentException.class)
	public void setNegativeProportion() {
		Solution solution = new Solution();
		solution.setConcentration(-3); //-3 mg/ml
	}
}
