package jedrzejbronislaw.propcalc.model.percent;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest_Mass {
	
	private Calc calc = new Calc();
	
	//one item

	@Test
	public void setMass_onlyOneItem_proportion0() {
		Item item = new Item(100, 0);
		calc.addItem(item);
		
		item.setMass(200);

		assertEquals(100, calc.getPercent(item), 0.000001);
		assertEquals(1, item.getProportion());
		assertEquals(200, item.getMass(), 0.000001);
	}

	@Test
	public void setMass_onlyOneItem_proportion1() {
		Item item = new Item(100, 1);
		calc.addItem(item);
		
		item.setMass(200);

		assertEquals(100, calc.getPercent(item), 0.000001);
		assertEquals(1, item.getProportion());
		assertEquals(200, item.getMass(), 0.000001);
	}

	@Test
	public void setMass_onlyOneItem_proportion5() {
		Item item = new Item(100, 5);
		calc.addItem(item);
		
		item.setMass(200);

		assertEquals(100, calc.getPercent(item), 0.000001);
		assertEquals(1, item.getProportion());
		assertEquals(200, item.getMass(), 0.000001);
	}
	
	//two items

	@Test
	public void setMass_10_0_initProportion_0_0() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setMass(10);
		
		assertEquals(100, calc.getPercent(item1), 0.000001);
		assertEquals(  0, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(10, item1.getMass(), 0.000001);
		assertEquals( 0, item2.getMass(), 0.000001);
	}

	@Test
	public void setMass_10_90_initProportion_0_0() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		item1.setMass(10);
		item2.setMass(90);
		
		assertEquals(10, calc.getPercent(item1), 0.000001);
		assertEquals(90, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(9, item2.getProportion());
		
		assertEquals(10, item1.getMass(), 0.000001);
		assertEquals(90, item2.getMass(), 0.000001);
	}

	@Test
	public void setMass_10_100_initProportion_0_0() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		item1.setMass( 10);
		item2.setMass(100);
		
		assertEquals( 9.0909090909, calc.getPercent(item1), 0.000001);
		assertEquals(90.9090909090, calc.getPercent(item2), 0.000001);

		assertEquals( 1, item1.getProportion());
		assertEquals(10, item2.getProportion());
		
		assertEquals( 10, item1.getMass(), 0.000001);
		assertEquals(100, item2.getMass(), 0.000001);
	}

	@Test
	public void setMass_10_100_initMass_100_100() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		
		item1.setMass( 10);
		item2.setMass(100);
		
		assertEquals( 9.0909090909, calc.getPercent(item1), 0.000001);
		assertEquals(90.9090909090, calc.getPercent(item2), 0.000001);

		assertEquals( 1, item1.getProportion());
		assertEquals(10, item2.getProportion());
		
		assertEquals( 10, item1.getMass(), 0.000001);
		assertEquals(100, item2.getMass(), 0.000001);
	}

	@Test
	public void setMass_1000000_1000000() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		
		item1.setMass(1000000);
		item2.setMass(1000000);
		
		assertEquals(50, calc.getPercent(item1), 0.000001);
		assertEquals(50, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(1000000, item1.getMass(), 0.000001);
		assertEquals(1000000, item2.getMass(), 0.000001);
	}

	//three items
	
	@Test
	public void setMass_10_100_100_initMass_100_100_100() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		Item item3 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		item1.setMass(10);
		
		assertEquals( 4.7619047619, calc.getPercent(item1), 0.000001);
		assertEquals(47.6190476190, calc.getPercent(item2), 0.000001);
		assertEquals(47.6190476190, calc.getPercent(item3), 0.000001);

		assertEquals( 1, item1.getProportion());
		assertEquals(10, item2.getProportion());
		assertEquals(10, item3.getProportion());
		
		assertEquals( 10, item1.getMass(), 0.000001);
		assertEquals(100, item2.getMass(), 0.000001);
		assertEquals(100, item3.getMass(), 0.000001);
	}
	
	@Test
	public void setMass_10_0_0_initMass_0_0_0() {
		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		item1.setMass(10);
		
		assertEquals(100, calc.getPercent(item1), 0.000001);
		assertEquals(  0, calc.getPercent(item2), 0.000001);
		assertEquals(  0, calc.getPercent(item3), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(0, item2.getProportion());
		assertEquals(0, item3.getProportion());
		
		assertEquals(10, item1.getMass(), 0.000001);
		assertEquals( 0, item2.getMass(), 0.000001);
		assertEquals( 0, item3.getMass(), 0.000001);
	}
	
	@Test
	public void setMass_0_100_100_initMass_0_0_0() {
		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		item2.setMass(100);
		item3.setMass(100);
		
		assertEquals( 0, calc.getPercent(item1), 0.000001);
		assertEquals(50, calc.getPercent(item2), 0.000001);
		assertEquals(50, calc.getPercent(item3), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(1, item2.getProportion());
		assertEquals(1, item3.getProportion());
		
		assertEquals(  0, item1.getMass(), 0.000001);
		assertEquals(100, item2.getMass(), 0.000001);
		assertEquals(100, item3.getMass(), 0.000001);
	}
	
	@Test
	public void setMass_10_0_100_initMass_0_0_0() {
		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		item1.setMass(10);
		item3.setMass(100);
		
		assertEquals( 9.0909090909, calc.getPercent(item1), 0.000001);
		assertEquals( 0,            calc.getPercent(item2), 0.000001);
		assertEquals(90.9090909090, calc.getPercent(item3), 0.000001);

		assertEquals( 1, item1.getProportion());
		assertEquals( 0, item2.getProportion());
		assertEquals(10, item3.getProportion());
		
		assertEquals( 10, item1.getMass(), 0.000001);
		assertEquals(  0, item2.getMass(), 0.000001);
		assertEquals(100, item3.getMass(), 0.000001);
	}
	
	@Test
	public void setMass_10_100_100_initMass_0_0_0() {
		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		item1.setMass(10);
		item2.setMass(100);
		item3.setMass(100);
		
		assertEquals( 4.7619047619, calc.getPercent(item1), 0.000001);
		assertEquals(47.6190476190, calc.getPercent(item2), 0.000001);
		assertEquals(47.6190476190, calc.getPercent(item3), 0.000001);

		assertEquals( 1, item1.getProportion());
		assertEquals(10, item2.getProportion());
		assertEquals(10, item3.getProportion());
		
		assertEquals( 10, item1.getMass(), 0.000001);
		assertEquals(100, item2.getMass(), 0.000001);
		assertEquals(100, item3.getMass(), 0.000001);
	}
	
	//real mass
	
	@Test
	public void setMass_33_333_initMass_100_100() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		
		item1.setMass(33.333);
		
		assertEquals(25, calc.getPercent(item1), 0.001);
		assertEquals(75, calc.getPercent(item2), 0.001);

		assertEquals( 33333, item1.getProportion());
		assertEquals(100000, item2.getProportion());
		
		assertEquals( 33.333, item1.getMass(), 0.000001);
		assertEquals(100,     item2.getMass(), 0.000001);
	}
	
	@Test
	public void setMass_4_1() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		
		item1.setMass(4.1);
		item2.setMass(5.9);

		assertEquals(41, item1.getProportion());
		assertEquals(59, item2.getProportion());
		
		assertEquals(41, calc.getPercent(item1), 0.001);
		assertEquals(59, calc.getPercent(item2), 0.001);
		
		assertEquals(4.1, item1.getMass(), 0.000001);
		assertEquals(5.9, item2.getMass(), 0.000001);
	}
	
	@Test
	public void setMass_5AndHalf_initMass_100_100_100() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		Item item3 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);
		
		item1.setMass(5.5);
		
		assertEquals( 2.6763990267, calc.getPercent(item1), 0.000001);
		assertEquals(48.6618004866, calc.getPercent(item2), 0.000001);
		assertEquals(48.6618004866, calc.getPercent(item3), 0.000001);

		assertEquals( 11, item1.getProportion());
		assertEquals(200, item2.getProportion());
		assertEquals(200, item3.getProportion());
		
		assertEquals( 5.5, item1.getMass(), 0.000001);
		assertEquals(100, item2.getMass(), 0.000001);
		assertEquals(100, item3.getMass(), 0.000001);
	}
}
