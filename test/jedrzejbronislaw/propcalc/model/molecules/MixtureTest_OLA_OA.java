package jedrzejbronislaw.propcalc.model.molecules;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jedrzejbronislaw.propcalc.model.molecules.Mixture;
import jedrzejbronislaw.propcalc.model.molecules.Solution;
import jedrzejbronislaw.propcalc.model.molecules.substances.Substance;

public class MixtureTest_OLA_OA {

	private Solution solutionOLA;
	private Solution solutionOA;
	
	@Before
	public void prepare() {
		Substance OLA = new Substance("OLA", "Oleanolic acid", "C30H48O3", 456.7f);
		Substance OA  = new Substance("OA", "Oleic acid", "C18H34O2", 282.46f);

		solutionOLA = new Solution();
		solutionOLA.setSubstance(OLA);
		solutionOLA.setConcentration(1); //1 mg/ml
		solutionOLA.setProportion(1);
		
		solutionOA = new Solution();
		solutionOA.setSubstance(OA);
		solutionOA.setConcentration(1); //1 mg/ml
		solutionOA.setProportion(1);
		
		Mixture mixture = new Mixture();

		mixture.addSolution(solutionOLA);
		mixture.addSolution(solutionOA);
	}

	
	//OLA:OA molecules proportion 1:1
	
	@Test
	public void OLAVolume1() {
		solutionOLA.setVolume(1);
		assertEquals(0.6185, solutionOA.getVolume(), 0.0001);
	}

	@Test
	public void OAVolume1() {
		solutionOA.setVolume(1);
		assertEquals(1.6169, solutionOLA.getVolume(), 0.0001);
	}

	
	//OLA:OA molecules proportion 1:2
	
	@Test
	public void twoTimesMoreOA_OLAVolume1() {
		solutionOA.setProportion(2);
		solutionOLA.setVolume(1);
		assertEquals(1.237, solutionOA.getVolume(), 0.0001);
	}
	
	@Test
	public void twoTimesMoreOA_OAVolume1() {
		solutionOA.setProportion(2);
		solutionOA.setVolume(1);
		assertEquals(0.8084, solutionOLA.getVolume(), 0.0001);
	}

	
	//OLA:OA molecules proportion 2:1
	
	@Test
	public void twoTimesMoreOLA_OLAVolume1() {
		solutionOLA.setProportion(2);
		solutionOLA.setVolume(1);
		assertEquals(0.3092, solutionOA.getVolume(), 0.0001);
	}

	@Test
	public void twoTimesMoreOLA_OAVolume1() {
		solutionOLA.setProportion(2);
		solutionOA.setVolume(1);
		assertEquals(3.2337, solutionOLA.getVolume(), 0.0001);
	}
}
