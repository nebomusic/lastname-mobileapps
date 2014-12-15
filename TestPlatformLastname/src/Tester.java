
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Make two Players
//		Player rebecca = new Player("Rebecca");
//		Player joshua = new Player("Joshua");
//		
//		System.out.println(rebecca.getName());
//		System.out.println(joshua.getName());
//		
//		rebecca.setPosition(10);
//		joshua.setPosition(8);
//		
//		rebecca.setEmail("rebecca17@marist.com");
//		joshua.setEmail("joshua22@marist.com");
//		
//		System.out.println(rebecca.getName() + "'s position is: ");
//		System.out.println(rebecca.getPosition());
//		
//		System.out.println(joshua.getName() + "'s position is: ");
//		System.out.println(joshua.getPosition());
//		
//		System.out.println(rebecca.getEmail());
		
		Contact bob = new Contact("Jones", "Bob");
		Contact michaud = new Contact("Michaud", "Christopher");
		
		System.out.println(michaud.getName());
		System.out.println(bob.getName());
		
		EnglishToSpanish dictionary = new EnglishToSpanish();
		System.out.println(dictionary.translate("dog"));
		dictionary.addEntry("mother", "madre");
		System.out.println(dictionary.translate("mother"));
		
	} // end main

} // end class Tester









