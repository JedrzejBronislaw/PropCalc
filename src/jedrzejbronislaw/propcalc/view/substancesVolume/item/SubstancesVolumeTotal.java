package jedrzejbronislaw.propcalc.view.substancesVolume.item;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import jedrzejbronislaw.propcalc.model.Solution;

public class SubstancesVolumeTotal extends SubstancesVolumeItem {

	private static final String NAME_LABEL = "TOTAL:";
	
	@FXML private Label nameLabel;
	@FXML private TextField volumeField;
	@FXML private Label massLabel;
	@FXML private Label quantityLabel;
	
	private final List<Solution> solutions = new ArrayList<>();
	
	
	public SubstancesVolumeTotal() {
		super(null);
	}
	
	public void addSolution(Solution solution) {
		solutions.add(solution);
		solution.addChangeListener(this::update);
	}
	
	private void update() {
		double vol = 0, mass = 0, number = 0;
		
		for(Solution solution : solutions) {
			vol    += solution.getVolume();
			mass   += solution.massOfSubstance();
			number += solution.numberOfMolecules();
		}
		
		volumeField.setText(Double.toString(vol));
		massLabel.setText(Double.toString(mass));
		quantityLabel.setText(Double.toString(number));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nameLabel.setText(NAME_LABEL);
		
		volumeField.textProperty().addListener((o, oldV, newV) -> {
			validateVolumeField(newV, oldV);
		});
	}
}
