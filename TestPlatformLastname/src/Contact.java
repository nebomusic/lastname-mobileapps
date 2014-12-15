
public class Contact {
	// Fields
	private String lastname;
	private String firstname;
	private String email;
	private String address;
	private String cellphone;
	
	
	// Constructor
	public Contact(String ln, String fn) {
		lastname = ln;
		firstname = fn;
	}
	
	// Methods
	public String getName() {
		return firstname + " " + lastname; // Concantination
	}
	
	public void setEmail(String em) {
		email = em;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
