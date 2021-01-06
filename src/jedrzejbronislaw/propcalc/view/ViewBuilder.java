package jedrzejbronislaw.propcalc.view;

import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jedrzejbronislaw.propcalc.components.Components;
import jedrzejbronislaw.propcalc.lang.Internationalization;
import jedrzejbronislaw.propcalc.lang.Languages;
import jedrzejbronislaw.propcalc.model.molecules.substances.Substances;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader.NodeAndController;
import jedrzejbronislaw.propcalc.view.mainWindow.MainWindowController;
import jedrzejbronislaw.propcalc.view.substanceManager.SubstanceManagerController;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ViewBuilder {
	
	private static final String CSS_FILE_PATH = "application.css";
	private static final String LOGO_FILE_NAME = "logo.png";
	
	@Setter private Consumer<Languages> changeLanguage;
	
	private final Components components;
	
	
	public void build(Stage stage) {
		stage.setScene(buildScene());
		stage.getIcons().add(loadLogo());
		stage.setWidth(500);
		stage.setHeight(600);
		stage.setTitle(Internationalization.get("window_title"));
		stage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
	}

	private Image loadLogo() {
		return new Image(LOGO_FILE_NAME);
	}

	private Scene buildScene() {
		Scene scene = new Scene((Parent) mainWindow());
		scene.getStylesheets().add(CSS_FILE_PATH);
		
		return scene;
	}

	private Node mainWindow() {
		MyFXMLLoader<MainWindowController> loader = new MyFXMLLoader<>();
		NodeAndController<MainWindowController> nac = loader.create("MainWindow.fxml");

		MainWindowController controller = nac.getController();

		controller.setMoleculesPane(moleculesUnit());
		controller.setSubstancesPane(substancesManager());
		controller.setChangeLanguage(changeLanguage);
		
		return nac.getNode();
	}

	private Node moleculesUnit() {
		return new MoleculesViewBuilder(components).getNode();
	}

	private Node substancesManager() {
		MyFXMLLoader<SubstanceManagerController> loader = new MyFXMLLoader<>();
		NodeAndController<SubstanceManagerController> nac = loader.create("SubstanceManager.fxml");

		SubstanceManagerController controller = nac.getController();
		controller.addSubstances(Substances.load());
		controller.setSaveSubstances(substances -> Substances.saveToFile(substances));
		
		return nac.getNode();
	}
}
