package jedrzejbronislaw.propcalc.view.percentUnit.calc;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import jedrzejbronislaw.propcalc.tools.Injection;
import jedrzejbronislaw.propcalc.tools.MyFXMLLoader;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.item.CalcItem;
import lombok.Setter;

public class Calc extends VBox implements Initializable {

	@FXML private VBox itemBox;
	@FXML private Button addButton;
	
	@Setter private Runnable addAction;
	

	public void addItem(CalcItem item) {
		itemBox.getChildren().add(item);
	}
	
	
	public Calc() {
		MyFXMLLoader.create("percentUnit/Calc.fxml", this);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addButton.setOnAction(e -> Injection.run(addAction));
	}

}
