package anahuerta.tfg.electronicsstorev4.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import anahuerta.tfg.electronicsstorev4.domain.Component;
import anahuerta.tfg.electronicsstorev4.domain.User;

@Entity
public class Orders {
	@Id
	@GeneratedValue
	@Column(name = "order_number")
	public Integer order_number;
	
	@Column(name = "address")
	public String address;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	public User user;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		name = "order_has_component",
		joinColumns = @JoinColumn(name= "order_number"),
		inverseJoinColumns = @JoinColumn(name = "reference"))
	public Set<Component> componentsInThisOrder;
	
	public Orders() {}
	
	public Integer getOrderNumber() {
		return order_number;
	}
	
	public String getAddress() {
		return address;
	}
	
}
