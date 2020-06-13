package anahuerta.tfg.electronicsstorev4.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import anahuerta.tfg.electronicsstorev4.domain.Category;
import anahuerta.tfg.electronicsstorev4.domain.Component;

public class Component {
	@Id
	@GeneratedValue
	@Column(name = "reference")
	public Integer reference;
	
	@Column(name = "category")
	public Category category;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "price")
	public Double price;
	
	@Column(name = "stock")
	public Integer stock;
	
	public Component() {}
	
	public Category getCategory() {
		return category;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public Integer getReference() {
		return reference;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		
		if(this.getClass() != o.getClass())
			return false;
		
		final Component c = (Component) o;
		if(!Objects.equals(this.name, c.name))
			return false;
			
		if(!Objects.equals(this.category, c.category))
			return false;
		
        if (!Objects.equals(this.price, c.price))
            return false;
        
        if (!Objects.equals(this.reference, c.reference))
            return false;
        
        if (!Objects.equals(this.stock, c.stock))
            return false;
        
        return true;
	}
}
