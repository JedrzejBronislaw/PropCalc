package jedrzejbronislaw.propcalc.substances;

import java.util.ArrayList;
import java.util.List;

public class Substances {

	static public List<Substance> all() {
		List<Substance> list = new ArrayList<>();
		
		list.add(new Substance("OLA", "Oleanolic acid", "C30H48O3", 456.7f));
		list.add(new Substance("OA", "Oleic acid", "C18H34O2", 282.46f));

		list.add(new Substance("DPPC", "Dipalmitoylphosphatidylcholine", "C40H80NO8P", 734.053f));
		list.add(new Substance("POPC", "", "C42H82NO8P", 760.091f));
		list.add(new Substance("POPG", "", "C40H77O10P", 749f));
		list.add(new Substance("cholesterol", "Cholesterolum", "C27H46O", 386.65f));
		
		return list;
	}
}
