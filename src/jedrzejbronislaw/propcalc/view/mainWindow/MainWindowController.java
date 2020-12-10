package jedrzejbronislaw.propcalc.view.mainWindow;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import jedrzejbronislaw.propcalc.lang.Languages;
import jedrzejbronislaw.propcalc.tools.Injection;
import lombok.Setter;

public class MainWindowController implements Initializable {

	@FXML private ScrollPane particlesPane;
	@FXML private ScrollPane totalPane;
	@FXML private ScrollPane substancesPane;
	
	@Setter private Consumer<Languages> changeLanguage;
	
	
	public void setParticlesPane(Node pane) {
		particlesPane.setContent(pane);
	}
	
	public void setTotalPane(Node pane) {
		totalPane.setContent(pane);
	}
	
	public void setSubstancesPane(Node pane) {
		substancesPane.setContent(pane);
	}
	
	public void plLangClick(MouseEvent event) {
		Injection.run(changeLanguage, Languages.POLISH);
	}
	
	public void enLangClick(MouseEvent event) {
		Injection.run(changeLanguage, Languages.ENGLISH);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
