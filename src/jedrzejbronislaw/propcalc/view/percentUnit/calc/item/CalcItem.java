package jedrzejbronislaw.propcalc.view.percentUnit.calc.item;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import jedrzejbronislaw.propcalc.model.percent.Calc;
import jedrzejbronislaw.propcalc.model.percent.Item;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField.ChangeController;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField.DoubleValueField;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField.IntValueField;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField.StringValueField;
import lombok.NonNull;

public class CalcItem extends HBox implements Initializable {

	@FXML protected TextField nameField;
	@FXML protected TextField massField;
	@FXML protected TextField proportionField;
	@FXML protected TextField percentField;
	
	private final Item item;
	private final Calc calc;
	
	protected ChangeController changeController = new ChangeController();
	private StringValueField name;
	private DoubleValueField mass;
	private    IntValueField prop;
	private DoubleValueField perc;
	
	public CalcItem(@NonNull Item item, @NonNull Calc calc) {
		this.item = item;
		this.calc = calc;
		
		MyFXMLLoader.create("percentUnit/CalcItem.fxml", this);
		update();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name = new StringValueField(nameField,       changeController);
		mass = new DoubleValueField(massField,       changeController);
		prop = new    IntValueField(proportionField, changeController);
		perc = new DoubleValueField(percentField,    changeController);

		name.setSettingValue(() -> item.setName(         name.getString()));
		mass.setSettingValue(() -> item.setMass(         mass.getDouble()));
		prop.setSettingValue(() -> item.setProportion(   prop.getInt()));
		perc.setSettingValue(() -> calc.setPercent(item, perc.getDouble()));
		
		calc.addChangeListener(this::update);
	}
	
	private void update() {
		name.display(item.getName());
		mass.display(item.getMass());
		prop.display(item.getProportion());
		perc.display(calc.getPercent(item));
	}
}
