package jedrzejbronislaw.propcalc.tools;

public class RecursiveUpdate {

	private Runnable beforeAction;
	
	private boolean updating = false;
	
	
	public RecursiveUpdate() {}

	public RecursiveUpdate(Runnable beforeAction) {
		this.beforeAction = beforeAction;
	}
	
	public void update(Runnable updateAction) {
		if (updating == true) {
			Injection.run(updateAction);
		} else {
			updating = true;
			
			Injection.run(updateAction);
			Injection.run(beforeAction);
			
			updating = false;
		}
	}
}
