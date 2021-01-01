package jedrzejbronislaw.propcalc.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jedrzejbronislaw.propcalc.substances.Substance;
import jedrzejbronislaw.propcalc.tools.RelativeError;

public class ProportionControllerTest {

	private Solution solutionOLA;
	private Solution solutionOA;
	
	private ProportionController propCtrl;
	
	
	@Before
	public void prepare() {
		Substance OLA = new Substance("OLA", "Oleanolic acid", "C30H48O3", 456.7f);
		Substance OA  = new Substance("OA", "Oleic acid", "C18H34O2", 282.46f);

		solutionOLA = new Solution();
		solutionOLA.setSubstance(OLA);
		solutionOLA.setConcentration(1); //1 mg/ml
		solutionOLA.setProportion(1);
		solutionOLA.setVolume(1);
		
		solutionOA = new Solution();
		solutionOA.setSubstance(OA);
		solutionOA.setConcentration(1); //1 mg/ml
		solutionOA.setProportion(1);
		solutionOA.setVolume(1);
		
		List<Solution> solutions = new ArrayList<>();
		propCtrl = new ProportionController(solutions);

		solutions.add(solutionOLA);
		solutions.add(solutionOA);
	}

	@Test
	public void calcTwice() {
		propCtrl.updateVolumes();

		double  oaVolume1  = solutionOA. getVolume();
		double olaVolume1 = solutionOLA.getVolume();
		
		propCtrl.updateVolumes();

		double  oaVolume2  = solutionOA. getVolume();
		double olaVolume2 = solutionOLA.getVolume();
		
		assertTrue( oaVolume1 ==  oaVolume2);
		assertTrue(olaVolume1 == olaVolume2);
	}
	
	@Test
	public void calcVolumesButDontChanageTotalVolume() {
		propCtrl.updateVolumes();
		
		double oaVolume  = solutionOA. getVolume();
		double olaVolume = solutionOLA.getVolume();
		
		assertNotEquals(1,  oaVolume);
		assertNotEquals(1, olaVolume);
		assertEquals(2, oaVolume + olaVolume, 0.00001);
		assertTrue(equal(solutionOA.numberOfMolecules(), solutionOLA.numberOfMolecules()));
	}
	
	@Test
	public void calcVolumesButDontChanageOAVolume() {
		propCtrl.updateVolumes(solutionOA);
		
		assertEquals(1, solutionOA.getVolume(), 0.00001);
		assertTrue(equal(solutionOA.numberOfMolecules(), solutionOLA.numberOfMolecules()));
	}

	@Test
	public void calcVolumesForNewTotalVolume_10() {
		propCtrl.updateVolumes(10);

		double totalVolume = solutionOA. getVolume() + solutionOLA.getVolume();
		
		assertEquals(10, totalVolume, 0.00001);
		assertTrue(equal(solutionOA.numberOfMolecules(), solutionOLA.numberOfMolecules()));
	}

	@Test
	public void calcVolumesForNewTotalVolume_1() {
		propCtrl.updateVolumes(1);

		double totalVolume = solutionOA. getVolume() + solutionOLA.getVolume();
		
		assertEquals(1, totalVolume, 0.00001);
		assertTrue(equal(solutionOA.numberOfMolecules(), solutionOLA.numberOfMolecules()));
	}

	@Test
	public void calcVolumesForNewTotalVolume_0() {
		propCtrl.updateVolumes(0);

		double  oaVolume  = solutionOA. getVolume();
		double olaVolume = solutionOLA.getVolume();
		double totalVolume = oaVolume + olaVolume;
		
		assertEquals(0,  oaVolume, 0.00001);
		assertEquals(0, olaVolume, 0.00001);
		assertEquals(0, totalVolume, 0.00001);
		assertEquals(0, solutionOA .numberOfMolecules(), 0.00001);
		assertEquals(0, solutionOLA.numberOfMolecules(), 0.00001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void calcVolumesForNewTotalVolume_negative() {
		propCtrl.updateVolumes(-3);
	}

	@Test
	public void calcVolumesForRatio2_1() {
		solutionOA. setProportion(2);
		solutionOLA.setProportion(1);
		
		propCtrl.updateVolumes();
		
		assertTrue(equal(solutionOA.numberOfMolecules(), 2 * solutionOLA.numberOfMolecules()));
	}
	
	@Test
	public void calcVolumesForRatio1_100() {
		solutionOA. setProportion(1);
		solutionOLA.setProportion(100);
		
		propCtrl.updateVolumes();
		
		assertTrue(equal(100 * solutionOA.numberOfMolecules(), solutionOLA.numberOfMolecules()));
	}
	
	private boolean equal(double a, double b) {
		return new RelativeError(a, b).isLessThan(0.0000001);
	}
}
