package jedrzejbronislaw.propcalc.model;

import org.junit.Test;

public class SolutionTest_VolumeNegative {

	@Test(expected = IllegalArgumentException.class)
	public void setNegativeVolume() {
		Solution solution = new Solution();
		solution.setVolume(-3); //-3 ml
	}
}
