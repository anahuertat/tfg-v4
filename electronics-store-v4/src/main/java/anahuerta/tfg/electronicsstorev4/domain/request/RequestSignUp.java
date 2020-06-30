package anahuerta.tfg.electronicsstorev4.domain.request;

public class RequestSignUp {
	private String email;
	private String password;
	private String address;
	private String name;
	private String last_name;
	
	public RequestSignUp() {}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
}
