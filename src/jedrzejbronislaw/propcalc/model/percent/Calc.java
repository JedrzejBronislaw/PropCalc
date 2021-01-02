package jedrzejbronislaw.propcalc.model.percent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Calc {

	private List<Item> items = new ArrayList<>();
	
	private ProportionController propCrtl = new ProportionController(items);

	public void addItem(Item item) {
		items.add(item);
		propCrtl.update();
	}
	
	public void setPercent(Item item, double percent) {
		if (!items.contains(item)) throw new IllegalArgumentException("Item is not added.");
		if (percent < 0) throw new IllegalArgumentException("Percent cannot be negative (" + percent + " < 0).");
		if (items.size() < 2) throw new IllegalStateException("There is only one item.");
		
		if (items.size() == 2) {
			Item secondItem = (items.get(0) == item) ? items.get(1) : items.get(0);
			
			if (percent == 0) {
				item.      setProportion(0);
				secondItem.setProportion(1);
			} else
			if (percent == 100) {
				item.      setProportion(1);
				secondItem.setProportion(0);
			} else {
			
				int x = 1000000;
				
				int a = (int)(percent * 1000000);
				int b = 100 * x - a;
				
				int nwd = nwd(a, b);
				
				item.      setProportion(a / nwd);
				secondItem.setProportion(b / nwd);
				
//				System.out.println("per = " + percent);
//				System.out.println("nwd = " + nwd);
//				System.out.println("a = " + a);
//				System.out.println("b = " + b);
//				System.out.println();
			}
		} else {
			int oldTotalProportionWithout = totalProportionWithout(item);
			double percentageWithout = 100 - percent;
			double percentPerOneProportion = percentageWithout / oldTotalProportionWithout;
			
			int newProp = (int) percent;
			
//			System.out.println("oldTotalProportionWithout = " + oldTotalProportionWithout);
//			System.out.println("proportion100precentage = " + proportion100precentage);
//			System.out.println("newProportion = " + newProportion);
//			System.out.println("newProp = " + newProp);
//			System.out.println();
			
			items.forEach(i -> i.setProportion((int)(i.getProportion() * percentPerOneProportion)));
			item.setProportion(newProp);
			
			
			int[] props = items.stream().mapToInt(i -> i.getProportion()).toArray();
			int nwd = nwd(props);
			items.forEach(i -> i.setProportion(i.getProportion() / nwd));
			
//			items.forEach(i -> System.out.println(i.getProportion()));
//			System.out.println();
		}
		
		propCrtl.update();
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
	
	public int totalProportionWithout(Item item) {
		return totalProportion() - item.getProportion();
	}
	
	private int nwd(int a, int b) {
		
		while(a != b) {
			if (a > b)
				a -= b; else
				b -= a;
		}
		
		return a;
	}
	
	private int nwd(int[] nums) {
//		System.out.println("ndw " + Arrays.toString(nums) + " = ");

		nums = delZero(nums);
		
//		System.out.print("ndw " + Arrays.toString(nums) + " = ");
		
		int[] tab = nums;
		int min;
		
		
		while (tab.length > 1) {
			min = min(tab);
			
			for(int i=0; i<tab.length; i++)
				if (tab[i] != min) tab[i] -= min;
			
			tab = delDuplicate(tab);
		}
		
//		System.out.println(tab[0]);
		
		return tab[0];
	}
	
	private int[] delZero(int[] tab) {
		return IntStream.of(tab).filter(i -> i!=0).toArray();
	}

	private int[] delDuplicate(int[] tab) {
		return IntStream.of(tab).distinct().toArray();
	}

	private int min(int[] tab) {
		return IntStream.of(tab).min().getAsInt();
	}
}
