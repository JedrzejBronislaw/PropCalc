package jedrzejbronislaw.propcalc.tools;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RelativeError {
	
	private double expected;
	private double actual;


	public double value() {
		return Math.abs(expected-actual) / expected;
	}

	public boolean isLessThan(double threshold) {
		return value() < threshold;
	}
	
	public boolean isMoreThan(double threshold) {
		return value() > threshold;
	}
	
	public String toString() {
		return "exp: " + expected + "; act: " + actual + "; error: " + value();
	}
}
