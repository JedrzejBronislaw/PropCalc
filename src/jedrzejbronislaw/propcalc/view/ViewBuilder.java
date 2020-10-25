package jedrzejbronislaw.propcalc.view;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jedrzejbronislaw.propcalc.lang.Internationalization;
import jedrzejbronislaw.propcalc.substances.Substances;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader.NodeAndController;
import jedrzejbronislaw.propcalc.view.mainWindow.MainWindowController;
import jedrzejbronislaw.propcalc.view.particulatesUnit.ParticulatesUnitController;
import jedrzejbronislaw.propcalc.view.substancesSetting.SubstancesSettingController;
import jedrzejbronislaw.propcalc.view.substancesSetting.item.SubstancesSettingItemController;
import jedrzejbronislaw.propcalc.view.substancesVolume.SubstancesVolumeController;
import jedrzejbronislaw.propcalc.view.substancesVolume.item.SubstancesVolumeItemController;

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
		Scene scene = new Scene((Parent) mainWindow());
		scene.getStylesheets().add(CSS_FILE_PATH);
		
		return scene;
	}

	private Node mainWindow() {
		MyFXMLLoader<MainWindowController> loader = new MyFXMLLoader<>();
		NodeAndController<MainWindowController> nac = loader.create("MainWindow.fxml");

		MainWindowController controller = nac.getController();

		controller.setParticlesPane(particulatesUnit());
		
		return nac.getNode();
	}

	private Node particulatesUnit() {
		MyFXMLLoader<ParticulatesUnitController> loader = new MyFXMLLoader<>();
		NodeAndController<ParticulatesUnitController> nac = loader.create("ParticulatesUnit.fxml");

		ParticulatesUnitController controller = nac.getController();
		controller.addNode(substancesSetting());
		controller.addNode(substancesVolume());
		
		return nac.getNode();
	}

	private Node substancesSetting() {
		MyFXMLLoader<SubstancesSettingController> loader = new MyFXMLLoader<>();
		NodeAndController<SubstancesSettingController> nac = loader.create("SubstancesSetting.fxml");

		SubstancesSettingController controller = nac.getController();
		controller.setAddAction(() -> controller.addItem(substancesSettingItem()));
		
		return nac.getNode();
	}

	private Node substancesSettingItem() {
		MyFXMLLoader<SubstancesSettingItemController> loader = new MyFXMLLoader<>();
		NodeAndController<SubstancesSettingItemController> nac = loader.create("SubstancesSettingItem.fxml");

		nac.getController().setSubstances(Substances.all());
		
		return nac.getNode();
	}

	private Node substancesVolume() {
		MyFXMLLoader<SubstancesVolumeController> loader = new MyFXMLLoader<>();
		NodeAndController<SubstancesVolumeController> nac = loader.create("SubstancesVolume.fxml");

		SubstancesVolumeController controller = nac.getController();
		controller.addItem(substancesVolumeItem());
		controller.addItem(substancesVolumeItem());
		controller.addItem(substancesVolumeItem());
		controller.setTotalPane(substancesVolumeItem());
		
		return nac.getNode();
	}

	private Node substancesVolumeItem() {
		MyFXMLLoader<SubstancesVolumeItemController> loader = new MyFXMLLoader<>();
		NodeAndController<SubstancesVolumeItemController> nac = loader.create("SubstancesVolumeItem.fxml");

		return nac.getNode();
	}
}
