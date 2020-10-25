package jedrzejbronislaw.propcalc.view.substancesVolume;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SubstancesVolumeController implements Initializable {

	@FXML private VBox substanceBox;
	@FXML private Pane totalPane;
	

	public void addItem(Node item) {
		substanceBox.getChildren().add(item);
	}
	
	public void setTotalPane(Node item) {
		totalPane.getChildren().clear();
		totalPane.getChildren().add(item);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
