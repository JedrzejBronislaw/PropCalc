package jedrzejbronislaw.propcalc.view.mainWindow;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

public class MainWindowController implements Initializable {

	@FXML private ScrollPane particlesPane;
	@FXML private ScrollPane totalPane;
	
	
	public void setParticlesPane(Node pane) {
		particlesPane.setContent(pane);
	}
	
	public void setTotalPane(Node pane) {
		totalPane.setContent(pane);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
