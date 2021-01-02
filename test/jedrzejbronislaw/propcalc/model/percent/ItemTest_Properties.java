package jedrzejbronislaw.propcalc.model.percent;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest_Properties {
	
	private Item item = new Item();
	
	
	//name
	
	@Test
	public void initialEmptyName() {
		assertEquals("", item.getName());
	}
	
	@Test
	public void name() {
		item.setName("name");
		assertEquals("name", item.getName());
	}
	
	@Test
	public void name_null() {
		item.setName(null);
		assertEquals("", item.getName());
	}
	
	@Test
	public void name_clear() {
		item.setName("name");
		item.setName(null);
		assertEquals("", item.getName());
	}

	
	//mass

	@Test
	public void mass_positive() {
		item.setMass(5);
		assertEquals(5, item.getMass(), 0.000001);
	}
	
	@Test
	public void mass_0() {
		item.setMass(0);
		assertEquals(0, item.getMass(), 0.000001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void mass_negative_exception() {
		item.setMass(-3);
	}
	
	@Test
	public void mass_negative() {
		item.setMass(1);
		
		try {
			item.setMass(-3);
		} catch(IllegalArgumentException e) {}
		
		assertEquals(1, item.getMass(), 0.000001);
	}
	
	//proportion

	@Test
	public void proportion_positive() {
		item.setProportion(5);
		assertEquals(5, item.getProportion(), 0.000001);
	}
	
	@Test
	public void proportion_0() {
		item.setProportion(0);
		assertEquals(0, item.getProportion(), 0.000001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void proportion_negative_exception() {
		item.setProportion(-3);
	}
	
	@Test
	public void proportion_negative() {
		item.setProportion(1);
		
		try {
			item.setProportion(-3);
		} catch(IllegalArgumentException e) {}
		
		assertEquals(1, item.getProportion(), 0.000001);
	}
}
