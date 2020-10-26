package jedrzejbronislaw.propcalc.main;

import javafx.application.Application;
import javafx.stage.Stage;
import jedrzejbronislaw.propcalc.components.Components;
import jedrzejbronislaw.propcalc.view.ViewBuilder;

public class Main extends Application {

	private Stage stage;
	

	public static void main(String[] args) {
		System.out.println("PropCalc");
		Main.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		new ViewBuilder(new Components()).build(stage);
		stage.show();
	}
}
