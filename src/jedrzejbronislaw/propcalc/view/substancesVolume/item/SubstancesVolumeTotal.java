package jedrzejbronislaw.propcalc.view.substancesVolume.item;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import jedrzejbronislaw.propcalc.model.Solution;

public class SubstancesVolumeTotal extends SubstancesVolumeItem {

	private static final String NAME_LABEL = "TOTAL:";
	
	private final List<Solution> solutions = new ArrayList<>();
	
	
	public SubstancesVolumeTotal() {
		super(null);
	}
	
	public void addSolution(Solution solution) {
		solutions.add(solution);
		solution.addChangeListener(this::update);
	}
	
	private void update() {
		double volume = 0, mass = 0, number = 0;
		
		for(Solution solution : solutions) {
			volume += solution.getVolume();
			mass   += solution.massOfSubstance();
			number += solution.numberOfMolecules();
		}
		
		displayVolume(volume);
		displayMassOfSubstance(mass);
		displayNumOfMolecules(number);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nameLabel.setText(NAME_LABEL);
		
		volumeField.textProperty().addListener((o, oldV, newV) -> {
			validateVolumeField(newV, oldV);
		});
	}
}
