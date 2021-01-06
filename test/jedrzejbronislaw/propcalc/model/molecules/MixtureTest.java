package jedrzejbronislaw.propcalc.model.molecules;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jedrzejbronislaw.propcalc.model.molecules.Mixture;
import jedrzejbronislaw.propcalc.model.molecules.Solution;
import jedrzejbronislaw.propcalc.model.molecules.substances.Substance;

public class MixtureTest {

	private Solution solutionOLA;
	private Solution solutionOA;
	private Mixture mixture;
	
	@Before
	public void prepare() {
		Substance OLA = new Substance("OLA", "Oleanolic acid", "C30H48O3", 456.7f);
		Substance OA  = new Substance("OA", "Oleic acid", "C18H34O2", 282.46f);

		solutionOLA = new Solution();
		solutionOLA.setSubstance(OLA);
		solutionOLA.setConcentration(1); //1 mg/ml
		solutionOLA.setProportion(1);
		solutionOLA.setVolume(0);
		
		solutionOA = new Solution();
		solutionOA.setSubstance(OA);
		solutionOA.setConcentration(1); //1 mg/ml
		solutionOA.setProportion(1);
		solutionOA.setVolume(0);
		
		mixture = new Mixture();
	}


	@Test
	public void checkInitialVolume() {
		mixture.addSolution(solutionOLA);
		mixture.addSolution(solutionOA);

		assertEquals(0, solutionOLA.getVolume(), 0.00001);
		assertEquals(0, solutionOA .getVolume(), 0.00001);
	}

	@Test
	public void clearSolutionVolumeByAddingToMixture() {
		solutionOLA.setVolume(1);
		mixture.addSolution(solutionOLA);
		mixture.addSolution(solutionOA);

		
		assertEquals(0, solutionOLA.getVolume(), 0.0001);
		assertEquals(0, solutionOA .getVolume(), 0.0001);
	}

	@Test
	public void setTotalMixtureVolume() {
		mixture.addSolution(solutionOLA);
		mixture.addSolution(solutionOA);

		mixture.setVolume(1.6185);

		assertEquals(1,      solutionOLA.getVolume(), 0.0001);
		assertEquals(0.6185, solutionOA .getVolume(), 0.0001);
	}
}
