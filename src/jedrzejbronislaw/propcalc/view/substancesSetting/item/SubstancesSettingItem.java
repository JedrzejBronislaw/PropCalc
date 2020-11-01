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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import jedrzejbronislaw.propcalc.model.Solution;
import jedrzejbronislaw.propcalc.substances.Substance;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;

public class SubstancesSettingItem extends HBox implements Initializable {

	@FXML private ComboBox<Substance> substanceBox;
	@FXML private TextField proportionField;
	
	private Callback<ListView<Substance>, ListCell<Substance>> substanceCellFactory = new SubstanceCellFactory();
	
	private final Solution solution;
	
	
	public void setSubstances(List<Substance> substances) {
		Platform.runLater(() -> {
			substanceBox.getItems().clear();
			substanceBox.getItems().addAll(substances);
		});
	}
	
	public SubstancesSettingItem(Solution solution) {
		this.solution = solution;
		MyFXMLLoader.create("SubstancesSettingItem.fxml", this);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		substanceBox.setCellFactory(substanceCellFactory);
		substanceBox.setButtonCell(substanceCellFactory.call(null));
		substanceBox.setOnAction(e -> solution.setSubstance(substanceBox.getValue()));
		
		proportionField.textProperty().addListener((o, oldV, newV) -> {
			validateVolumeField(newV);
			setSolutionProportion();
		});
	}
	
	private void validateVolumeField(String newV) {
		if (!newV.matches("[0-9]*"))
			proportionField.setText(newV.replaceAll("[^0-9]", ""));
	}
	
	private void setSolutionProportion() {
		if (solution != null) {
			int proportion;
			
			try {
				proportion = Integer.parseInt(proportionField.getText());
			} catch (NumberFormatException e) {
				proportion = 0;
			}
			
			solution.setProportion(proportion);
		}
	}
}
