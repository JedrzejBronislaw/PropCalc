package jedrzejbronislaw.propcalc.tools;

import javafx.application.Platform;

public class Concurrent {

	public static void toFx(Runnable before, Runnable action, Runnable after) {
		
		Platform.runLater(() -> Injection.run(before));
		
		new Thread(() -> {
			Injection.run(action);
			Platform.runLater(() -> Injection.run(after));
		}).start();
	}
}
