package jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField;

import javafx.scene.control.TextField;
import lombok.NonNull;

public class StringValueField extends ValueField {

	public static final String STRING_REGEX = ".*";
	
	
	public StringValueField(@NonNull TextField textField, @NonNull ChangeController internalChange) {
		super(textField, internalChange, STRING_REGEX);
	}
	
	
	public String getString() {
		return textField.getText();
	}
}
