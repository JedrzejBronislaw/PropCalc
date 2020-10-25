package jedrzejbronislaw.propcalc.view.substancesSetting.item;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import jedrzejbronislaw.propcalc.substances.Substance;

public class SubstanceCellFactory implements Callback<ListView<Substance>, ListCell<Substance>> {

	public static final String MM_UNIT = "g/mol";
	
	
	@Override
	public ListCell<Substance> call(ListView<Substance> param) {
		return new ListCell<Substance>() {
			@Override
			protected void updateItem(Substance substance, boolean empty) {
				super.updateItem(substance, empty);
				
				if (empty || substance == null)
					setText(null); else
					setText(generateText(substance));
			}
		};
	}

	private String generateText(Substance substance) {
		return substance.getName() + " (" + substance.getMolarMass() + " " + MM_UNIT + ")";
	}
}
