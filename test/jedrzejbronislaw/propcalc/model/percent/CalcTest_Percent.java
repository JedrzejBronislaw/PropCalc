package jedrzejbronislaw.propcalc.model.percent;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest_Percent {
	
	private Calc calc = new Calc();
	
	//percent

	@Test(expected = IllegalStateException.class)
	public void setPercent_onlyOneItem() {
		Item item = new Item();
		calc.addItem(item);
		
		calc.setPercent(item, 5);
	}

	@Test
	public void setPercent() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item1, 5);
		
		assertEquals(5,  calc.getPercent(item1), 0.000001);
		assertEquals(95, calc.getPercent(item2), 0.000001);

		assertEquals(1,  item1.getProportion());
		assertEquals(19, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setPercent_0() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item1, 0);
		
		assertEquals(0,   calc.getPercent(item1), 0.000001);
		assertEquals(100, calc.getPercent(item2), 0.000001);
		
		assertEquals(0, item1.getProportion());
		assertEquals(1, item2.getProportion());
	}

	@Test
	public void setPercent_100() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item1, 100);
		
		assertEquals(100,   calc.getPercent(item1), 0.000001);
		assertEquals(0, calc.getPercent(item2), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(0, item2.getProportion());
	}

	@Test(expected = IllegalArgumentException.class)
	public void setPercent_negative() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item1, -3);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void setPercent_wrongItem() {
		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item3, 3);
	}
	
	////

	@Test
	public void setPercent_withMassAndProportion() {
		Item item1 = new Item();
		Item item2 = new Item();

		item1.setMass(100);
		item1.setProportion(1);
		item2.setMass(100);
		item2.setProportion(1);
		
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item1, 5);
		
		assertEquals(5,  calc.getPercent(item1), 0.000001);
		assertEquals(95, calc.getPercent(item2), 0.000001);
		
		assertEquals(1,  item1.getProportion());
		assertEquals(19, item2.getProportion());
		
		assertEquals(10,  item1.getMass(), 0.000001);
		assertEquals(190, item2.getMass(), 0.000001);
	}
	
	////

	@Test
	public void setPercent_2items_0to5_secondItem0() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item1, 5);
		
		assertEquals(5,  calc.getPercent(item1), 0.000001);
		assertEquals(95, calc.getPercent(item2), 0.000001);

		assertEquals(1,  item1.getProportion());
		assertEquals(19, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setPercent_2items_100to5_secondItem0() {
		Item item1 = new Item(0,   1);
		Item item2 = new Item(200, 0);
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item1, 5);
		
		assertEquals(5,  calc.getPercent(item1), 0.000001);
		assertEquals(95, calc.getPercent(item2), 0.000001);

		assertEquals(1,  item1.getProportion());
		assertEquals(19, item2.getProportion());
		
		assertEquals(10,  item1.getMass(), 0.000001);
		assertEquals(190, item2.getMass(), 0.000001);
	}

	@Test
	public void setPercent_2items_50to5_secondItem50() {
		Item item1 = new Item(0, 1);
		Item item2 = new Item(0, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item1, 5);
		
		assertEquals(5,  calc.getPercent(item1), 0.000001);
		assertEquals(95, calc.getPercent(item2), 0.000001);

		assertEquals(1,  item1.getProportion());
		assertEquals(19, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setPercent_3items_0to10_secondItem0_ThridItem0() {
		Item item1 = new Item(0, 0);
		Item item2 = new Item(0, 0);
		Item item3 = new Item(0, 0);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		calc.setPercent(item1, 10);
		
		assertEquals(100, calc.getPercent(item1), 0.000001);
		assertEquals(0, calc.getPercent(item2), 0.000001);
		assertEquals(0, calc.getPercent(item3), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(0, item2.getProportion());
		assertEquals(0, item3.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
		assertEquals(0, item3.getMass(), 0.000001);
	}

	@Test
	public void setPercent_3items_50to10_secondItem50_ThridItem0() {
		Item item1 = new Item(0, 1);
		Item item2 = new Item(0, 1);
		Item item3 = new Item(0, 0);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		calc.setPercent(item1, 10);
		
		assertEquals(10, calc.getPercent(item1), 0.000001);
		assertEquals(90, calc.getPercent(item2), 0.000001);
		assertEquals(0,  calc.getPercent(item3), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(9, item2.getProportion());
		assertEquals(0, item3.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
		assertEquals(0, item3.getMass(), 0.000001);
	}

	@Test
	public void setPercent_3items_0to10_secondItem50_ThridItem50() {
		Item item1 = new Item(0, 0);
		Item item2 = new Item(0, 1);
		Item item3 = new Item(0, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		calc.setPercent(item1, 10);
		
		assertEquals(10, calc.getPercent(item1), 0.000001);
		assertEquals(45, calc.getPercent(item2), 0.000001);
		assertEquals(45, calc.getPercent(item3), 0.000001);

		assertEquals(2, item1.getProportion());
		assertEquals(9, item2.getProportion());
		assertEquals(9, item3.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
		assertEquals(0, item3.getMass(), 0.000001);
	}

	@Test
	public void setPercent_3items_0to10_secondItem50_ThridItem50_withMass() {
		Item item1 = new Item(0,   0);
		Item item2 = new Item(100, 1);
		Item item3 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		calc.setPercent(item1, 10);
		
		assertEquals(10, calc.getPercent(item1), 0.000001);
		assertEquals(45, calc.getPercent(item2), 0.000001);
		assertEquals(45, calc.getPercent(item3), 0.000001);

		assertEquals(2, item1.getProportion());
		assertEquals(9, item2.getProportion());
		assertEquals(9, item3.getProportion());
		
		assertEquals(20, item1.getMass(), 0.000001);
		assertEquals(90, item2.getMass(), 0.000001);
		assertEquals(90, item3.getMass(), 0.000001);
	}

	@Test
	public void setPercent_3items_0to10_secondItem33_ThridItem66() {
		Item item1 = new Item(0,   0);
		Item item2 = new Item(100, 1);
		Item item3 = new Item(200, 2);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		calc.setPercent(item1, 10);
		
		assertEquals(10, calc.getPercent(item1), 0.000001);
		assertEquals(30, calc.getPercent(item2), 0.000001);
		assertEquals(60, calc.getPercent(item3), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(3, item2.getProportion());
		assertEquals(6, item3.getProportion());
		
		assertEquals(30,  item1.getMass(), 0.000001);
		assertEquals(90,  item2.getMass(), 0.000001);
		assertEquals(180, item3.getMass(), 0.000001);
	}
	
}
