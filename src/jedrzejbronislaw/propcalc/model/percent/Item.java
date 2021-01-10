package jedrzejbronislaw.propcalc.model.percent;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
public class Item {

	@NonNull
	private String name = "";
	private double mass;
	private long   proportion;


	private List<Runnable> changeListeners = new ArrayList<>();
	private List<Runnable> changeMassListeners = new ArrayList<>();
	private List<Runnable> changeProportionListeners = new ArrayList<>();
	
	public void addChangeListener(Runnable listener) {
		changeListeners.add(listener);
	}

	public void addChangeMassListener(Runnable listener) {
		changeMassListeners.add(listener);
	}

	public void addChangeProportionListener(Runnable listener) {
		changeProportionListeners.add(listener);
	}


	public Item(String name, double mass, int proportion) {
		setName(name);
		setMass(mass);
		setProportion(proportion);
	}
	
	public Item(double mass, int proportion) {
		setMass(mass);
		setProportion(proportion);
	}
	
	
	public void setMass(double mass) {
		if (mass < 0) throw new IllegalArgumentException("Mass cannot be negative (" + mass + " < 0).");
		
		this.mass = mass;
		changeMassListeners.forEach(l -> l.run());
		changeListeners.forEach(l -> l.run());
	}
	
	public void setProportion(long proportion) {
		if (proportion < 0) throw new IllegalArgumentException("Proportion cannot be negative (" + proportion + " < 0).");
		
		this.proportion = proportion;
		changeProportionListeners.forEach(l -> l.run());
		changeListeners.forEach(l -> l.run());
	}

	public void setName(String name) {
		this.name = (name == null) ? "" : name;
	}
}
