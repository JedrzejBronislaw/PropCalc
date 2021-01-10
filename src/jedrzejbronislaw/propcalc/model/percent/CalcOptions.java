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
	
	private ChangeMassAction changeMassAction = ChangeMassAction.CHANGE_OTHER_MASSES;
}
