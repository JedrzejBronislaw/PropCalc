package jedrzejbronislaw.propcalc.model;

import java.util.ArrayList;
import java.util.List;

public class Mixture {

	private List<Solution> solutions = new ArrayList<>();
	private List<Runnable> addListeners = new ArrayList<>();
	
	
	public void addSolution(Solution solution) {
		solutions.add(solution);
		callAddListeners();
	}


	public void addAddListener(Runnable listener) {
		addListeners.add(listener);
	}
	
	private void callAddListeners() {
		addListeners.forEach(l ->  l.run());
	}
}
