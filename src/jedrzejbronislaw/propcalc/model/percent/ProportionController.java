package jedrzejbronislaw.propcalc.model.percent;

import java.util.List;

import jedrzejbronislaw.propcalc.tools.GCD;
import jedrzejbronislaw.propcalc.tools.Injection;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProportionController {
	private static final int PROPORTION_PRECISION = 1000000;
	
	private boolean updating = false;
	
	private final List<Item> items;

	
	public void updateMasses() {
		updateMasses(totalMass());
	}

	public void updateMasses(double totalMass) {
		update(() -> {
			
			long totalProportion = totalProportion();
			
			for(Item item : items)
				if (totalProportion == 0 || totalMass == 0)
					item.setMass(0); else
					item.setMass(totalMass * item.getProportion() / totalProportion);

		});
	}

	public void updateMass(Item item) {
		update(() -> {
			
			if (items.size() == 1) {
				if (item.getProportion() == 0) item.setMass(0);
				return;
			}
			
			long proportion = totalProportion() - item.getProportion();
			double mass     = totalMass()       - item.getMass();
			
			double massFactor = (proportion == 0) ? 0 : mass / proportion;

			item.setMass(item.getProportion() * massFactor);

		});
	}

	public void updateMassesExcept(Item lockItem) {
		update(() -> {
			
			long lockProportion = lockItem.getProportion();
			double lockMass = lockItem.getMass();
			
			double massFactor = (lockProportion == 0) ? 0 : lockMass / lockProportion;
			
			for(Item item : items)
				item.setMass(item.getProportion() * massFactor);

		});
	}
	
	public void updateProportion() {
		update(() -> {
			
			for(Item item : items)
				item.setProportion(Math.round(item.getMass() * PROPORTION_PRECISION));
			
			reduceProportion();
		});
	}

	private double totalMass() {
		return items.stream().mapToDouble(i -> i.getMass()).sum();
	}
	
	private long totalProportion() {
		return items.stream().mapToLong(item -> item.getProportion()).sum();
	}

	public void reduceProportion() {
		long[] proportions = items.stream().mapToLong(i -> i.getProportion()).toArray();
		long gcd = GCD.gcd(proportions);
		
		items.forEach(i -> i.setProportion(i.getProportion() / gcd));
	}
	
	private void update(Runnable update) {
		if (updating) return;
		updating = true;
		
		Injection.run(update);
		
		updating = false;
	}
}
