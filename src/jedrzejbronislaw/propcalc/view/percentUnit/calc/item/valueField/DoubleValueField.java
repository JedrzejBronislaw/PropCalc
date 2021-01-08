package jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField;

import javafx.scene.control.TextField;
import lombok.NonNull;

public class DoubleValueField extends ValueField {

	public static final String DOUBLE_REGEX = "[0-9]+(\\.[0-9]*)?";


	public DoubleValueField(@NonNull TextField textField, @NonNull ChangeController internalChange) {
		super(textField, internalChange, DOUBLE_REGEX);
	}
	
	
	public void display(double value) {
		display(Double.toString(value));
	}

	public Double getDouble() {
		if (textField.getText().isBlank()) return 0.0;
		
		try {
			return Double.parseDouble(textField.getText());
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
