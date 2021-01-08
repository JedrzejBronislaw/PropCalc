package jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField;

import javafx.scene.control.TextField;
import lombok.NonNull;

public class IntValueField extends ValueField {

	public static final String INT_REGEX = "[0-9]+";

	
	public IntValueField(@NonNull TextField textField, @NonNull ChangeController internalChange) {
		super(textField, internalChange, INT_REGEX);
	}
	
	
	public void display(int value) {
		display(Integer.toString(value));
	}

	public Integer getInt() {
		if (textField.getText().isBlank()) return 0;
		
		try {
			return Integer.parseInt(textField.getText());
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
