package anahuerta.tfg.electronicsstorev4.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import anahuerta.tfg.electronicsstorev4.domain.Cart;
import anahuerta.tfg.electronicsstorev4.domain.Component;
import anahuerta.tfg.electronicsstorev4.domain.Orders;
import anahuerta.tfg.electronicsstorev4.domain.User;
import anahuerta.tfg.electronicsstorev4.domain.request.RequestOrder;
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
	
	public void confirm(User user) {
		List<Component> items = getCartItems();
		Iterator<Component> it = items.iterator();
		List<Integer> references = new ArrayList<>();
		while(it.hasNext()) {
			Component c = it.next();
			references.add(c.getReference());
			componentRepository.updateStockByReference(c.getReference(), new Integer(c.getStock().intValue()-1));
		}
		RequestOrder requestOrder = new RequestOrder(user.getAddress(), user.getUserId());
		orderRepository.createOrders(requestOrder);
		List<Orders> userOrders = orderRepository.findOrdersDesc();
		Integer order_number = userOrders.get(0).getOrderNumber();
		orderRepository.addReferencesToOrder(order_number, references);
		userRepository.createUserOrder(user.getUserId(), order_number);
		
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
