package jedrzejbronislaw.propcalc.view;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jedrzejbronislaw.propcalc.components.Components;
import jedrzejbronislaw.propcalc.lang.Internationalization;
import jedrzejbronislaw.propcalc.substances.Substances;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader.NodeAndController;
import jedrzejbronislaw.propcalc.view.mainWindow.MainWindowController;
import jedrzejbronislaw.propcalc.view.particulatesUnit.ParticulatesUnitController;
import jedrzejbronislaw.propcalc.view.substancesSetting.SubstancesSettingController;
import jedrzejbronislaw.propcalc.view.substancesSetting.item.SubstancesSettingItem;
import jedrzejbronislaw.propcalc.view.substancesVolume.SubstancesVolumeController;
import jedrzejbronislaw.propcalc.view.substancesVolume.item.SubstancesVolumeItem;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ViewBuilder {
	
	private static final String CSS_FILE_PATH = "application.css";
	
	private final Components components;
	
	
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
		controller.setOnAddSubstance(() -> components.getSelectedSubstances().add(null));
		
		return nac.getNode();
	}

	private SubstancesSettingItem substancesSettingItem() {
		SubstancesSettingItem item = new SubstancesSettingItem();
		item.setSubstances(Substances.all());
		
		return item;
	}

	private Node substancesVolume() {
		MyFXMLLoader<SubstancesVolumeController> loader = new MyFXMLLoader<>();
		NodeAndController<SubstancesVolumeController> nac = loader.create("SubstancesVolume.fxml");

		SubstancesVolumeController controller = nac.getController();
		controller.setTotalPane(substancesVolumeItem());
		
		components.getSelectedSubstances().addAddListener(() -> controller.addItem(substancesVolumeItem()));
		
		return nac.getNode();
	}

	private SubstancesVolumeItem substancesVolumeItem() {
		return new SubstancesVolumeItem();
	}
}
