package jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField;

import javafx.scene.control.TextField;
import lombok.NonNull;

public class DoubleValueField extends ValueField {

	public static final String DOUBLE_REGEX = "[0-9]+(\\.[0-9]*)?";


	public DoubleValueField(@NonNull TextField textField, @NonNull ChangeController internalChange) {
		super(textField, internalChange, DOUBLE_REGEX);
	}
	
	
	public void display(double value) {
		display(Double.toString(round(value)));
	}

	public Double getDouble() {
		if (field.getText().isBlank()) return 0.0;
		
		try {
			return round(Double.parseDouble(field.getText()));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private double round(double value) {
		value = value * 1000;
		long temp = Math.round(value);
		return temp / 1000.0;
	}
}
