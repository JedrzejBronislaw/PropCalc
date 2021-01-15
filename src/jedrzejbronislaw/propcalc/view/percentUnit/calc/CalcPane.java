package jedrzejbronislaw.propcalc.view.percentUnit.calc;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import jedrzejbronislaw.propcalc.model.percent.Calc;
import jedrzejbronislaw.propcalc.tools.Injection;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.item.CalcItem;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField.DoubleValueField;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField.ValueFieldFactory;
import lombok.Setter;

public class CalcPane extends VBox implements Initializable {

	@FXML private VBox itemBox;
	@FXML private Button addButton;
	@FXML private Button clearButton;
	@FXML private TextField totalMassField;
	@FXML private Label     totalProportionLabel;
	
	@Setter private Runnable addAction;
	
	private ValueFieldFactory fieldFactory = new ValueFieldFactory();
	private DoubleValueField massField;
	
	private Calc calc;

	public void addItem(CalcItem item) {
		itemBox.getChildren().add(item);
	}
	
	
	public CalcPane(Calc calc) {
		this.calc = calc;
		MyFXMLLoader.create("percentUnit/Calc.fxml", this);
		
		update();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addButton.  setOnAction(e -> Injection.run(addAction));
		clearButton.setOnAction(e -> calc.clear());
		massField = fieldFactory.createDoubleField(totalMassField);
		
		massField.setSettingValue(() -> calc.setTotalMass(massField.getDouble()));
		
		calc.addChangeListener(this::update);
	}

	private void update() {
		massField.display(calc.totalMass());
		totalProportionLabel.setText(calc.totalProportion() + "");
	}
}
