package jedrzejbronislaw.propcalc.view.substanceManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import jedrzejbronislaw.propcalc.substances.Substance;
import jedrzejbronislaw.propcalc.view.substanceManager.field.SubstanceField;

public class SubstanceManagerController implements Initializable {

	@FXML private VBox list;
	

	public void addSubstances(List<Substance> substances) {
		substances.forEach(this::addSubstance);
	}
	
	public void addSubstance(Substance substance) {
		list.getChildren().add(new SubstanceField(substance));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
}
