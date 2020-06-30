package anahuerta.tfg.electronicsstorev4.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import anahuerta.tfg.electronicsstorev4.domain.Cart;
import anahuerta.tfg.electronicsstorev4.domain.Component;
import anahuerta.tfg.electronicsstorev4.domain.User;
import anahuerta.tfg.electronicsstorev4.domain.request.RequestSignUp;
import anahuerta.tfg.electronicsstorev4.persistence.component.ComponentRepository;
import anahuerta.tfg.electronicsstorev4.persistence.orders.OrdersRepository;
import anahuerta.tfg.electronicsstorev4.persistence.user.UserRepository;
import anahuerta.tfg.electronicsstorev4.service.ElectronicsStoreService;

@Service
public class ElectronicsStoreServiceImpl implements ElectronicsStoreService{
	Cart cart = new Cart();
	OrdersRepository orderRepository;
	UserRepository userRepository;
	ComponentRepository componentRepository;
	
	public ElectronicsStoreServiceImpl(OrdersRepository orderRepository, 
			UserRepository userRepository, ComponentRepository componentRepository) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
		this.componentRepository = componentRepository;
	}
	
	public boolean addToCart(Integer reference) {
		if(componentRepository.getStockByReference(reference)>0) {
			cart.addToCartByRef(reference);
			return true;
		}
		return false;
	}
	
	@Override
	public Cart checkout() {
		return cart;
	}
	
	@Override
	public List<Component> getCartItems() {
		//getting a List of Components from a List of their references
		List<Component> items = new ArrayList<Component>();
		Iterator<Integer> it = cart.getCartItemsReferences().iterator();
		while(it.hasNext()) {
			Integer reference = it.next();
			Optional<Component> opt = componentRepository.findById(reference);
			if(opt.isPresent()) {
				items.add(opt.get());
			}
		}
		return items;
	}
	
	public void confirm() {
		List<Component> items = getCartItems();
		Iterator<Component> it = items.iterator();
		while(it.hasNext()) {
			Component c = it.next();
			componentRepository.updateStockByReference(c.getReference(), c.getStock()-1);
		}
		
	}

	@Override
	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public void createUser(RequestSignUp requestSignUp) {
		userRepository.createUser(requestSignUp);
		
	}
	
	

}
