package jedrzejbronislaw.propcalc.model;

import java.util.ArrayList;
import java.util.List;

import jedrzejbronislaw.propcalc.substances.Substance;
import lombok.Getter;

@Getter
public class Solution {
	
	private Substance substance;
	private double concentration = 1;
	private int proportion;
	
	private double volume;
	
	private List<Runnable> changeListeners = new ArrayList<>();
	
	
	public double massOfSubstance() {
		return volume * concentration;
	};
	
	public double numberOfMolecules() {
		if (substance == null) return 0;
		
		return massOfSubstance() / substance.getMolarMass() * Consts.AVOGADRO;
	};
	
	
	//setters
	
	public void setSubstance(Substance substance) {
		this.substance = substance;
		callChangeListeners();
	}
	
	public void setConcentration(double concentration) {
		this.concentration = concentration;
		callChangeListeners();
	}
	
	public void setProportion(int proportion) {
		this.proportion = proportion;
		callChangeListeners();
	}
	
	public void setVolume(double volume) {
		this.volume = volume;
		callChangeListeners();
	}
	
	
	//listeners
	
	public void addChangeListener(Runnable listener) {
		changeListeners.add(listener);
	}
	
	private void callChangeListeners() {
		changeListeners.forEach(l ->  l.run());
	}
}
