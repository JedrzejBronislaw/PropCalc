package jedrzejbronislaw.propcalc.tools;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import jedrzejbronislaw.propcalc.lang.Internationalization;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class MyFXMLLoader<T extends Initializable> {

	protected final static String MAIN_DIR = "/fxml";
	private static final String lang = Internationalization.RESOURCE_LOCATION;
	
	@RequiredArgsConstructor
	public static class NodeAndController<T>{
		@NonNull @Getter private Node node;
		@NonNull @Getter private T controller;
	}
	

	private URL url(String resource) {
		return getClass().getResource(MAIN_DIR + "/"  + resource);
	}
	
	public NodeAndController<T> create(String fxmlFilePath) {
		FXMLLoader fxmlLoader = new FXMLLoader();

		fxmlLoader.setLocation(url(fxmlFilePath));
		fxmlLoader.setResources(ResourceBundle.getBundle(lang));

    	Node node;
		try {
			node = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    	
		return new NodeAndController<T>(node, fxmlLoader.getController());
	}
}
