package jedrzejbronislaw.propcalc.view.percentUnit;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import jedrzejbronislaw.propcalc.components.Clipboard;
import jedrzejbronislaw.propcalc.model.percent.CalcOptions;
import jedrzejbronislaw.propcalc.model.percent.CalcOptions.ChangeMassAction;
import jedrzejbronislaw.propcalc.model.percent.CalcOptions.ChangeProportionAction;
import jedrzejbronislaw.propcalc.view.percentUnit.calc.OptionPane;
import lombok.Setter;

public class PercentUnitController implements Initializable {

	@FXML private VBox rootBox;
	@FXML private VBox mainBox;
	
	@Setter Clipboard clipboard;
	
	private OptionPane massOption;
	private OptionPane propOption;
	
	
	public void setCalcOptions(CalcOptions calcOptions) {
		massOption.set(calcOptions.getChangeMassAction().toString());
		propOption.set(calcOptions.getChangeProportionAction().toString());
		
		massOption.setOnChangeAction(s -> {
			ChangeMassAction o = CalcOptions.ChangeMassAction.valueOf(s);
			if (o != null) calcOptions.setChangeMassAction(o);
		});
		
		propOption.setOnChangeAction(s -> {
			ChangeProportionAction o = CalcOptions.ChangeProportionAction.valueOf(s);
			if (o != null) calcOptions.setChangeProportionAction(o);
		});
	}
	
	
	public void addNode(Node node) {
		mainBox.getChildren().add(node);
	}
	
	public void copyToClipboard(ActionEvent event) {
		if (clipboard != null) clipboard.save();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<String> changeMassOptions = Stream.of(CalcOptions.ChangeMassAction      .values()).map(o -> o.toString()).collect(Collectors.toList());
		List<String> changePropOptions = Stream.of(CalcOptions.ChangeProportionAction.values()).map(o -> o.toString()).collect(Collectors.toList());
		
		massOption = new OptionPane("Change Mass",       changeMassOptions);
		propOption = new OptionPane("Change Proportion", changePropOptions);
		
		rootBox.getChildren().add(massOption);
		rootBox.getChildren().add(propOption);
	}
}
