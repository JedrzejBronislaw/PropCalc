package jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField;

import javafx.scene.control.TextField;
import lombok.NonNull;

public class ValueFieldFactory {

	private ChangeController changeController = new ChangeController();
	
	public StringValueField createStringField(@NonNull TextField textField) {
		return new StringValueField(textField, changeController);
	}
	
	public IntValueField createIntField(@NonNull TextField textField) {
		return new IntValueField(textField, changeController);
	}
	
	public DoubleValueField createDoubleField(@NonNull TextField textField) {
		return new DoubleValueField(textField, changeController);
	}
}
