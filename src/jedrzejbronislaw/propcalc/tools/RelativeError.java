package jedrzejbronislaw.propcalc.tools;

public class RelativeError {
	
	private double expected;
	private double actual;


	public RelativeError(double expected, double actual) {
		if (expected == 0 && actual != 0) throw new IllegalArgumentException();
		
		this.expected = expected;
		this.actual = actual;
	}


	public double value() {
		if (actual == expected) return 0;
		
		return Math.abs(expected-actual) / Math.abs(expected);
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
