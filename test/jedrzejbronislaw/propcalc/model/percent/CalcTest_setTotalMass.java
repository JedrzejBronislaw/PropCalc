package jedrzejbronislaw.propcalc.model.percent;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest_setTotalMass {
	
	private Calc calc = new Calc();
	
	//no items
	
	@Test
	public void setTotalMass_noItems() {
		calc.setTotalMass(200);

		assertEquals(0, calc.totalMass(), 0.000001);
	}
	
	//one item
	
	@Test
	public void setTotalMass_oneItem_proportion0() {
		calc.addItem(new Item(100, 0));
		
		calc.setTotalMass(200);

		assertEquals(0, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void setTotalMass_oneItem_proportion1() {
		calc.addItem(new Item(100, 1));
		
		calc.setTotalMass(200);

		assertEquals(200, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void setTotalMass_oneItem_proportion5() {
		calc.addItem(new Item(100, 5));
		
		calc.setTotalMass(200);

		assertEquals(200, calc.totalMass(), 0.000001);
	}
	
	@Test
	public void setTotalMass_0_oneItem() {
		Item item = new Item(100, 1);
		calc.addItem(item);
		
		calc.setTotalMass(0);

		assertEquals(0, calc.totalMass(), 0.000001);
		assertEquals(100, calc.getPercent(item), 0.000001);
		assertEquals(1, item.getProportion());
		assertEquals(0, item.getMass(), 0.000001);
	}

	//two items

	@Test
	public void setTotalMass_100_twoItems_proportion_0_0() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setTotalMass(200);
		
		assertEquals(0, calc.getPercent(item1), 0.000001);
		assertEquals(0, calc.getPercent(item2), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setTotalMass_200_twoItems_proportion_1_1_initMass0() {
		Item item1 = new Item(0, 1);
		Item item2 = new Item(0, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setTotalMass(200);
		
		assertEquals(50, calc.getPercent(item1), 0.000001);
		assertEquals(50, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(100, item1.getMass(), 0.000001);
		assertEquals(100, item2.getMass(), 0.000001);
	}

	@Test
	public void setTotalMass_200_twoItems_proportion_0_1_initMass0() {
		Item item1 = new Item(0, 0);
		Item item2 = new Item(0, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setTotalMass(200);
		
		assertEquals(  0, calc.getPercent(item1), 0.000001);
		assertEquals(100, calc.getPercent(item2), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(  0, item1.getMass(), 0.000001);
		assertEquals(200, item2.getMass(), 0.000001);
	}

	@Test
	public void setTotalMass_900_twoItems_proportion_1_2_initMass() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(200, 2);
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setTotalMass(900);
		
		assertEquals(33.3333333333, calc.getPercent(item1), 0.000001);
		assertEquals(66.6666666666, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(2, item2.getProportion());
		
		assertEquals(300, item1.getMass(), 0.000001);
		assertEquals(600, item2.getMass(), 0.000001);
	}

	@Test
	public void setTotalMass_1000_twoItems_proportion_3_2_initMass() {
		Item item1 = new Item(30, 3);
		Item item2 = new Item(20, 2);
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setTotalMass(1000);
		
		assertEquals(60, calc.getPercent(item1), 0.000001);
		assertEquals(40, calc.getPercent(item2), 0.000001);

		assertEquals(3, item1.getProportion());
		assertEquals(2, item2.getProportion());
		
		assertEquals(600, item1.getMass(), 0.000001);
		assertEquals(400, item2.getMass(), 0.000001);
	}

	@Test
	public void setTotalMass_1000_twoItems_proportion_9_6_noProportionReduction() {
		Item item1 = new Item(30, 9);
		Item item2 = new Item(20, 6);
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setTotalMass(1000);
		
		assertEquals(60, calc.getPercent(item1), 0.000001);
		assertEquals(40, calc.getPercent(item2), 0.000001);

		assertEquals(9, item1.getProportion());
		assertEquals(6, item2.getProportion());
		
		assertEquals(600, item1.getMass(), 0.000001);
		assertEquals(400, item2.getMass(), 0.000001);
	}

	@Test
	public void setTotalMass_0_twoItems_proportion_1_3() {
		Item item1 = new Item(10, 1);
		Item item2 = new Item(30, 3);
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setTotalMass(0);
		
		assertEquals(25, calc.getPercent(item1), 0.000001);
		assertEquals(75, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(3, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setTotalMass_negative_twoItems_proportion_1_3_exception() {
		Item item1 = new Item(10, 1);
		Item item2 = new Item(30, 3);
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setTotalMass(-3);
	}

	@Test
	public void setTotalMass_negative_twoItems_proportion_1_3_noChange() {
		Item item1 = new Item(10, 1);
		Item item2 = new Item(30, 3);
		calc.addItem(item1);
		calc.addItem(item2);
		
		try {
			calc.setTotalMass(-3);
		} catch(IllegalArgumentException e) {}
		
		assertEquals(25, calc.getPercent(item1), 0.000001);
		assertEquals(75, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(3, item2.getProportion());
		
		assertEquals(10, item1.getMass(), 0.000001);
		assertEquals(30, item2.getMass(), 0.000001);
	}

	//three items

	@Test
	public void setTotalMass_1100_threeItems_proportion_3_2_2() {
		Item item1 = new Item(30, 3);
		Item item2 = new Item(20, 2);
		Item item3 = new Item(50, 5);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		calc.setTotalMass(1100);
		
		assertEquals(30, calc.getPercent(item1), 0.000001);
		assertEquals(20, calc.getPercent(item2), 0.000001);
		assertEquals(50, calc.getPercent(item3), 0.000001);

		assertEquals(3, item1.getProportion());
		assertEquals(2, item2.getProportion());
		assertEquals(5, item3.getProportion());
		
		assertEquals(330, item1.getMass(), 0.000001);
		assertEquals(220, item2.getMass(), 0.000001);
		assertEquals(550, item3.getMass(), 0.000001);
	}

	@Test
	public void setTotalMass_1000_threeItems_proportion_1_1_1() {
		Item item1 = new Item(10, 1);
		Item item2 = new Item(10, 1);
		Item item3 = new Item(10, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		calc.setTotalMass(1000);
		
		assertEquals(33.3333333333, calc.getPercent(item1), 0.000001);
		assertEquals(33.3333333333, calc.getPercent(item2), 0.000001);
		assertEquals(33.3333333333, calc.getPercent(item3), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		assertEquals(1, item3.getProportion());
		
		assertEquals(333.3333333333, item1.getMass(), 0.000001);
		assertEquals(333.3333333333, item2.getMass(), 0.000001);
		assertEquals(333.3333333333, item3.getMass(), 0.000001);
	}
}
