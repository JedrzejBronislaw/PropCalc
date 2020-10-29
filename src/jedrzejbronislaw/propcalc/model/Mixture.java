package jedrzejbronislaw.propcalc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Mixture {

	private List<Solution> solutions = new ArrayList<>();
	private List<Consumer<Solution>> addListeners = new ArrayList<>();
	
	
	public void addSolution(Solution solution) {
		solutions.add(solution);
		callAddListeners(solution);
	}


	public void addAddListener(Consumer<Solution> listener) {
		addListeners.add(listener);
	}
	
	private void callAddListeners(Solution newSolution) {
		addListeners.forEach(l ->  l.accept(newSolution));
	}
}
