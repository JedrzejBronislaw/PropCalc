package jedrzejbronislaw.propcalc.model.percent;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jedrzejbronislaw.propcalc.model.percent.CalcOptions.ChangeProportionAction;

public class CalcTest_Proportion_ChangeOneMass {
	
	private Calc calc = new Calc();

	@Before
	public void prepare() {
		calc.getOptions().setChangeProportionAction(ChangeProportionAction.CHANGE_ONE_MASS);
	}
	
	//one item

	@Test
	public void setProportion_5_onlyOneItem_withoutMass() {
		Item item = new Item();
		calc.addItem(item);
		
		item.setProportion(5);

		assertEquals(100, calc.getPercent(item), 0.000001);
		assertEquals(5, item.getProportion());
		assertEquals(0, item.getMass(), 0.000001);
	}

	@Test
	public void setProportion_5_onlyOneItem_withMass() {
		Item item = new Item(100, 1);
		calc.addItem(item);
		
		item.setProportion(5);

		assertEquals(100, calc.getPercent(item), 0.000001);
		assertEquals(5, item.getProportion());
		assertEquals(100, item.getMass(), 0.000001);
	}

	@Test
	public void setProportion_0_onlyOneItem_withMass() {
		Item item = new Item(100, 1);
		calc.addItem(item);
		
		item.setProportion(0);

		assertEquals(0, calc.getPercent(item), 0.000001);
		assertEquals(0, item.getProportion());
		assertEquals(0, item.getMass(), 0.000001);
	}
	
	//two items - without mass

	@Test
	public void setProportion_1_0_withoutMass() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		item1.setProportion(1);
		
		assertEquals(100, calc.getPercent(item1), 0.000001);
		assertEquals(  0, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_0_1_withoutMass() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);
		
		item2.setProportion(1);
		
		assertEquals(  0, calc.getPercent(item1), 0.000001);
		assertEquals(100, calc.getPercent(item2), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_1_1_withoutMass() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(1);
		item2.setProportion(1);
		
		assertEquals(50, calc.getPercent(item1), 0.000001);
		assertEquals(50, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_2_1_withoutMass() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(2);
		item2.setProportion(1);
		
		assertEquals(66.6666666666, calc.getPercent(item1), 0.000001);
		assertEquals(33.3333333333, calc.getPercent(item2), 0.000001);

		assertEquals(2, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_0_0_withoutMass() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(0);
		item2.setProportion(0);
		
		assertEquals(0, calc.getPercent(item1), 0.000001);
		assertEquals(0, calc.getPercent(item2), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_2_3_withoutMass() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(2);
		item2.setProportion(3);
		
		assertEquals(40, calc.getPercent(item1), 0.000001);
		assertEquals(60, calc.getPercent(item2), 0.000001);

		assertEquals(2, item1.getProportion());
		assertEquals(3, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_4_6_noReduction_withoutMass() {
		Item item1 = new Item();
		Item item2 = new Item();
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(4);
		item2.setProportion(6);
		
		assertEquals(40, calc.getPercent(item1), 0.000001);
		assertEquals(60, calc.getPercent(item2), 0.000001);

		assertEquals(4, item1.getProportion());
		assertEquals(6, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_1_4_start6_4_withoutMass() {
		Item item1 = new Item(0, 6);
		Item item2 = new Item(0, 4);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(1);
		
		assertEquals(20, calc.getPercent(item1), 0.000001);
		assertEquals(80, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(4, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_0_4_start6_4_withoutMass() {
		Item item1 = new Item(0, 6);
		Item item2 = new Item(0, 4);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(0);
		
		assertEquals(  0, calc.getPercent(item1), 0.000001);
		assertEquals(100, calc.getPercent(item2), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(4, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}
	
	//two items - with mass


	@Test
	public void setProportion_1_0_withMass() {
		Item item1 = new Item(100, 0);
		Item item2 = new Item(100, 0);
		calc.addItem(item1);
		calc.addItem(item2);
		
		item1.setProportion(1);
		
		assertEquals(100, calc.getPercent(item1), 0.000001);
		assertEquals(  0, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_0_1_withMass() {
		Item item1 = new Item(100, 0);
		Item item2 = new Item(100, 0);
		calc.addItem(item1);
		calc.addItem(item2);
		
		item2.setProportion(1);
		
		assertEquals(  0, calc.getPercent(item1), 0.000001);
		assertEquals(100, calc.getPercent(item2), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_1_1_withMass() {
		Item item1 = new Item(100, 5);
		Item item2 = new Item( 40, 2);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(1);
		item2.setProportion(1);
		
		assertEquals(50, calc.getPercent(item1), 0.000001);
		assertEquals(50, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(20, item1.getMass(), 0.000001);
		assertEquals(20, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_2_1_withMass() {
		Item item1 = new Item(300, 1);
		Item item2 = new Item(  0, 0);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(2);
		item2.setProportion(1);
		
		assertEquals(66.6666666666, calc.getPercent(item1), 0.000001);
		assertEquals(33.3333333333, calc.getPercent(item2), 0.000001);

		assertEquals(2, item1.getProportion());
		assertEquals(1, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_0_0_withMass() {
		Item item1 = new Item(100, 0);
		Item item2 = new Item(100, 0);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(0);
		item2.setProportion(0);
		
		assertEquals(0, calc.getPercent(item1), 0.000001);
		assertEquals(0, calc.getPercent(item2), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(0, item2.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_2_3_withMass() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(2);
		item2.setProportion(3);
		
		assertEquals(40, calc.getPercent(item1), 0.000001);
		assertEquals(60, calc.getPercent(item2), 0.000001);

		assertEquals(2, item1.getProportion());
		assertEquals(3, item2.getProportion());
		
		assertEquals(200, item1.getMass(), 0.000001);
		assertEquals(300, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_4_6_noReduction_withMass() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(4);
		item2.setProportion(6);
		
		assertEquals(40, calc.getPercent(item1), 0.000001);
		assertEquals(60, calc.getPercent(item2), 0.000001);

		assertEquals(4, item1.getProportion());
		assertEquals(6, item2.getProportion());
		
		assertEquals(400, item1.getMass(), 0.000001);
		assertEquals(600, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_1_4_start6_4_withMass() {
		Item item1 = new Item(10, 6);
		Item item2 = new Item( 0, 4);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(1);
		
		assertEquals(20, calc.getPercent(item1), 0.000001);
		assertEquals(80, calc.getPercent(item2), 0.000001);

		assertEquals(1, item1.getProportion());
		assertEquals(4, item2.getProportion());
		
		assertEquals(1, item1.getMass(), 0.000001);
		assertEquals(4, item2.getMass(), 0.000001);
	}

	@Test
	public void setProportion_0_4_start6_4_withMass() {
		Item item1 = new Item(50, 6);
		Item item2 = new Item(50, 4);
		calc.addItem(item1);
		calc.addItem(item2);

		item1.setProportion(0);
		
		assertEquals(  0, calc.getPercent(item1), 0.000001);
		assertEquals(100, calc.getPercent(item2), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(4, item2.getProportion());
		
		assertEquals( 0, item1.getMass(), 0.000001);
		assertEquals(40, item2.getMass(), 0.000001);
	}
	
	//three items

	@Test
	public void setProportion_0_4_4_start6_4_4_withoutMass() {
		Item item1 = new Item(0, 6);
		Item item2 = new Item(0, 4);
		Item item3 = new Item(0, 4);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);

		item1.setProportion(0);
		
		assertEquals( 0, calc.getPercent(item1), 0.000001);
		assertEquals(50, calc.getPercent(item2), 0.000001);
		assertEquals(50, calc.getPercent(item3), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(4, item2.getProportion());
		assertEquals(4, item3.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
		assertEquals(0, item3.getMass(), 0.000001);
	}

	@Test
	public void setProportion_0_4_4_start6_4_4_withMass() {
		Item item1 = new Item(40, 6);
		Item item2 = new Item(50, 4);
		Item item3 = new Item(50, 4);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);

		item1.setProportion(0);
		
		assertEquals( 0, calc.getPercent(item1), 0.000001);
		assertEquals(50, calc.getPercent(item2), 0.000001);
		assertEquals(50, calc.getPercent(item3), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(4, item2.getProportion());
		assertEquals(4, item3.getProportion());
		
		assertEquals( 0, item1.getMass(), 0.000001);
		assertEquals(40, item2.getMass(), 0.000001);
		assertEquals(40, item3.getMass(), 0.000001);
	}

	@Test
	public void setProportion_0_0_0_start6_4_4_withMass() {
		Item item1 = new Item(50, 6);
		Item item2 = new Item(50, 4);
		Item item3 = new Item(50, 4);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);

		item1.setProportion(0);
		item2.setProportion(0);
		item3.setProportion(0);
		
		assertEquals(0, calc.getPercent(item1), 0.000001);
		assertEquals(0, calc.getPercent(item2), 0.000001);
		assertEquals(0, calc.getPercent(item3), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(0, item2.getProportion());
		assertEquals(0, item3.getProportion());
		
		assertEquals(0, item1.getMass(), 0.000001);
		assertEquals(0, item2.getMass(), 0.000001);
		assertEquals(0, item3.getMass(), 0.000001);
	}

	@Test
	public void setProportion_0_1_0_start6_4_4_withMass() {
		Item item1 = new Item(40, 6);
		Item item2 = new Item(50, 4);
		Item item3 = new Item(50, 4);
		calc.addItem(item1);
		calc.addItem(item2);
		calc.addItem(item3);

		item1.setProportion(0);
		item2.setProportion(1);
		item3.setProportion(0);
		
		assertEquals(  0, calc.getPercent(item1), 0.000001);
		assertEquals(100, calc.getPercent(item2), 0.000001);
		assertEquals(  0, calc.getPercent(item3), 0.000001);

		assertEquals(0, item1.getProportion());
		assertEquals(1, item2.getProportion());
		assertEquals(0, item3.getProportion());
		
		assertEquals( 0, item1.getMass(), 0.000001);
		assertEquals(10, item2.getMass(), 0.000001);
		assertEquals( 0, item3.getMass(), 0.000001);
	}
}
