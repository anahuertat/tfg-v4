package anahuerta.tfg.electronicsstorev4.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	List<Integer> cartItemsReferences = new ArrayList<Integer>();
    
	public void addToCartByRef(Integer reference) {
		cartItemsReferences.add(reference);
	}
	
	public List<Integer> getCartItemsReferences(){
		return cartItemsReferences;
	}
	

}
