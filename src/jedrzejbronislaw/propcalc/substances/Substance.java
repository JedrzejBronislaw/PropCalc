package jedrzejbronislaw.propcalc.substances;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Substance {

	private final String name;
	private final String fullName;
	private final String formula;
	private final float  molarMass;
	
	public Substance(@NonNull String name, @NonNull String fullName, @NonNull String formula, float molarMass) {
		if (molarMass <= 0) throw new IllegalArgumentException("Molar mass must be greater then 0 (" + molarMass + ").");
		
		this.name = name;
		this.fullName = fullName;
		this.formula = formula;
		this.molarMass = molarMass;
	}
}
