package jedrzejbronislaw.propcalc.model.percent;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ItemTest_Listeners {
	
	private Item item = new Item();
	private int changeCount = 0;
	private int changeMassCount = 0;
	private int changeProportionCount = 0;


	@Before
	public void prepare() {
		setListeners();
	}

	private void setListeners() {
		item.addChangeListener(          () -> changeCount++);
		item.addChangeMassListener(      () -> changeMassCount++);
		item.addChangeProportionListener(() -> changeProportionCount++);
	}

	
	//once

	@Test
	public void setMass() {
		item.setMass(5);
		
		assertEquals(1, changeCount);
		assertEquals(1, changeMassCount);
		assertEquals(0, changeProportionCount);
	}

	@Test
	public void setProportion() {
		item.setProportion(5);
		
		assertEquals(1, changeCount);
		assertEquals(0, changeMassCount);
		assertEquals(1, changeProportionCount);
	}
	
	//twice

	@Test
	public void setMass_twice() {
		item.setMass(5);
		item.setMass(5);
		
		assertEquals(2, changeCount);
		assertEquals(2, changeMassCount);
		assertEquals(0, changeProportionCount);
	}

	@Test
	public void setProportion_twice() {
		item.setProportion(5);
		item.setProportion(5);
		
		assertEquals(2, changeCount);
		assertEquals(0, changeMassCount);
		assertEquals(2, changeProportionCount);
	}
	
	//zero value

	@Test
	public void setMass_zero() {
		item.setMass(0);
		
		assertEquals(1, changeCount);
		assertEquals(1, changeMassCount);
		assertEquals(0, changeProportionCount);
	}

	@Test
	public void setProportion_zero() {
		item.setProportion(0);
		
		assertEquals(1, changeCount);
		assertEquals(0, changeMassCount);
		assertEquals(1, changeProportionCount);
	}
	
	//negative value

	@Test
	public void setMass_negative() {
		try {
			item.setMass(-3);
		} catch (IllegalArgumentException e) {}
		
		assertEquals(0, changeCount);
		assertEquals(0, changeMassCount);
		assertEquals(0, changeProportionCount);
	}

	@Test
	public void setProportion_negative() {
		try {
			item.setProportion(-3);
		} catch (IllegalArgumentException e) {}
		
		assertEquals(0, changeCount);
		assertEquals(0, changeMassCount);
		assertEquals(0, changeProportionCount);
	}
	
	//two listeners

	@Test
	public void setMass_twoListeners() {
		setListeners();
		item.setMass(3);
		
		assertEquals(2, changeCount);
		assertEquals(2, changeMassCount);
		assertEquals(0, changeProportionCount);
	}

	@Test
	public void setProportion_twoListeners() {
		setListeners();
		item.setProportion(3);
		
		assertEquals(2, changeCount);
		assertEquals(0, changeMassCount);
		assertEquals(2, changeProportionCount);
	}
}
