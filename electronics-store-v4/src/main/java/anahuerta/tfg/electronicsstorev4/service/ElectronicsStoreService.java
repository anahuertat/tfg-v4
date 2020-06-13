package anahuerta.tfg.electronicsstorev4.service;

import java.util.List;

import anahuerta.tfg.electronicsstorev4.domain.Cart;
import anahuerta.tfg.electronicsstorev4.domain.Component;

public interface ElectronicsStoreService {

	boolean addToCart(Integer reference);
	
	Cart checkout();
	
	List<Component> getCartItems();
	
	void confirm();
}
