package jedrzejbronislaw.propcalc.main;

import javafx.application.Application;
import javafx.stage.Stage;
import jedrzejbronislaw.propcalc.components.Components;
import jedrzejbronislaw.propcalc.lang.Internationalization;
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
		ViewBuilder viewBuilder = new ViewBuilder(new Components());
		
		viewBuilder.setChangeLanguage(language -> {
			stage.hide();
			Internationalization.setLanguage(language);
			viewBuilder.build(stage);
			stage.show();
		});
		
		viewBuilder.build(stage);
		
		stage.show();
	}
}
