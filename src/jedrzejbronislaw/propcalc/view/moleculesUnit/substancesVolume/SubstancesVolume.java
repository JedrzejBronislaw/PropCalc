package jedrzejbronislaw.propcalc.view.moleculesUnit.substancesVolume;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.view.moleculesUnit.substancesVolume.item.SubstancesVolumeItem;
import jedrzejbronislaw.propcalc.view.moleculesUnit.substancesVolume.item.SubstancesVolumeTotal;

public class SubstancesVolume extends VBox implements Initializable {

	@FXML private VBox substanceBox;
	@FXML private Pane totalPane;
	

	public void addItem(SubstancesVolumeItem item) {
		substanceBox.getChildren().add(item);
	}
	
	
	public SubstancesVolume() {
		MyFXMLLoader.create("moleculesUnit/SubstancesVolume.fxml", this);
	}
	
	public void setTotalPane(SubstancesVolumeTotal totalItem) {
		totalPane.getChildren().clear();
		totalPane.getChildren().add(totalItem);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
