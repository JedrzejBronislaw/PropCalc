package jedrzejbronislaw.propcalc.model;

import org.junit.Test;

public class SolutionTest_ProportionNegative {

	@Test(expected = IllegalArgumentException.class)
	public void setNegativeProportion() {
		Solution solution = new Solution();
		solution.setProportion(-3);
	}
}
