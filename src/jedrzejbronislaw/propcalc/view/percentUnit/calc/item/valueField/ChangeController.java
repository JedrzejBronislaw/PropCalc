package jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField;

import lombok.Getter;

public class ChangeController {
	
	@Getter private boolean ongoing = false;
	
	public void start() {
		ongoing = true;
	}
	
	public void end() {
		ongoing = false;
	}
}
