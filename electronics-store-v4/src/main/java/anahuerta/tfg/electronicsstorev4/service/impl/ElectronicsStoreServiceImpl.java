package anahuerta.tfg.electronicsstorev4.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import anahuerta.tfg.electronicsstorev4.domain.Cart;
import anahuerta.tfg.electronicsstorev4.domain.Component;
import anahuerta.tfg.electronicsstorev4.persistence.ComponentRepository;
import anahuerta.tfg.electronicsstorev4.persistence.OrderRepository;
import anahuerta.tfg.electronicsstorev4.persistence.UserRepository;
import anahuerta.tfg.electronicsstorev4.service.ElectronicsStoreService;

@Service
public class ElectronicsStoreServiceImpl implements ElectronicsStoreService{
	Cart cart = new Cart();
	OrderRepository orderRepository;
	UserRepository userRepository;
	ComponentRepository componentRepository;
	
	public ElectronicsStoreServiceImpl(OrderRepository orderRepository, 
			UserRepository userRepository, ComponentRepository componentRepository) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
		this.componentRepository = componentRepository;
	}
	
	@Override
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
			items.add(componentRepository.findComponentById(it.next()));
		}
		return items;
	}
	
	@Override
	public void confirm() {
		List<Component> items = getCartItems();
		Iterator<Component> it = items.iterator();
		while(it.hasNext()) {
			componentRepository.updateStockByReference(it.next().getReference());
		}
	}

}
