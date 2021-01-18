package jedrzejbronislaw.propcalc.components;

import java.text.DecimalFormat;

import jedrzejbronislaw.propcalc.model.molecules.Mixture;
import jedrzejbronislaw.propcalc.model.molecules.Solution;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MixtureClipboard extends Clipboard {

	private static final DecimalFormat              VOLUME_FORMAT =      FLOAT_FORMAT;
	private static final DecimalFormat   MASS_OF_SUBSTANCE_FORMAT =      FLOAT_FORMAT;
	private static final DecimalFormat NUMBER_OF_MOLECULES_FORMAT = SCIENTIFIC_FORMAT;
	
	private final Mixture mixture;

	
	@Override
	protected void header() {
		value("Name");
		value("Concentration [mg/ml]");
		value("Ratio");
		value("Volume [ml]");
		value("Mass of substance [mg]");
		value("Number of molecules");
		newLine();
	}

	@Override
	protected void body() {
		mixture.getSolutions().forEach(this::record);
	}

	private void record(Solution solution) {
		value(solution.getSubstance().getName());
		value(solution.getConcentration());
		value(solution.getProportion());
		value(             VOLUME_FORMAT.format(solution.getVolume()));
		value(  MASS_OF_SUBSTANCE_FORMAT.format(solution.massOfSubstance()));
		value(NUMBER_OF_MOLECULES_FORMAT.format(solution.numberOfMolecules()));
		newLine();
	}
	
	@Override
	protected void total() {
		double volume, mass , number;

		volume = mass = number = 0.0;
		
		for(Solution solution : mixture.getSolutions()) {
			volume += solution.getVolume();
			mass   += solution.massOfSubstance();
			number += solution.numberOfMolecules();
		}	
		
		value("TOTAL");
		value();
		value();
		value(             VOLUME_FORMAT.format(volume));
		value(  MASS_OF_SUBSTANCE_FORMAT.format(mass));
		value(NUMBER_OF_MOLECULES_FORMAT.format(number));
	}
}
