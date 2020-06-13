package anahuerta.tfg.electronicsstorev4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anahuerta.tfg.electronicsstorev4.domain.Cart;
import anahuerta.tfg.electronicsstorev4.domain.Component;
import anahuerta.tfg.electronicsstorev4.service.ElectronicsStoreService;

@RestController
@RequestMapping("/store")
public class ElectronicsStoreController {
	private final ElectronicsStoreService storeService;
	
	@Autowired
	public ElectronicsStoreController(final ElectronicsStoreService storeService) {
		this.storeService = storeService;
	}
	
	@GetMapping("/cart")
	List<Component> getCartItems() {
		return storeService.getCartItems();
	}
	
	//@PostMapping(path = "/purchase", consumes = "application/json", produces = "application/json")
	@PostMapping("/purchase")
	public boolean addToCart(@RequestBody Integer reference) {
	    return storeService.addToCart(reference);
	}
		
	@PostMapping("/checkout")
	public Cart checkout(){
		return storeService.checkout();
	}
		
	@PatchMapping("/checkout/confirmation")
	public void confirm() {
		storeService.confirm();
	}
	
	

}
