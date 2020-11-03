package jedrzejbronislaw.propcalc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Mixture {
	
	private boolean updating = false;

	private List<Solution> solutions = new ArrayList<>();
	private List<Consumer<Solution>> addListeners = new ArrayList<>();
	
	
	public void addSolution(Solution solution) {
		solution.addChangeSubstanceListener(this::updateVolumes);
		solution.addChangeProportionListener(this::updateVolumes);
		solution.addChangeVolumeListener(() -> updateVolumes(solution));
		solutions.add(solution);
		callAddListeners(solution);
	}


	public void addAddListener(Consumer<Solution> listener) {
		addListeners.add(listener);
	}
	
	private void callAddListeners(Solution newSolution) {
		addListeners.forEach(l ->  l.accept(newSolution));
	}
	
	private void updateVolumes() {
		if (updating) return;
		
		updating = true;
		
		double volumeSum = volumeSum();
		double proportionVolumesSum = proportionVolumesSum();
		
		for (Solution solution : solutions) {
			if (solution.getSubstance() == null) continue;
			
			solution.setVolume(solution.proportionOfVolume() / proportionVolumesSum * volumeSum);
		}
		
		updating = false;
	}


	private void updateVolumes(Solution changedSolution) {
		if (updating) return;
		if (changedSolution.getSubstance() == null) return;
		
		updating = true;
		
		double xB = changedSolution.getProportion() * changedSolution.getSubstance().getMolarMass();
		
		for (Solution solution : solutions) {
			if (solution == changedSolution) continue;
			if (solution.getSubstance() == null) continue;
			
			double xA =  solution.getProportion() * solution.getSubstance().getMolarMass();
			
			solution.setVolume(xA / xB * changedSolution.getVolume());
		}
		
		updating = false;
	}


	private double proportionVolumesSum() {
		double sum = 0;
		
		for(Solution solution : solutions)
			if (solution.getSubstance() != null)
				sum += solution.proportionOfVolume();
		
		return sum;
	}
	
	private double volumeSum() {
		double sum = 0;
		
		for(Solution solution : solutions)
			if (solution.getSubstance() != null)
				sum += solution.getVolume();
		
		return sum;
	}
}
