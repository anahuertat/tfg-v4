package anahuerta.tfg.electronicsstorev4.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	public Integer user_id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "last_name")
	public String last_name;
	
	@Column(name = "address")
	public String address;
	
	@Column(name = "email")
	public String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> orders;
	
	public User() {}
	
	public Integer getUserId() {
		return user_id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public String getAddress() {
		return address;
	}

}
