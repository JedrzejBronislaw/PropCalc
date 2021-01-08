package jedrzejbronislaw.propcalc.view.percentUnit.calc.item.valueField;

public class ChangeController {
	private boolean permission = true;
	
	public void block() {
		permission = false;
	}
	
	public void unblock() {
		permission = true;
	}
	
	public boolean permit() {
		return permission;
	}
}
