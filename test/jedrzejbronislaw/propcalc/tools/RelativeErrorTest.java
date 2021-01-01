package jedrzejbronislaw.propcalc.tools;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RelativeErrorTest {

	private RelativeError relativeError;
	
	@Before
	public void prepare() {
		relativeError = new RelativeError(100, 90);
	}
	
	
	@Test
	public void test100_90() {
		assertEquals(0.1, relativeError.value(), 0.00000001);
	}

	@Test
	public void testIsLess() {
		assertTrue(relativeError.isLessThan(0.15));
	}
	
	@Test
	public void testIsLess_false() {
		assertFalse(relativeError.isLessThan(0.05));
	}
	
	@Test
	public void testIsLess_equal() {
		assertFalse(relativeError.isLessThan(0.1));
	}

	
	@Test
	public void testIsMore() {
		assertTrue(relativeError.isMoreThan(0.05));
	}

	@Test
	public void testIsMore_false() {
		assertFalse(relativeError.isMoreThan(0.15));
	}

	@Test
	public void testIsMore_equal() {
		assertFalse(relativeError.isMoreThan(0.1));
	}
}
