package jedrzejbronislaw.propcalc.model.percent;

import java.util.List;

import jedrzejbronislaw.propcalc.tools.GCD;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProportionController {
	private static final int PROPORTION_PRECISION = 1000000;
	
	private boolean updating = false;
	
	private final List<Item> items;

	
	public void updateMass() {
		if (updating) return;

		updating = true;
		
		double totalMass = totalMass();
		int totalProportion = totalProportion();
		
		for(Item item : items)
			if (totalProportion == 0 || totalMass == 0)
				item.setMass(0); else
				item.setMass(totalMass * item.getProportion() / totalProportion);
		
		updating = false;
	}
	
	public void updateProportion() {
		if (updating) return;

		updating = true;
		
		for(Item item : items)
			item.setProportion((int)(item.getMass() * PROPORTION_PRECISION));
		
		reduceProportion();
		
		updating = false;
	}

	private double totalMass() {
		return items.stream().mapToDouble(i -> i.getMass()).sum();
	}
	
	private int totalProportion() {
		return items.stream().mapToInt(item -> item.getProportion()).sum();
	}

	public void reduceProportion() {
		int[] proportions = items.stream().mapToInt(i -> i.getProportion()).toArray();
		int gcd = GCD.gcd(proportions);
		
		items.forEach(i -> i.setProportion(i.getProportion() / gcd));
	}
}
