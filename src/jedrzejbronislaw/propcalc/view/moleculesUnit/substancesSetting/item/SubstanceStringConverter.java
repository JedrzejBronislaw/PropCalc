package jedrzejbronislaw.propcalc.view.moleculesUnit.substancesSetting.item;

import javafx.util.StringConverter;
import jedrzejbronislaw.propcalc.model.molecules.substances.Substance;

public class SubstanceStringConverter extends StringConverter<Substance> {

	public static final String MM_UNIT = "g/mol";
	
	
	@Override
	public String toString(Substance substance) {
		return (substance != null) ? generateText(substance) : "?";
	}
	
	@Override
	public Substance fromString(String string) {
		throw new UnsupportedOperationException();
	}
	
	private String generateText(Substance substance) {
		return substance.getName() + " (" + substance.getMolarMass() + " " + MM_UNIT + ")";
	}
}
