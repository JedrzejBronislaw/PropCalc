package jedrzejbronislaw.propcalc.model.molecules.substances;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Substances {
	
	@Getter
	@AllArgsConstructor
	public static class SubstanceFile {
		private List<Substance> substances;
	}
	
	
	private static final String FILE_NAME = "substances.json";

	
	static private List<Substance> defaultList() {
		List<Substance> list = new ArrayList<>();
		
		list.add(new Substance("OLA", "Oleanolic acid", "C30H48O3", 456.7f));
		list.add(new Substance("OA", "Oleic acid", "C18H34O2", 282.46f));

		list.add(new Substance("DPPC", "Dipalmitoylphosphatidylcholine", "C40H80NO8P", 734.053f));
		list.add(new Substance("POPC", "", "C42H82NO8P", 760.091f));
		list.add(new Substance("POPG", "", "C40H77O10P", 749f));
		list.add(new Substance("cholesterol", "Cholesterolum", "C27H46O", 386.65f));
		
		return list;
	}
	
	static private void saveDefault() {
		saveToFile(defaultList());
	}
	
	static public boolean saveToFile(List<Substance> substances) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try (FileWriter writer = new FileWriter(FILE_NAME)) {
			
			writer.write(gson.toJson(new SubstanceFile(substances)));
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	static private List<Substance> loadFromFile() {
		SubstanceFile substanceFile;
		
		try (FileReader reader = new FileReader(FILE_NAME)) {
			
			String json = Files.readString(Paths.get(FILE_NAME));
			substanceFile = new Gson().fromJson(json, SubstanceFile.class);
			
		} catch (IOException e) {
			return null;
		}

		return substanceFile.getSubstances();
	}
	
	static public List<Substance> load() {
		List<Substance> list = loadFromFile();
		
		if (list == null) saveDefault();
		list = loadFromFile();
		
		return list;
	}
}
