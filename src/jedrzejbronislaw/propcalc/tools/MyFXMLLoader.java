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
	
	
	private static String path(String resource) {
		return MAIN_DIR + "/"  + resource;
	}

	private URL url(String resource) {
		return getClass().getResource(path(resource));
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
	
	public static boolean create(String fxmlFilePath, Node node) {
		FXMLLoader fxmlLoader = new FXMLLoader();

		fxmlLoader.setLocation(node.getClass().getResource(path(fxmlFilePath)));
		fxmlLoader.setResources(ResourceBundle.getBundle(lang));
		
		fxmlLoader.setRoot(node);
		fxmlLoader.setController(node);
		
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
