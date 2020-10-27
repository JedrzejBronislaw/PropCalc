package jedrzejbronislaw.propcalc.view.substancesVolume;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import jedrzejbronislaw.propcalc.view.substancesVolume.item.SubstancesVolumeItem;

public class SubstancesVolumeController implements Initializable {

	@FXML private VBox substanceBox;
	@FXML private Pane totalPane;
	

	public void addItem(SubstancesVolumeItem item) {
		substanceBox.getChildren().add(item);
	}
	
	public void setTotalPane(SubstancesVolumeItem item) {
		totalPane.getChildren().clear();
		totalPane.getChildren().add(item);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
