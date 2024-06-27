package user;

public class Users {

	private int userNumber;
	private String firstName;
	private String lastName;
	private String email;
	private int contactNumber;
	private String userName;
	
	public Users(int userNumber, String firstName, String lastName, String email, int contactNumber, String userName) {
		this.setUserNumber(userNumber);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setContactNumber(contactNumber);
		this.setUserName(userName);
	}
	
	public int getUserNumber() {
		return userNumber;
	}
	
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
