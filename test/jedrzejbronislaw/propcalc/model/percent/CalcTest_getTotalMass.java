package jedrzejbronislaw.propcalc.model.percent;

import static org.junit.Assert.*;

import org.junit.Test;

import jedrzejbronislaw.propcalc.model.percent.CalcOptions.ChangeMassAction;

public class CalcTest_getTotalMass {
	
	private Calc calc = new Calc();
	
	//init total mass

	@Test
	public void getTotalMass_init() {
		assertEquals(0, calc.totalMass(), 0.000001);
	}
	
	//one item
	
	@Test
	public void getTotalMass_oneItem_proportion0() {
		calc.addItem(new Item(100, 0));
		
		assertEquals(0, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void getTotalMass_oneItem_proportion1() {
		calc.addItem(new Item(100, 1));
		
		assertEquals(100, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void getTotalMass_oneItem_proportion5() {
		calc.addItem(new Item(100, 5));
		
		assertEquals(100, calc.totalMass(), 0.000001);
	}
	
	//two items
	
	@Test
	public void getTotalMass_twoItems_init() {
		calc.addItem(new Item());
		calc.addItem(new Item());

		assertEquals(0, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void getTotalMass_twoItems() {
		calc.addItem(new Item(100, 1));
		calc.addItem(new Item(100, 1));

		assertEquals(200, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void getTotalMass_twoItems_changeMass1() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(200, 2);
		calc.getOptions().setChangeMassAction(ChangeMassAction.CHANGE_PROPORTIONS);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setMass(10);

		assertEquals(210, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void getTotalMass_twoItems_changeMass2() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(200, 2);
		calc.getOptions().setChangeMassAction(ChangeMassAction.CHANGE_OTHER_MASSES);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setMass(10);

		assertEquals(30, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void getTotalMass_twoItems_changeProportion() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(2);

		assertEquals(200, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void getTotalMass_twoItems_changeProportion0() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(0);

		assertEquals(200, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void getTotalMass_threeItems() {
		calc.addItem(new Item(100, 1));
		calc.addItem(new Item(100, 1));
		calc.addItem(new Item(100, 1));

		assertEquals(300, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void getTotalMass_fiveItems() {
		calc.addItem(new Item(100, 1));
		calc.addItem(new Item( 30, 1));
		calc.addItem(new Item( 50, 1));
		calc.addItem(new Item( 20, 1));
		calc.addItem(new Item( 70, 1));

		assertEquals(270, calc.totalMass(), 0.000001);
	}
}
