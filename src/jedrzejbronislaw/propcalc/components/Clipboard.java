package jedrzejbronislaw.propcalc.components;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.text.DecimalFormat;

import jedrzejbronislaw.propcalc.model.Mixture;
import jedrzejbronislaw.propcalc.model.Solution;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Clipboard {

	private static final DecimalFormat volumeFormat = new DecimalFormat("#.###");
	private static final DecimalFormat massOfSubstanceFormat = new DecimalFormat("#.###");
	private static final DecimalFormat numberOfMoleculesFormat = new DecimalFormat("#.###E0");

	private static final String LINE_SEPARATOR = "\n";
	private static final String SEPARATOR = "\t";
	
	
	private final Mixture mixture;
	private StringBuffer buffer = new StringBuffer();
	
	
	public void save() {
		buffer = new StringBuffer();
		
		header();
		mixture.getSolutions().forEach(this::record);
		newLine();
		total();
		
		saveToClipboard(buffer.toString());
	}

	private void total() {
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
		value(volumeFormat.format(volume));
		value(massOfSubstanceFormat.format(mass));
		value(numberOfMoleculesFormat.format(number));
	}

	private void record(Solution solution) {
		value(solution.getSubstance().getName());
		value(solution.getConcentration());
		value(solution.getProportion());
		value(volumeFormat.format(solution.getVolume()));
		value(massOfSubstanceFormat.format(solution.massOfSubstance()));
		value(numberOfMoleculesFormat.format(solution.numberOfMolecules()));
		newLine();
	}
	
	private void header() {
		value("Name");
		value("Concentration [mg/ml]");
		value("Ratio");
		value("Volume [ml]");
		value("Mass of substance [mg]");
		value("Number of molecules");
		newLine();
	}
	

	private void newLine() {
		buffer.append(LINE_SEPARATOR);
	}
	
	private void value(String text) {
		buffer.append(text);
		value();
	}
	
	private void value(double val) {
		buffer.append(val);
		value();
	}
	
	private void value() {
		buffer.append(SEPARATOR);
	}

	private void saveToClipboard(String text) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null);
	}
}
