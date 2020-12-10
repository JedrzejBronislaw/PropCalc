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
import jedrzejbronislaw.propcalc.model.Solution;
import jedrzejbronislaw.propcalc.substances.Substances;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader.NodeAndController;
import jedrzejbronislaw.propcalc.view.mainWindow.MainWindowController;
import jedrzejbronislaw.propcalc.view.particulatesUnit.ParticulatesUnitController;
import jedrzejbronislaw.propcalc.view.substanceManager.SubstanceManagerController;
import jedrzejbronislaw.propcalc.view.substancesSetting.SubstancesSetting;
import jedrzejbronislaw.propcalc.view.substancesSetting.item.SubstancesSettingItem;
import jedrzejbronislaw.propcalc.view.substancesVolume.SubstancesVolume;
import jedrzejbronislaw.propcalc.view.substancesVolume.item.SubstancesVolumeItem;
import jedrzejbronislaw.propcalc.view.substancesVolume.item.SubstancesVolumeTotal;
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

		controller.setParticlesPane(particulatesUnit());
		controller.setSubstancesPane(substancesManager());
		controller.setChangeLanguage(changeLanguage);
		
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
		SubstancesSetting substancesSetting = new SubstancesSetting();

		components.getMixture().addAddListener(solution -> substancesSetting.addItem(substancesSettingItem(solution)));
		
		substancesSetting.setAddAction(() -> components.getMixture().addSolution(new Solution()));
		
		return substancesSetting;
	}

	private SubstancesSettingItem substancesSettingItem(Solution solution) {
		SubstancesSettingItem item = new SubstancesSettingItem(solution);
		item.setSubstances(Substances.load());
		
		return item;
	}

	private Node substancesVolume() {
		SubstancesVolume substancesVolume = new SubstancesVolume();
		SubstancesVolumeTotal totalItem = new SubstancesVolumeTotal();

		totalItem.setOnVolumeChange(components.getMixture()::setVolume);
		
		substancesVolume.setTotalPane(totalItem);
		
		components.getMixture().addAddListener(solution -> substancesVolume.addItem(substancesVolumeItem(solution)));
		components.getMixture().addAddListener(totalItem::addSolution);
		
		return substancesVolume;
	}

	private SubstancesVolumeItem substancesVolumeItem(Solution solution) {
		return new SubstancesVolumeItem(solution);
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
