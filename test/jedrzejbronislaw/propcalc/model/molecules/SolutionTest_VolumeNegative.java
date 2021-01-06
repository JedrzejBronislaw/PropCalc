package jedrzejbronislaw.propcalc.model.molecules;

import org.junit.Test;

import jedrzejbronislaw.propcalc.model.molecules.Solution;

public class SolutionTest_VolumeNegative {

	@Test(expected = IllegalArgumentException.class)
	public void setNegativeVolume() {
		Solution solution = new Solution();
		solution.setVolume(-3); //-3 ml
	}
}
