package jedrzejbronislaw.propcalc.model.molecules;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jedrzejbronislaw.propcalc.model.molecules.Mixture;
import jedrzejbronislaw.propcalc.model.molecules.Solution;
import jedrzejbronislaw.propcalc.model.molecules.substances.Substance;

public class MixtureTest_4Solutions {

	private Solution solutionDPPC;
	private Solution solutionPOPC;
	private Solution solutionPOPG;
	private Solution solutionChol;
	
	@Before
	public void prepare() {
		Substance DPPC  = new Substance("DPPC", "Dipalmitoylphosphatidylcholine", "C40H80NO8P", 734.053f);
		Substance POPC  = new Substance("POPC", "", "C42H82NO8P", 760.091f);
		Substance POPG  = new Substance("POPG", "", "C40H77O10P", 749f);
		Substance chol  = new Substance("cholesterol", "Cholesterolum", "C27H46O", 386.65f);


		solutionDPPC = new Solution();
		solutionDPPC.setSubstance(DPPC);
		solutionDPPC.setConcentration(1); //1 mg/ml
		solutionDPPC.setProportion(1);
		
		solutionPOPC = new Solution();
		solutionPOPC.setSubstance(POPC);
		solutionPOPC.setConcentration(1); //1 mg/ml
		solutionPOPC.setProportion(1);

		solutionPOPG = new Solution();
		solutionPOPG.setSubstance(POPG);
		solutionPOPG.setConcentration(1); //1 mg/ml
		solutionPOPG.setProportion(1);
		
		solutionChol = new Solution();
		solutionChol.setSubstance(chol);
		solutionChol.setConcentration(1); //1 mg/ml
		solutionChol.setProportion(1);
		
		Mixture mixture = new Mixture();

		mixture.addSolution(solutionDPPC);
		mixture.addSolution(solutionPOPC);
		mixture.addSolution(solutionPOPG);
		mixture.addSolution(solutionChol);

		solutionDPPC.setProportion(6);
		solutionPOPC.setProportion(2);
		solutionChol.setProportion(1);
		solutionPOPG.setProportion(1);
	}

	
	//DPPC:POPC:chol:POPG molecules proportion 6:2:1:1
	
	@Test
	public void DPPCVolume1() {
		solutionDPPC.setVolume(1);

		assertEquals(1.0000, solutionDPPC.getVolume(), 0.0001);
		assertEquals(0.3452, solutionPOPC.getVolume(), 0.0001);
		assertEquals(0.0878, solutionChol.getVolume(), 0.0001);
		assertEquals(0.1701, solutionPOPG.getVolume(), 0.0001);
	}
	
	@Test
	public void POPCVolume1() {
		solutionPOPC.setVolume(1);

		assertEquals(2.8972, solutionDPPC.getVolume(), 0.0001);
		assertEquals(1.0000, solutionPOPC.getVolume(), 0.0001);
		assertEquals(0.2543, solutionChol.getVolume(), 0.0001);
		assertEquals(0.4927, solutionPOPG.getVolume(), 0.0001);
	}
	
	@Test
	public void CholVolume1() {
		solutionChol.setVolume(1);

		assertEquals(11.391, solutionDPPC.getVolume(), 0.0001);
		assertEquals(3.9317, solutionPOPC.getVolume(), 0.0001);
		assertEquals(1.0000, solutionChol.getVolume(), 0.0001);
		assertEquals(1.9372, solutionPOPG.getVolume(), 0.0001);
	}
	
	@Test
	public void POPGVolume1() {
		solutionPOPG.setVolume(1);

		assertEquals(5.8803, solutionDPPC.getVolume(), 0.0001);
		assertEquals(2.0296, solutionPOPC.getVolume(), 0.0001);
		assertEquals(0.5162, solutionChol.getVolume(), 0.0001);
		assertEquals(1.0000, solutionPOPG.getVolume(), 0.0001);
	}
}
