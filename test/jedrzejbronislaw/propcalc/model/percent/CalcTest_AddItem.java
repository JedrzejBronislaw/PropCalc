package jedrzejbronislaw.propcalc.model.percent;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest_AddItem {
	
	private Calc calc = new Calc();
	


	
	@Test
	public void first_withMassAndProportion() {
		Item item1 = new Item(10, 2);
		
		calc.addItem(item1);
		
		assertEquals(100, calc.getPercent(item1), 0.000001);
		assertEquals(2,   item1.getProportion());
		assertEquals(10,  item1.getMass(), 0.000001);
	}

	@Test
	public void second_theSame_withMassAndProportion() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);

		calc.addItem(item1);
		calc.addItem(item2);
		
		assertEquals(50, calc.getPercent(item1), 0.000001);
		assertEquals(50, calc.getPercent(item2), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(100, item1.getMass(), 0.000001);
		assertEquals(100, item2.getMass(), 0.000001);
	}

	@Test
	public void thrid_theSame_withMassAndProportion() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		Item item3 = new Item(100, 1);

		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		assertEquals(33.33333333, calc.getPercent(item1), 0.000001);
		assertEquals(33.33333333, calc.getPercent(item2), 0.000001);
		assertEquals(33.33333333, calc.getPercent(item3), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		assertEquals(1, item3.getProportion());
		
		assertEquals(100, item1.getMass(), 0.000001);
		assertEquals(100, item2.getMass(), 0.000001);
		assertEquals(100, item3.getMass(), 0.000001);
	}
	
	

	@Test
	public void thrid_other_withMassAndProportion() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		Item item3 = new Item(200, 2);

		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		assertEquals(25, calc.getPercent(item1), 0.000001);
		assertEquals(25, calc.getPercent(item2), 0.000001);
		assertEquals(50, calc.getPercent(item3), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		assertEquals(2, item3.getProportion());
		
		assertEquals(100, item1.getMass(), 0.000001);
		assertEquals(100, item2.getMass(), 0.000001);
		assertEquals(200, item3.getMass(), 0.000001);
	}

	@Test
	public void thrid_other_withMassAndProportion_disproportionate() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		Item item3 = new Item(800, 2);

		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		assertEquals(25, calc.getPercent(item1), 0.000001);
		assertEquals(25, calc.getPercent(item2), 0.000001);
		assertEquals(50, calc.getPercent(item3), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		assertEquals(2, item3.getProportion());
		
		assertEquals(250, item1.getMass(), 0.000001);
		assertEquals(250, item2.getMass(), 0.000001);
		assertEquals(500, item3.getMass(), 0.000001);
	}

	//////////////////////////////////
	
	@Test
	public void first_withoutMass() {
		Item item1 = new Item(0, 2);
		
		calc.addItem(item1);
		
		assertEquals(100, calc.getPercent(item1), 0.000001);
		assertEquals(2,   item1.getProportion());
		assertEquals(0,   item1.getMass(), 0.000001);
	}

	@Test
	public void first_withoutProportion() {
		Item item1 = new Item(10, 0);
		
		calc.addItem(item1);
		
		assertEquals(0, calc.getPercent(item1), 0.000001);
		assertEquals(0, item1.getProportion());
		assertEquals(0, item1.getMass(), 0.000001);
	}

	@Test
	public void first_withoutMassAndProportion() {
		Item item1 = new Item(0, 0);
		
		calc.addItem(item1);
		
		assertEquals(0, calc.getPercent(item1), 0.000001);
		assertEquals(0, item1.getProportion());
		assertEquals(0, item1.getMass(), 0.000001);
	}


	
	@Test
	public void second_withoutMass() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(0, 1);

		calc.addItem(item1);
		calc.addItem(item2);
		
		assertEquals(50, calc.getPercent(item1), 0.000001);
		assertEquals(50, calc.getPercent(item2), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(50, item1.getMass(), 0.000001);
		assertEquals(50, item2.getMass(), 0.000001);
	}
	
	@Test
	public void second_withoutProportion() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 0);

		calc.addItem(item1);
		calc.addItem(item2);
		
		assertEquals(100, calc.getPercent(item1), 0.000001);
		assertEquals(0,   calc.getPercent(item2), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(200, item1.getMass(), 0.000001);
		assertEquals(0,   item2.getMass(), 0.000001);
	}
	
	@Test
	public void second_withoutMassAndProportion() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(0, 0);

		calc.addItem(item1);
		calc.addItem(item2);
		
		assertEquals(100, calc.getPercent(item1), 0.000001);
		assertEquals(0,   calc.getPercent(item2), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(100, item1.getMass(), 0.000001);
		assertEquals(0,   item2.getMass(), 0.000001);
	}


	
	@Test
	public void second_before0Proportion_withMassAndProportion() {
		Item item1 = new Item(0, 0);
		Item item2 = new Item(100, 1);

		calc.addItem(item1);
		calc.addItem(item2);
		
		assertEquals(0,   calc.getPercent(item1), 0.000001);
		assertEquals(100, calc.getPercent(item2), 0.000001);
		
		assertEquals(0, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(0,   item1.getMass(), 0.000001);
		assertEquals(100, item2.getMass(), 0.000001);
	}
	
	@Test
	public void second_before0Proportion_withoutMass() {
		Item item1 = new Item(0, 0);
		Item item2 = new Item(0, 1);

		calc.addItem(item1);
		calc.addItem(item2);
		
		assertEquals(0,   calc.getPercent(item1), 0.000001);
		assertEquals(100, calc.getPercent(item2), 0.000001);
		
		assertEquals(0, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}
	
	@Test
	public void second_before0Proportion_withoutProportion() {
		Item item1 = new Item(0,   0);
		Item item2 = new Item(100, 0);

		calc.addItem(item1);
		calc.addItem(item2);
		
		assertEquals(0, calc.getPercent(item1), 0.000001);
		assertEquals(0, calc.getPercent(item2), 0.000001);
		
		assertEquals(0, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}
	
	@Test
	public void second_before0Proportion_withoutMassAndProportion() {
		Item item1 = new Item(0, 0);
		Item item2 = new Item(0, 0);

		calc.addItem(item1);
		calc.addItem(item2);
		
		assertEquals(0, calc.getPercent(item1), 0.000001);
		assertEquals(0, calc.getPercent(item2), 0.000001);
		
		assertEquals(0, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}


	
	@Test
	public void second_before0Mass_withoutMass() {
		Item item1 = new Item(0, 1);
		Item item2 = new Item(0, 1);

		calc.addItem(item1);
		calc.addItem(item2);
		
		assertEquals(50, calc.getPercent(item1), 0.000001);
		assertEquals(50, calc.getPercent(item2), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}
	
	@Test
	public void second_before0Mass_withoutProportion() {
		Item item1 = new Item(0,   1);
		Item item2 = new Item(100, 0);

		calc.addItem(item1);
		calc.addItem(item2);
		
		assertEquals(100, calc.getPercent(item1), 0.000001);
		assertEquals(0,   calc.getPercent(item2), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(100, item1.getMass(), 0.000001);
		assertEquals(0,   item2.getMass(), 0.000001);
	}
	
	@Test
	public void second_before0Mass_withoutMassAndProportion() {
		Item item1 = new Item(0, 1);
		Item item2 = new Item(0, 0);

		calc.addItem(item1);
		calc.addItem(item2);
		
		assertEquals(100, calc.getPercent(item1), 0.000001);
		assertEquals(0,   calc.getPercent(item2), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	

	@Test
	public void thrid_withoutProportion() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		Item item3 = new Item(100, 0);

		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		assertEquals(50, calc.getPercent(item1), 0.000001);
		assertEquals(50, calc.getPercent(item2), 0.000001);
		assertEquals(0,  calc.getPercent(item3), 0.000001);
		
		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		assertEquals(0, item3.getProportion());
		
		assertEquals(150, item1.getMass(), 0.000001);
		assertEquals(150, item2.getMass(), 0.000001);
		assertEquals(0,   item3.getMass(), 0.000001);
	}
	
	@Test
	public void thrid_firstWithoutProportion() {
		Item item1 = new Item(100, 0);
		Item item2 = new Item(100, 0);
		Item item3 = new Item(100, 1);

		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		assertEquals(0,   calc.getPercent(item1), 0.000001);
		assertEquals(0,   calc.getPercent(item2), 0.000001);
		assertEquals(100, calc.getPercent(item3), 0.000001);
		
		assertEquals(0, item1.getProportion());
		assertEquals(0, item2.getProportion());
		assertEquals(1, item3.getProportion());
		
		assertEquals(0,   item1.getMass(), 0.000001);
		assertEquals(0,   item2.getMass(), 0.000001);
		assertEquals(100, item3.getMass(), 0.000001);
	}
}
