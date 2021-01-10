package jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField;

import javafx.scene.control.TextField;
import lombok.NonNull;

public class LongValueField extends ValueField {

	public static final String INT_REGEX = "[0-9]+";

	
	public LongValueField(@NonNull TextField textField, @NonNull ChangeController internalChange) {
		super(textField, internalChange, INT_REGEX);
	}
	
	
	public void display(long value) {
		display(Long.toString(value));
	}

	public Long getInt() {
		if (field.getText().isBlank()) return 0L;
		
		try {
			return Long.parseLong(field.getText());
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
