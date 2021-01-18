package jedrzejbronislaw.propcalc.components;

import java.text.DecimalFormat;

import jedrzejbronislaw.propcalc.model.percent.Calc;
import jedrzejbronislaw.propcalc.model.percent.Item;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalcClipboard extends Clipboard {

	private static final DecimalFormat    MASS_FORMAT = FLOAT_FORMAT;
	private static final DecimalFormat PERCENT_FORMAT = FLOAT_FORMAT;
	
	private final Calc calc;

	
	@Override
	protected void header() {
		value("Name");
		value("Mass [mg]");
		value("Proportion");
		value("Percentage");
		newLine();
	}

	@Override
	protected void body() {
		calc.getItems().forEach(this::record);
	}

	private void record(Item item) {
		value(item.getName());
		value(MASS_FORMAT.format(item.getMass()));
		value(item.getProportion());
		value(PERCENT_FORMAT.format(calc.getPercent(item)));
		newLine();
	}
	
	@Override
	protected void total() {
		double mass    = 0.0;
		int proportion = 0;
		
		for(Item item : calc.getItems()) {
			mass       += item.getMass();
			proportion += item.getProportion();
		}	
		
		value("TOTAL");
		value(MASS_FORMAT.format(mass));
		value(proportion);
		value(PERCENT_FORMAT.format(100));
	}
}
