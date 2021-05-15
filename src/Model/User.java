package Model;

public class User {
	protected int userId;
	protected String email;
	protected String fName;
	protected String lName;
	protected String address;
	protected String phone;
	protected int pincode;
	protected String city;
	protected String gender;
	protected String role;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public User(int userId, String email, String fName, String lName, String address, String phone, int pincode, String city, String gender, String role) {
		this.userId = userId;
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
		this.pincode = pincode;
		this.city = city;
		this.gender = gender;
		this.role = role;
	}
	
	public User(String email, String fName, String lName) {
		this.email = email;
		this.fName = fName;
		this.lName = lName;
	}
	
	public User() {
		
	}
}
