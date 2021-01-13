package jedrzejbronislaw.propcalc.view.percentUnit.calc;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import jedrzejbronislaw.propcalc.tools.Injection;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import lombok.Setter;

public class OptionPane extends VBox implements Initializable {

	@FXML private Label nameLabel;
	@FXML private VBox  valuesBox;
	
	private final String name;
	private final List<String> options;
	private final Map<String, RadioButton> buttons = new HashMap<>();
	private final ToggleGroup toggleGroup = new ToggleGroup();
	
	@Setter
	private Consumer<String> onChangeAction;
	
	
	public OptionPane(String name, List<String> options) {
		this.name = name;
		this.options = options;
		
		MyFXMLLoader.create("percentUnit/Option.fxml", this);
	}


	public void set(String optionName) {
		RadioButton button = buttons.get(optionName);
		
		if (button != null) button.setSelected(true);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nameLabel.setText(name);
		
		for (String option : options)
			valuesBox.getChildren().add(createRadioButton(option));
	}

	private RadioButton createRadioButton(String optionName) {
		RadioButton button = new RadioButton(optionName);
		button.setToggleGroup(toggleGroup);
		button.setOnAction(e -> Injection.run(onChangeAction, button.getText()));
		
		buttons.put(optionName, button);
		
		return button;
	}
}
