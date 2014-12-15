import java.util.ArrayList;
import java.util.List;


public class EnglishToKlingon {
	// Fields
	private List <String []> dictionary;
	
	public EnglishToKlingon () {
		dictionary = new ArrayList<String []>(0);
		addEntry("hello", "nuqneH");
		addEntry("yes", "Hija'");
	}
	
	public void addEntry(String e, String s) {
		String entry [] = {e, s};
		dictionary.add(entry);
	}
	
	
	

}
