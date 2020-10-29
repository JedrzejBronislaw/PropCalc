package jedrzejbronislaw.propcalc.model;

import jedrzejbronislaw.propcalc.substances.Substance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Solution {
	
	private Substance substance;
	private double concentration;
	private int proportion;
	
	private double volume;
	
	public double massOfSubstance() {
		return volume * concentration;
	};
	
	public double numberOfMolecules() {
		if (substance == null) return 0;
		
		return massOfSubstance() / substance.getMolarMass() * Consts.AVOGADRO;
	};
}
