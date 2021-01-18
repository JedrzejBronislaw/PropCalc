package jedrzejbronislaw.propcalc.components;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.text.DecimalFormat;

public abstract class Clipboard {

	protected static final DecimalFormat      FLOAT_FORMAT = new DecimalFormat("#.###");
	protected static final DecimalFormat SCIENTIFIC_FORMAT = new DecimalFormat("#.###E0");

	private static final String LINE_SEPARATOR = "\n";
	private static final String SEPARATOR      = "\t";
	
	private StringBuffer buffer = new StringBuffer();
	

	protected abstract void header();
	protected abstract void body();
	protected abstract void total();
	
	public void save() {
		buffer = new StringBuffer();
		
		header();
		body();
		newLine();
		total();
		
		saveToClipboard(buffer.toString());
	}

	protected void newLine() {
		buffer.append(LINE_SEPARATOR);
	}
	
	protected void value(String text) {
		buffer.append(text);
		value();
	}
	
	protected void value(double val) {
		buffer.append(val);
		value();
	}
	
	protected void value() {
		buffer.append(SEPARATOR);
	}

	private void saveToClipboard(String text) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null);
	}
}
