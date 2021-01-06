package jedrzejbronislaw.propcalc.model.molecules;

import org.junit.Test;

import jedrzejbronislaw.propcalc.model.molecules.Solution;

public class SolutionTest_ProportionNegative {

	@Test(expected = IllegalArgumentException.class)
	public void setNegativeProportion() {
		Solution solution = new Solution();
		solution.setProportion(-3);
	}
}
