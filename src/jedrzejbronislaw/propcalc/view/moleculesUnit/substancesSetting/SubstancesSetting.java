package jedrzejbronislaw.propcalc.view.moleculesUnit.substancesSetting;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import jedrzejbronislaw.propcalc.tools.Injection;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.view.moleculesUnit.substancesSetting.item.SubstancesSettingItem;
import lombok.Setter;

public class SubstancesSetting extends VBox implements Initializable {

	@FXML private VBox substanceBox;
	@FXML private Button addButton;
	
	@Setter private Runnable addAction;
	@Setter private Runnable onAddSubstance;
	
	
	public void addItem(SubstancesSettingItem item) {
		substanceBox.getChildren().add(item);
		Injection.run(onAddSubstance);
	}
	
	
	public SubstancesSetting() {
		MyFXMLLoader.create("moleculesUnit/SubstancesSetting.fxml", this);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addButton.setOnAction(e -> Injection.run(addAction));
	}

}
