package jedrzejbronislaw.propcalc.model;

import org.junit.Test;

public class SolutionTest_ConcentrationNegative {

	@Test(expected = IllegalArgumentException.class)
	public void setNegativeProportion() {
		Solution solution = new Solution();
		solution.setConcentration(-3); //-3 mg/ml
	}
}
