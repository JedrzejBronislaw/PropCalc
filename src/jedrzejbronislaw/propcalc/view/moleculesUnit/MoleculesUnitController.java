package jedrzejbronislaw.propcalc.view.moleculesUnit;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class MoleculesUnitController implements Initializable {

	@FXML private VBox mainBox;
	

	public void addNode(Node node) {
		mainBox.getChildren().add(node);
	}
	
	public void copyToClipboard(ActionEvent event) {
		System.out.println("copy");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
