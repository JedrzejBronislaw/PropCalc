package jedrzejbronislaw.propcalc.components;

import java.util.ArrayList;
import java.util.List;

import jedrzejbronislaw.propcalc.substances.Substance;

public class SelectedSubstances {

	private List<Substance> substances = new ArrayList<>();
	private List<Runnable> addListeners = new ArrayList<>();
	
	
	public void add(Substance substance) {
		substances.add(substance);
		callAddListeners();
	}

	public void addAddListener(Runnable listener) {
		addListeners.add(listener);
	}
	
	private void callAddListeners() {
		addListeners.forEach(l ->  l.run());
	}
}
