package jedrzejbronislaw.propcalc.view.substanceManager.field;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import jedrzejbronislaw.propcalc.substances.Substance;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;

public class SubstanceField extends GridPane implements Initializable {

	@FXML private TextField name;
	@FXML private TextField fullName;
	@FXML private TextField formula;
	@FXML private TextField molarMass;
	
	
	public SubstanceField() {
		MyFXMLLoader.create("SubstanceField.fxml", this);
	}
	
	public SubstanceField(Substance substance) {
		this();
		loadSubstance(substance);
	}
	
	
	public Substance getSubstance() {
		return new Substance(
				name.getText(),
				fullName.getText(),
				formula.getText(),
				Float.parseFloat(molarMass.getText())
			);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		molarMass.setText("0");
		
		molarMass.textProperty().addListener((o, oldV, newV) -> {
			if (!newV.matches("[0-9]+(\\.[0-9]*)?"))
				molarMass.setText(oldV);
		});
	}

	private void loadSubstance(Substance substance) {
		if (substance == null) return;
		
		setValue(name,      substance.getName());
		setValue(fullName,  substance.getFullName());
		setValue(formula,   substance.getFormula());
		setValue(molarMass, substance.getMolarMass());
	}
	
	private void setValue(TextField field, String value) {
		if (value != null)
			field.setText(value); else
			field.setText("");
	}
	
	private void setValue(TextField field, float value) {
		field.setText(Float.toString(value));
	}
}
