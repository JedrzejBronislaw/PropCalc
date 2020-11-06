package jedrzejbronislaw.propcalc.view.substancesVolume.item;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import jedrzejbronislaw.propcalc.model.Solution;
import jedrzejbronislaw.propcalc.substances.Substance;
import jedrzejbronislaw.propcalc.tools.Injection;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;

public class SubstancesVolumeItem extends HBox implements Initializable {

	private static final DecimalFormat massOfSubstanceFormat = new DecimalFormat("#.###");
	private static final DecimalFormat numberOfMoleculesFormat = new DecimalFormat("#.###E0");
	
	@FXML protected Label nameLabel;
	@FXML protected TextField volumeField;
	@FXML protected Label massLabel;
	@FXML protected Label quantityLabel;

	private Tooltip nameTip = new Tooltip();
	private Tooltip volumeTip = new Tooltip();
	private Tooltip massTip = new Tooltip();
	private Tooltip quantityTip = new Tooltip();
	
	private final Solution solution;
	
	protected boolean internalChange = false;
	
	public SubstancesVolumeItem(Solution solution) {
		this.solution = solution;
		MyFXMLLoader.create("SubstancesVolumeItem.fxml", this);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setToolTips();
		
		if (solution != null)
			solution.addChangeListener(() -> {
				displayName(substace());
				displayVolume(solution.getVolume());
				displayMassOfSubstance(solution.massOfSubstance());
				displayNumOfMolecules(solution.numberOfMolecules());
			});
		
		volumeField.textProperty().addListener((o, oldV, newV) -> {
			if (internalChange) return;
			
			if (isNewVolumeValue(newV, oldV))
				setSolutionVolume();
		});
	}

	protected void setToolTips() {
		volumeField.setTooltip(volumeTip);
		massLabel.setTooltip(massTip);
		quantityLabel.setTooltip(quantityTip);
	}
	
	private void internalFXChange(Runnable change) {
		Platform.runLater(() -> {
			internalChange = true;
			Injection.run(change);
			internalChange = false;
		});
	}

	private void displayName(Substance substance) {
		internalFXChange(() -> {
			if (substance != null) {
				nameLabel.setText(substance.getName()+":");
				nameLabel.setTooltip(nameTip);
				nameTip.setText(substance.getFullName() + " (" + substance.getFormula() + ")");
			} else {
				nameLabel.setText("");
				nameLabel.setTooltip(null);
			}
		});
	}

	protected void displayVolume(double value) {
		displayVolume(Double.toString(value));
	}

	private void displayVolume(String volumeStr) {
		internalFXChange(() -> {
			int caret = volumeField.getCaretPosition();
			
			volumeField.setText(volumeStr);
			volumeTip.setText(volumeStr);
			
			volumeField.positionCaret(caret);
		});
	}

	protected void displayMassOfSubstance(double value) {
		internalFXChange(() -> {
			massLabel.setText(massOfSubstanceFormat.format(value));
			massTip.setText(Double.toString(value));
		});
	}

	protected void displayNumOfMolecules(double value) {
		internalFXChange(() -> {
			quantityLabel.setText(numberOfMoleculesFormat.format(value));
			quantityTip.setText(Double.toString(value));
		});
	}

	private Substance substace() {
		return solution.getSubstance();
	}

	protected boolean isNewVolumeValue(String newV, String oldV) {
		if (correctVolumeValue(newV))  return true;
		
		displayVolume(oldV);
		return false;
	}
	
	private boolean correctVolumeValue(String value) {
		if (value.isEmpty()) return true;
		
		if (solution != null && solution.getProportion() == 0)
			return false;
		
		if (!value.matches("[0-9]+(\\.[0-9]*)?"))
			return false;

		return true;
	}
	
	protected void setSolutionVolume() {
		if (solution != null)
			solution.setVolume(getDoubleVolume());
	}
	
	protected Double getDoubleVolume() {
		if (volumeField.getText().isBlank()) return 0.0;
		
		try {
			return Double.parseDouble(volumeField.getText());
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
