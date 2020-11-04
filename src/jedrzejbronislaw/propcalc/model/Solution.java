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
	private List<Runnable> changeSubstanceListeners = new ArrayList<>();
	private List<Runnable> changeConcentrationListeners = new ArrayList<>();
	private List<Runnable> changeProportionListeners = new ArrayList<>();
	private List<Runnable> changeVolumeListeners = new ArrayList<>();
	
	
	public double massOfSubstance() {
		return volume * concentration;
	}
	
	public double numberOfMolecules() {
		if (substance == null) return 0;
		
		return massOfSubstance() / molarMassInMgPerMol() * Consts.AVOGADRO;
	}

	private double molarMassInMgPerMol() {
		return substance.getMolarMass() * 1000.0;
	}
	
	public double proportionOfVolume() {
		if (substance == null) return 0;
		
		return proportion * substance.getMolarMass() / concentration;
	}
	
	//setters
	
	public void setSubstance(Substance substance) {
		this.substance = substance;
		callChangeSubstanceListeners();
		callChangeListeners();
	}
	
	public void setConcentration(double concentration) {
		this.concentration = concentration;
		callChangeConcentrationListeners();
		callChangeListeners();
	}
	
	public void setProportion(int proportion) {
		this.proportion = proportion;
		callChangeProportionListeners();
		callChangeListeners();
	}
	
	public void setVolume(double volume) {
		this.volume = volume;
		callChangeVolumeListeners();
		callChangeListeners();
	}
	
	
	public void setVolumeForNumOfMolecules(double numOfMolecules) {
		if (substance == null) setVolume(0);
		
		double volume = (numOfMolecules * substance.getMolarMass()) / (concentration * Consts.AVOGADRO);
		setVolume(volume);
	}
	
	
	//listeners
	
	public void addChangeListener(Runnable listener) {
		changeListeners.add(listener);
	}
	private void callChangeListeners() {
		changeListeners.forEach(l ->  l.run());
	}
	
	public void addChangeSubstanceListener(Runnable listener) {
		changeSubstanceListeners.add(listener);
	}
	private void callChangeSubstanceListeners() {
		changeSubstanceListeners.forEach(l ->  l.run());
	}
	
	public void addChangeConcentrationListener(Runnable listener) {
		changeConcentrationListeners.add(listener);
	}
	private void callChangeConcentrationListeners() {
		changeConcentrationListeners.forEach(l ->  l.run());
	}
	
	public void addChangeProportionListener(Runnable listener) {
		changeProportionListeners.add(listener);
	}
	private void callChangeProportionListeners() {
		changeProportionListeners.forEach(l ->  l.run());
	}
	
	public void addChangeVolumeListener(Runnable listener) {
		changeVolumeListeners.add(listener);
	}
	private void callChangeVolumeListeners() {
		changeVolumeListeners.forEach(l ->  l.run());
	}
}
