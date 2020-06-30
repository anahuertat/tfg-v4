package anahuerta.tfg.electronicsstorev4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import anahuerta.tfg.electronicsstorev4.domain.Cart;
import anahuerta.tfg.electronicsstorev4.domain.Component;
import anahuerta.tfg.electronicsstorev4.domain.User;
import anahuerta.tfg.electronicsstorev4.domain.request.RequestSignUp;

@Service
public interface ElectronicsStoreService {

	boolean addToCart(Integer reference);
	
	Cart checkout();
	
	List<Component> getCartItems();
	
	void confirm();

	User login(String email, String password);

	void createUser(RequestSignUp requestSignUp);
}
