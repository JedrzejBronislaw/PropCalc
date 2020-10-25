package jedrzejbronislaw.propcalc.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jedrzejbronislaw.propcalc.lang.Internationalization;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader.NodeAndController;
import jedrzejbronislaw.propcalc.view.mainWindow.MainWindowController;

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
		stage.setWidth(500);
		stage.setHeight(500);
		stage.setTitle(Internationalization.get("window_title"));
		stage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
		
		stage.show();
	}

	private Scene buildScene() {
		MyFXMLLoader<MainWindowController> loader = new MyFXMLLoader<>();
		NodeAndController<MainWindowController> nac = loader.create("MainWindow.fxml");

		
		Scene scene = new Scene((Parent) nac.getNode());
		scene.getStylesheets().add("application.css");
		
		return scene;
	}
}
