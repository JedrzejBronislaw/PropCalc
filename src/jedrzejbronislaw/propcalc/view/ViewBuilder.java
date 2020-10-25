package jedrzejbronislaw.propcalc.view;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jedrzejbronislaw.propcalc.lang.Internationalization;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader.NodeAndController;
import jedrzejbronislaw.propcalc.view.mainWindow.MainWindowController;

public class ViewBuilder {
	
	private static final String CSS_FILE_PATH = "application.css";
	
	
	public void build(Stage stage) {
		stage.setScene(buildScene());
		stage.setWidth(500);
		stage.setHeight(500);
		stage.setTitle(Internationalization.get("window_title"));
		stage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
	}

	private Scene buildScene() {
		MyFXMLLoader<MainWindowController> loader = new MyFXMLLoader<>();
		NodeAndController<MainWindowController> nac = loader.create("MainWindow.fxml");

		
		Scene scene = new Scene((Parent) nac.getNode());
		scene.getStylesheets().add(CSS_FILE_PATH);
		
		return scene;
	}
}
