package jedrzejbronislaw.propcalc.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jedrzejbronislaw.propcalc.substances.Substance;

public class SolutionTest_Listeners {

	private Solution solution = new Solution();
	private int changeCount = 0;
	private int changeSubstanceCount = 0;
	private int changeConcentrationCount = 0;
	private int changeProportionCount = 0;
	private int changeVolumeCount = 0;
	
	@Before
	public void prepare() {
		setListeners();
	}

	private void setListeners() {
		solution.addChangeListener(             () -> changeCount++);
		solution.addChangeSubstanceListener(    () -> changeSubstanceCount++);
		solution.addChangeConcentrationListener(() -> changeConcentrationCount++);
		solution.addChangeProportionListener(   () -> changeProportionCount++);
		solution.addChangeVolumeListener(       () -> changeVolumeCount++);
	}
	
	//once
	
	@Test
	public void setSubstance() {
		solution.setSubstance(new Substance("", "", "", 1));
		
		assertEquals(1, changeCount);
		assertEquals(1, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setConcentration() {
		solution.setConcentration(10);
		
		assertEquals(1, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(1, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setProportion() {
		solution.setProportion(10);
		
		assertEquals(1, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(1, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setVolume() {
		solution.setVolume(10);
		
		assertEquals(1, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(1, changeVolumeCount);
	}
	
	//twice
	
	@Test
	public void setSubstance_twice() {
		solution.setSubstance(new Substance("", "", "", 1));
		solution.setSubstance(new Substance("", "", "", 1));
		
		assertEquals(2, changeCount);
		assertEquals(2, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setConcentration_twice() {
		solution.setConcentration(10);
		solution.setConcentration(10);
		
		assertEquals(2, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(2, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setProportion_twice() {
		solution.setProportion(10);
		solution.setProportion(10);
		
		assertEquals(2, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(2, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setVolume_twice() {
		solution.setVolume(10);
		solution.setVolume(10);
		
		assertEquals(2, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(2, changeVolumeCount);
	}
	
	//zero value
	
	@Test
	public void setSubstance_null() {
		solution.setSubstance(null);
		
		assertEquals(1, changeCount);
		assertEquals(1, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setConcentration_zero() {
		solution.setConcentration(0);
		
		assertEquals(1, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(1, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setProportion_zero() {
		solution.setProportion(0);
		
		assertEquals(1, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(1, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setVolume_zero() {
		solution.setVolume(0);
		
		assertEquals(1, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(1, changeVolumeCount);
	}
	
	//negative value
	
	@Test
	public void setConcentration_negative() {
		try {
			solution.setConcentration(-3);
		} catch (IllegalArgumentException e) {}
		
		assertEquals(0, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setProportion_negative() {
		try {
			solution.setProportion(-3);
		} catch (IllegalArgumentException e) {}
		
		assertEquals(0, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setVolume_negative() {
		try {
			solution.setVolume(-3);
		} catch (IllegalArgumentException e) {}
		
		assertEquals(0, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	//two listeners
	
	@Test
	public void setSubstance_twoListeners() {
		setListeners();
		solution.setSubstance(new Substance("", "", "", 1));
		
		assertEquals(2, changeCount);
		assertEquals(2, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setConcentration_twoListeners() {
		setListeners();
		solution.setConcentration(10);
		
		assertEquals(2, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(2, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setProportion_twoListeners() {
		setListeners();
		solution.setProportion(10);
		
		assertEquals(2, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(2, changeProportionCount);
		assertEquals(0, changeVolumeCount);
	}
	
	@Test
	public void setVolume_twoListeners() {
		setListeners();
		solution.setVolume(10);
		
		assertEquals(2, changeCount);
		assertEquals(0, changeSubstanceCount);
		assertEquals(0, changeConcentrationCount);
		assertEquals(0, changeProportionCount);
		assertEquals(2, changeVolumeCount);
	}
}
