package jedrzejbronislaw.propcalc.substances;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Substance {

	private final String name;
	private final String fullName;
	private final String formula;
	private final float  molarMass;
}
