package jedrzejbronislaw.propcalc.components;

import jedrzejbronislaw.propcalc.model.molecules.Mixture;
import jedrzejbronislaw.propcalc.model.percent.Calc;
import lombok.Getter;

public class Components {

	@Getter Mixture mixture = new Mixture();
	@Getter Calc calc = new Calc();
}
