package jedrzejbronislaw.propcalc.view;

import java.util.function.Consumer;

import javafx.scene.Node;
import jedrzejbronislaw.propcalc.components.Components;
import jedrzejbronislaw.propcalc.model.percent.Item;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader.NodeAndController;
import jedrzejbronislaw.propcalc.view.percentUnit.PercentUnitController;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.Calc;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.item.CalcItem;
import lombok.Getter;

public class PercentageViewBuilder {

	private final Components components;
	
	@Getter private Node node;


	public PercentageViewBuilder(Components components) {
		this.components = components;
		build();
	}
	
	
	private Node build() {
		MyFXMLLoader<PercentUnitController> loader = new MyFXMLLoader<>();
		NodeAndController<PercentUnitController> nac = loader.create("percentUnit/PercentUnit.fxml");

		PercentUnitController controller = nac.getController();
		controller.addNode(buildCalcPane());
//		controller.setClipboard(new Clipboard(components.getCalc()));
		
		node = nac.getNode();
		return node;
	}
	
	private Node buildCalcPane() {
		Calc calc = new Calc();
		calc.setAddAction(() -> components.getCalc().addItem(new Item()));

		addNewItemInCalcAction(item ->
			calc.addItem(new CalcItem(item, components.getCalc()))
		);
		
		return calc;
	}


	private void addNewItemInCalcAction(Consumer<Item> newSolutionInMixtureAction) {
		//existing items
		components.getCalc().getItems().forEach(newSolutionInMixtureAction);
		
		//new items
		components.getCalc().addAddListener(newSolutionInMixtureAction);
	}
}
