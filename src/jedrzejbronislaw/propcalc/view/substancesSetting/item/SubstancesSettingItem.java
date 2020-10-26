package jedrzejbronislaw.propcalc.view.substancesSetting.item;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import jedrzejbronislaw.propcalc.substances.Substance;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;

public class SubstancesSettingItem extends HBox implements Initializable {

	@FXML private ComboBox<Substance> substanceBox;
	
	private Callback<ListView<Substance>, ListCell<Substance>> substanceCellFactory = new SubstanceCellFactory();
	
	
	public void setSubstances(List<Substance> substances) {
		Platform.runLater(() -> {
			substanceBox.getItems().clear();
			substanceBox.getItems().addAll(substances);
		});
	}
	
	public SubstancesSettingItem() {
		MyFXMLLoader.create("SubstancesSettingItem.fxml", this);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		substanceBox.setCellFactory(substanceCellFactory);
		substanceBox.setButtonCell(substanceCellFactory.call(null));
	}

}
