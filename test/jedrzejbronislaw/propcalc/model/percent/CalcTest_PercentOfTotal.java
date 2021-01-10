package jedrzejbronislaw.propcalc.model.percent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jedrzejbronislaw.propcalc.model.percent.CalcOptions.ChangeMassAction;

public class CalcTest_PercentOfTotal {
	
	private Calc calc = new Calc();

	@Before
	public void prepare() {
		calc.getOptions().setChangeMassAction(ChangeMassAction.CHANGE_OTHER_MASSES);
	}
	
	@Test
	public void _3percenOfTotal() {
		Item item1 = new Item(100, 1);
		Item item2 = new Item(100, 1);
		calc.addItem(item1);
		calc.addItem(item2);
		
		calc.setPercent(item1, 3);
		item2.setMass(15);
		
		assertEquals(0.4639175258, item1.getMass(), 0.000001);
		assertEquals(15,           item2.getMass(), 0.000001);
	}
}
