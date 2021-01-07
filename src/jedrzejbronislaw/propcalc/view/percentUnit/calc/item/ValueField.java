package jedrzejbronislaw.propcalc.view.percentUnit.calc.item;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import jedrzejbronislaw.propcalc.tools.Injection;
import lombok.NonNull;
import lombok.Setter;

public class ValueField {

	public static final String DOUBLE_REGEX = "[0-9]+(\\.[0-9]*)?";
	public static final String INT_REGEX = "[0-9]+";

	public static class ChangeController {
		private boolean permission = true;
		
		public void block() {
			permission = false;
		}
		
		public void unblock() {
			permission = true;
		}
		
		public boolean permit() {
			return permission;
		}
	}
	
	private final TextField textField;
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

	public void display(double value) {
		display(Double.toString(value));
	}
	
	public void display(int value) {
		display(Integer.toString(value));
	}

	public void display(String volumeStr) {
		internalFXChange(() -> {
			int caret = textField.getCaretPosition();
			
			textField.setText(volumeStr);
			
			textField.positionCaret(caret);
		});
	}
	
	protected boolean isNewValue(String newV, String oldV) {
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

	public Double getDouble() {
		if (textField.getText().isBlank()) return 0.0;
		
		try {
			return Double.parseDouble(textField.getText());
		} catch (NumberFormatException e) {
			return null;
		}
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
