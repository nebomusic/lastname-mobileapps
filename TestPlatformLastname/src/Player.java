
public class Player {
	// Fields
	private String name;
	private int position;
	private String email;
	
	// Constructor
	public Player (String n) {
		name = n;
	}
	
	// Methods for our Player
	public String getName() {
		return name;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int p) {
		position = p;
	}
	
	// email setter
	public void setEmail(String e) {
		email = e;
	}
	
	// email getter
	public String getEmail() {
		return email;
	}

}












