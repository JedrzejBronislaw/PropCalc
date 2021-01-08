package jedrzejbronislaw.propcalc.tools;

public class RecursiveUpdate {

	private Runnable afterAction;
	private boolean updating = false;
	
	
	public RecursiveUpdate() {}

	public RecursiveUpdate(Runnable afterAction) {
		this.afterAction = afterAction;
	}
	
	
	public void update(Runnable updateAction) {
		if (updating == true) {
			Injection.run(updateAction);
		} else {
			updating = true;
			
			Injection.run(updateAction);
			Injection.run(afterAction);
			
			updating = false;
		}
	}
}
