package jedrzejbronislaw.propcalc.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jedrzejbronislaw.propcalc.lang.Internationalization;

public class Main extends Application {

	private Stage stage;
	

	public static void main(String[] args) {
		System.out.println("PropCalc");
		Main.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		buildView();
	}
	
	private void buildView() {
		stage.setScene(buildScene());
		stage.setWidth(1000);
		stage.setHeight(700);
		stage.setTitle(Internationalization.get("window_title"));
		stage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
		
		stage.show();
	}

	private Scene buildScene() {
		BorderPane pane = new BorderPane(new Label(Internationalization.get("window_title")));
		
		return new Scene(pane);
	}
}
