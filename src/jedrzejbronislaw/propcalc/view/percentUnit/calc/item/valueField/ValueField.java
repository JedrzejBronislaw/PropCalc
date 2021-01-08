package jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import jedrzejbronislaw.propcalc.tools.Injection;
import lombok.NonNull;
import lombok.Setter;

public abstract class ValueField {

	protected final TextField textField;
	private final ChangeController internalChange;
	private final String regex;
	@Setter private Runnable settingValue;

	
	public ValueField(@NonNull TextField textField, @NonNull ChangeController internalChange, @NonNull String regex) {
		this.textField = textField;
		this.internalChange = internalChange;
		this.regex = regex;
		
		textField.textProperty().addListener((o, oldV, newV) -> {
			if (!internalChange.permit()) return;
			
			if (isNewValue(newV, oldV))
				Injection.run(settingValue);
		});
	}
	
	
	private void internalFXChange(Runnable change) {
		Platform.runLater(() -> {
			internalChange.block();
			Injection.run(change);
			internalChange.unblock();
		});
	}

	public void display(String volumeStr) {
		internalFXChange(() -> {
			int caret = textField.getCaretPosition();
			
			textField.setText(volumeStr);
			
			textField.positionCaret(caret);
		});
	}
	
	private boolean isNewValue(String newV, String oldV) {
		if (isCorrectValue(newV))  return true;
		
		display(oldV);
		return false;
	}
	
	private boolean isCorrectValue(String value) {
		if (value.isEmpty()) return true;
		
		if (!value.matches(regex))
			return false;

		return true;
	}
}
