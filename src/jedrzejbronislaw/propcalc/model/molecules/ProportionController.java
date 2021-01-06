package jedrzejbronislaw.propcalc.model.molecules;

import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProportionController {
	
	private boolean updating = false;
	
	@NonNull private final List<Solution> solutions;
	
	
	public void updateVolumes() {
		if (updating) return;
		
		updateVolumes(volumeSum());
	}
	
	public void updateVolumes(double totalVolume) {
		if (totalVolume < 0) throw new IllegalArgumentException("Volume cannot be negative (" + totalVolume + " < 0).");
		if (updating) return;
		
		double proportionVolumesSum = proportionVolumesSum();
		if (proportionVolumesSum == 0) return;
		
		updating = true;
		
		for (Solution solution : solutions) {
			if (solution.getSubstance() == null) continue;
			
			solution.setVolume(solution.proportionOfVolume() / proportionVolumesSum * totalVolume);
		}
		
		updating = false;
	}

	public void updateVolumes(Solution changedSolution) {
		if (updating) return;
		if (changedSolution.getSubstance() == null) return;
		
		double xB = changedSolution.getProportion() * changedSolution.getSubstance().getMolarMass();
		if (xB == 0) return;
		
		updating = true;
		
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
