package jedrzejbronislaw.propcalc.view.moleculesUnit.substancesVolume.item;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import jedrzejbronislaw.propcalc.lang.Internationalization;
import jedrzejbronislaw.propcalc.model.molecules.Solution;
import jedrzejbronislaw.propcalc.tools.Injection;
import lombok.Setter;

public class SubstancesVolumeTotal extends SubstancesVolumeItem {
	
	private final List<Solution> solutions = new ArrayList<>();
	@Setter
	private Consumer<Double> onVolumeChange;
	
	
	public SubstancesVolumeTotal() {
		super(null);
	}
	
	public void addSolution(Solution solution) {
		solutions.add(solution);
		solution.addChangeListener(this::update);
		update();
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
		setToolTips();
		nameLabel.setText(Internationalization.get("total_"));
		
		volumeField.textProperty().addListener((o, oldV, newV) -> {
			if (internalChange) return;
			
			if (isNewVolumeValue(newV, oldV))
				Injection.run(onVolumeChange, getDoubleVolume());
		});
	}
}
