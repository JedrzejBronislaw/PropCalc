package jedrzejbronislaw.propcalc.view;

import java.util.function.Consumer;

import javafx.scene.Node;
import jedrzejbronislaw.propcalc.components.Clipboard;
import jedrzejbronislaw.propcalc.components.Components;
import jedrzejbronislaw.propcalc.model.molecules.Solution;
import jedrzejbronislaw.propcalc.model.molecules.substances.Substances;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader.NodeAndController;
import jedrzejbronislaw.propcalc.view.moleculesUnit.MoleculesUnitController;
import jedrzejbronislaw.propcalc.view.moleculesUnit.substancesSetting.SubstancesSetting;
import jedrzejbronislaw.propcalc.view.moleculesUnit.substancesSetting.item.SubstancesSettingItem;
import jedrzejbronislaw.propcalc.view.moleculesUnit.substancesVolume.SubstancesVolume;
import jedrzejbronislaw.propcalc.view.moleculesUnit.substancesVolume.item.SubstancesVolumeItem;
import jedrzejbronislaw.propcalc.view.moleculesUnit.substancesVolume.item.SubstancesVolumeTotal;
import lombok.Getter;

public class MoleculesViewBuilder {

	private final Components components;
	
	@Getter private Node node;


	public MoleculesViewBuilder(Components components) {
		this.components = components;
		build();
	}
	
	
	private Node build() {
		MyFXMLLoader<MoleculesUnitController> loader = new MyFXMLLoader<>();
		NodeAndController<MoleculesUnitController> nac = loader.create("moleculesUnit/MoleculesUnit.fxml");

		MoleculesUnitController controller = nac.getController();
		controller.addNode(buildSettingPane());
		controller.addNode(buildVolumePane());
		controller.setClipboard(new Clipboard(components.getMixture()));
		
		node = nac.getNode();
		return node;
	}
	
	private Node buildSettingPane() {
		SubstancesSetting substancesSetting = new SubstancesSetting();

		addNewSolutionInMixtureAction(solution -> substancesSetting.addItem(substancesSettingItem(solution)));
		
		substancesSetting.setAddAction(() -> components.getMixture().addSolution(new Solution()));
		
		return substancesSetting;
	}
	
	private SubstancesSettingItem substancesSettingItem(Solution solution) {
		SubstancesSettingItem item = new SubstancesSettingItem(solution);
		item.setSubstances(Substances.load());
		
		return item;
	}

	private Node buildVolumePane() {
		SubstancesVolume substancesVolume = new SubstancesVolume();
		SubstancesVolumeTotal totalItem = new SubstancesVolumeTotal();

		totalItem.setOnVolumeChange(components.getMixture()::setVolume);
		
		substancesVolume.setTotalPane(totalItem);

		addNewSolutionInMixtureAction(solution -> {
			substancesVolume.addItem(new SubstancesVolumeItem(solution));
			totalItem.addSolution(solution);
		});
		
		return substancesVolume;
	}


	private void addNewSolutionInMixtureAction(Consumer<Solution> newSolutionInMixtureAction) {
		//existing solutions
		components.getMixture().getSolutions().forEach(newSolutionInMixtureAction);
		
		//new solutions
		components.getMixture().addAddListener(newSolutionInMixtureAction);
	}
}
