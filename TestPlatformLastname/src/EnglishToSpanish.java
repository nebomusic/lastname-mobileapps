import java.util.ArrayList;
import java.util.List;


public class EnglishToSpanish {
	// Field for List to String Arrays
	private List<String []> dictionary;
	
	public EnglishToSpanish() {
		dictionary = new ArrayList<String []>(0);
		addEntry("this", "esta");
		addEntry("dog", "pero");
		addEntry("is", "es");
		addEntry("a", "un");
		addEntry("father", "padre");
	}
	
	public void addEntry(String e, String s) {
		String entry [] = {e, s};
		dictionary.add(entry);
	}
	
	// translate function
	public String translate(String s) {
		String result = "";
		
		// Search for the translation
		for (int w = 0; w < dictionary.size(); w++) {
			if (s.equals(dictionary.get(w)[0])) {
				result = dictionary.get(w)[1]; // get match
			}
		}
		
		if (result.equals("")) {
			result = s; // set to incoming word
		}
		
		return result;
	} // end translate

} // end class













