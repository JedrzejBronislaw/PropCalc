package jedrzejbronislaw.propcalc.view.substancesVolume.item;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import jedrzejbronislaw.propcalc.model.Solution;
import jedrzejbronislaw.propcalc.substances.Substance;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;

public class SubstancesVolumeItem extends HBox implements Initializable {

	private static final DecimalFormat numberOfMoleculesFormat = new DecimalFormat("#.###E0");
	
	@FXML protected Label nameLabel;
	@FXML protected TextField volumeField;
	@FXML protected Label massLabel;
	@FXML protected Label quantityLabel;
	
	private final Solution solution;
	
	
	public SubstancesVolumeItem(Solution solution) {
		this.solution = solution;
		MyFXMLLoader.create("SubstancesVolumeItem.fxml", this);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (solution != null)
			solution.addChangeListener(() -> {
				nameLabel.setText(substace() != null ? substace().getName()+":" : "");
				displayVolume(solution.getVolume());
				displayMassOfSubstance(solution.massOfSubstance());
				displayNumOfMolecules(solution.numberOfMolecules());
			});
		
		volumeField.textProperty().addListener((o, oldV, newV) -> {
			validateVolumeField(newV, oldV);
			setSolutionVolume();
		});
	}

	protected void displayVolume(double value) {
		volumeField.setText(Double.toString(value));
	}

	protected void displayMassOfSubstance(double value) {
		massLabel.setText(Double.toString(value));
	}

	protected void displayNumOfMolecules(double value) {
		quantityLabel.setText(numberOfMoleculesFormat.format(value));
	}

	private Substance substace() {
		return solution.getSubstance();
	}

	protected void validateVolumeField(String newV, String oldV) {
		if (newV.isEmpty()) return;
		
		if (!newV.matches("[0-9]+(\\.[0-9]*)?"))
			volumeField.setText(oldV);
	}
	
	protected void setSolutionVolume() {
		if (solution != null) {
			double volume;
			
			try {
				volume = Double.parseDouble(volumeField.getText());
			} catch (NumberFormatException e) {
				volume = 0;
			}
			
			solution.setVolume(volume);
		}
	}
}
