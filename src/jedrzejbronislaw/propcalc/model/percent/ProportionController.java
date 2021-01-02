package jedrzejbronislaw.propcalc.model.percent;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProportionController {
	
	private boolean updating = false;
	
	private final List<Item> items;

	
	public void update() {
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

	private double totalMass() {
		return items.stream().mapToDouble(i -> i.getMass()).sum();
	}
	
	private int totalProportion() {
		return items.stream().mapToInt(item -> item.getProportion()).sum();
	}
}
