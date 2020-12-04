package jedrzejbronislaw.propcalc.view.substanceManager;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import jedrzejbronislaw.propcalc.substances.Substance;
import jedrzejbronislaw.propcalc.tools.Concurrent;
import jedrzejbronislaw.propcalc.tools.Injection;
import jedrzejbronislaw.propcalc.view.substanceManager.field.SubstanceField;
import lombok.Setter;

public class SubstanceManagerController implements Initializable {

	@FXML private VBox list;
	
	private List<SubstanceField> substanceFields = new LinkedList<>();
	@Setter private Consumer<List<Substance>> saveSubstances;

	
	public void addSubstances(List<Substance> substances) {
		substances.forEach(this::addSubstance);
	}
	
	public void addSubstance(Substance substance) {
		SubstanceField field = new SubstanceField(substance);
		
		substanceFields.add(field);
		list.getChildren().add(field);
	}

	public void saveButtonClick(ActionEvent event) {
		Button button = (Button) event.getSource();
		
		Concurrent.toFx(
			() -> button.setDisable(true),
			() -> Injection.run(saveSubstances, getSubstances()),
			() -> button.setDisable(false)
		);
	}

	public void addButtonClick(ActionEvent event) {
		addSubstance(null);
	}

	private List<Substance> getSubstances() {
		return substanceFields.stream().map(field -> field.getSubstance()).collect(Collectors.toList());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
}
