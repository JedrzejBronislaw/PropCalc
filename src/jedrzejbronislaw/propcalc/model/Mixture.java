package jedrzejbronislaw.propcalc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Mixture {
	
	private List<Solution> solutions = new ArrayList<>();
	private List<Consumer<Solution>> addListeners = new ArrayList<>();
	
	private ProportionController propCtrl = new ProportionController(solutions);
	
	
	public void addSolution(Solution solution) {
		solution.addChangeSubstanceListener(   propCtrl::updateVolumes);
		solution.addChangeProportionListener(  propCtrl::updateVolumes);
		solution.addChangeVolumeListener(() -> propCtrl .updateVolumes(solution));
		solutions.add(solution);
		callAddListeners(solution);
	}


	public void addAddListener(Consumer<Solution> listener) {
		addListeners.add(listener);
	}
	
	private void callAddListeners(Solution newSolution) {
		addListeners.forEach(l ->  l.accept(newSolution));
	}
	
	
	public void setVolume(double volume) {
		propCtrl.updateVolumes(volume);
	}
}
