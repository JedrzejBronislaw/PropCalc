package jedrzejbronislaw.propcalc.model.percent;

import java.util.ArrayList;
import java.util.List;

public class Calc {
	private static final int PERCENT_PRECISION = 1000000;

	private List<Item> items = new ArrayList<>();
	
	private ProportionController propCrtl = new ProportionController(items);

	public void addItem(Item item) {
		item.addChangeMassListener(propCrtl::updateProportion);
		item.addChangeProportionListener(propCrtl::updateMass);
		
		items.add(item);
		propCrtl.updateMass();
	}
	
	public void setPercent(Item item, double percent) {
		if (!items.contains(item)) throw new IllegalArgumentException("Item is not added.");
		if (percent < 0) throw new IllegalArgumentException("Percent cannot be negative (" + percent + " < 0).");
		if (items.size() < 2) throw new IllegalStateException("There is only one item.");
		
		if (items.size() == 2)
			setPercent_twoItems(item, percent); else
			setPercent_moreItems(item, percent);
		
		propCrtl.updateMass();
	}

	private void setPercent_twoItems(Item item, double percent) {
		Item secondItem = (items.get(0) == item) ? items.get(1) : items.get(0);
		
		int a = (int)(       percent  * PERCENT_PRECISION);
		int b = (int)((100 - percent) * PERCENT_PRECISION);
		
		item.      setProportion(a);
		secondItem.setProportion(b);
		
		propCrtl.reduceProportion();
	}

	private void setPercent_moreItems(Item item, double percent) {
		double newProportionRatio = (100 - percent) / (totalProportion() - item.getProportion());
		
		items.forEach(i -> {
			int newProportion = (int)(i.getProportion() * newProportionRatio * PERCENT_PRECISION);
			i.setProportion(newProportion);
		});
		item.setProportion((int) (percent * PERCENT_PRECISION));
		
		propCrtl.reduceProportion();
	}
	
	public double getPercent(Item item) {
		if (!items.contains(item)) throw new IllegalArgumentException("Item is not added.");
		
		if (totalProportion() == 0) return 0;
		return 100.0 * item.getProportion() / totalProportion();
	}
	
	public double totalMass() {
		return items.stream().mapToDouble(item -> item.getMass()).sum();
	}
	
	public int totalProportion() {
		return items.stream().mapToInt(item -> item.getProportion()).sum();
	}
}
