package jedrzejbronislaw.propcalc.view.substancesSetting;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import jedrzejbronislaw.propcalc.tools.Injection;
import lombok.Setter;

public class SubstancesSettingController implements Initializable {

	@FXML private VBox substanceBox;
	@FXML private Button addButton;
	
	@Setter private Runnable addAction;
	@Setter private Runnable onAddSubstance;
	
	
	public void addItem(Node item) {
		substanceBox.getChildren().add(item);
		Injection.run(onAddSubstance);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addButton.setOnAction(e -> Injection.run(addAction));
	}

}
