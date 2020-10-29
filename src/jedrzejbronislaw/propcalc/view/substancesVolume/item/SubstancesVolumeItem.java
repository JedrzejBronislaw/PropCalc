package jedrzejbronislaw.propcalc.view.substancesVolume.item;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import jedrzejbronislaw.propcalc.model.Solution;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;

public class SubstancesVolumeItem extends HBox implements Initializable {

	@FXML private Label nameLabel;
	@FXML private TextField volumeField;
	@FXML private Label massLabel;
	@FXML private Label quantityLabel;
	
	private final Solution solution;
	
	
	public SubstancesVolumeItem(Solution solution) {
		this.solution = solution;
		MyFXMLLoader.create("SubstancesVolumeItem.fxml", this);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (solution != null)
			solution.addChangeListener(() -> nameLabel.setText(solution.getSubstance().getName()));
	}

}
