package jedrzejbronislaw.propcalc.model.percent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jedrzejbronislaw.propcalc.model.percent.CalcOptions.ChangeProportionAction;

public class CalcTest_Percent_ChangeAllMasses {
	
	private Calc calc = new Calc();

	@Before
	public void prepare() {
		calc.getOptions().setChangeProportionAction(ChangeProportionAction.CHANGE_ALL_MASSES);
	}
	
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
	
	//real percentage

	@Test
	public void setPercent_2items_5_5() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item1, 5.5);
		
		assertEquals( 5.5, calc.getPercent(item1), 0.000001);
		assertEquals(94.5, calc.getPercent(item2), 0.000001);

		assertEquals( 11, item1.getProportion());
		assertEquals(189, item2.getProportion());
	}

	@Test
	public void setPercent_2items_33_3333333333() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item1, 100.0/3);
		
		assertEquals(33.3333333333, calc.getPercent(item1), 0.000001);
		assertEquals(66.6666666666, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(2, item2.getProportion());
	}

	@Test
	public void setPercent_3items_5_5() {
		Item item1 = new Item(0, 0);
		Item item2 = new Item(0, 1);
		Item item3 = new Item(0, 2);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		calc.setPercent(item1, 5.5);
		
		assertEquals( 5.5, calc.getPercent(item1), 0.000001);
		assertEquals(31.5, calc.getPercent(item2), 0.000001);
		assertEquals(63,   calc.getPercent(item3), 0.000001);

		assertEquals( 11, item1.getProportion());
		assertEquals( 63, item2.getProportion());
		assertEquals(126, item3.getProportion());
	}

	@Test
	public void setPercent_3items_33_3333333333() {
		Item item1 = new Item(0, 0);
		Item item2 = new Item(0, 1);
		Item item3 = new Item(0, 2);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		calc.setPercent(item1, 100.0/3);
		
		assertEquals(33.3333333333, calc.getPercent(item1), 0.000001);
		assertEquals(22.2222222222, calc.getPercent(item2), 0.000001);
		assertEquals(44.4444444444, calc.getPercent(item3), 0.000001);

		assertEquals(3, item1.getProportion());
		assertEquals(2, item2.getProportion());
		assertEquals(4, item3.getProportion());
	}
}
