package jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import jedrzejbronislaw.propcalc.tools.Injection;
import lombok.NonNull;
import lombok.Setter;

public abstract class ValueField {

	protected final TextField field;
	private   final ChangeController internalChange;
	private   final String regex;

	@Setter private Runnable settingValue;

	
	public ValueField(@NonNull TextField textField, @NonNull ChangeController changeController, @NonNull String regex) {
		this.field = textField;
		this.internalChange = changeController;
		this.regex = regex;
		
		field.textProperty().addListener((o, oldV, newV) -> {
			if (internalChange.isOngoing()) return;
			
			if (isCorrectValue(newV))
				Injection.run(settingValue); else
				display(oldV);
		});
	}
	

	public void display(String value) {
		internalFXChange(() -> {
			int caret = field.getCaretPosition();
			field.setText(value);
			field.positionCaret(caret);
		});
	}
	
	private void internalFXChange(Runnable changeAction) {
		Platform.runLater(() -> {
			internalChange.start();
			Injection.run(changeAction);
			internalChange.end();
		});
	}
	
	private boolean isCorrectValue(String value) {
		return value.isEmpty() || value.matches(regex);
	}
}
