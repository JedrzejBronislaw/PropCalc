package jedrzejbronislaw.propcalc.view.percentUnit.calc.item;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import jedrzejbronislaw.propcalc.model.percent.Calc;
import jedrzejbronislaw.propcalc.model.percent.Item;
import jedrzejbronislaw.propcalc.tools.Injection;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.item.ValueField.ChangeController;
import lombok.NonNull;

public class CalcItem extends HBox implements Initializable {

	@FXML protected TextField nameField;
	@FXML protected TextField massField;
	@FXML protected TextField proportionField;
	@FXML protected TextField percentField;
	
	private final Item item;
	private final Calc calc;
	
	protected boolean internalChange = false;
	
	protected ChangeController changeController = new ChangeController();
	private ValueField mass;
	private ValueField prop;
	private ValueField perc;
	
	public CalcItem(@NonNull Item item, @NonNull Calc calc) {
		this.item = item;
		this.calc = calc;
		
		MyFXMLLoader.create("percentUnit/CalcItem.fxml", this);
		update();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mass = new ValueField(massField,       changeController, ValueField.DOUBLE_REGEX);
		prop = new ValueField(proportionField, changeController, ValueField.INT_REGEX);
		perc = new ValueField(percentField,    changeController, ValueField.DOUBLE_REGEX);

		mass.setSettingValue(() -> item.setMass(mass.getDouble()));
		prop.setSettingValue(() -> item.setProportion(prop.getInt()));
		perc.setSettingValue(() -> calc.setPercent(item, perc.getDouble()));
		
		item.addChangeListener(this::update);
	}
	
	private void update() {
		displayName(item.getName());
		mass.display(item.getMass());
		prop.display(item.getProportion());
		perc.display(calc.getPercent(item));
	}
	
	private void internalFXChange(Runnable change) {
		Platform.runLater(() -> {
			internalChange = true;
			Injection.run(change);
			internalChange = false;
		});
	}

	private void displayName(String name) {
		internalFXChange(() -> nameField.setText(name));
	}
}
