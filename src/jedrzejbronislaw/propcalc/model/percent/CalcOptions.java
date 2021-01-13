package jedrzejbronislaw.propcalc.model.percent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcOptions {

	enum ChangeMassAction {
		CHANGE_PROPORTIONS,
		CHANGE_OTHER_MASSES
	}

	enum ChangeProportionAction {
		CHANGE_ALL_MASSES,
		CHANGE_ONE_MASS
	}

	private ChangeMassAction changeMassAction = ChangeMassAction.CHANGE_OTHER_MASSES;
	private ChangeProportionAction changeProportionAction = ChangeProportionAction.CHANGE_ONE_MASS;
}
