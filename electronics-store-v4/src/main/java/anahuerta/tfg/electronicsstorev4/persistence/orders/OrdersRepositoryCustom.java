package anahuerta.tfg.electronicsstorev4.persistence.orders;

import java.util.List;

import anahuerta.tfg.electronicsstorev4.domain.Orders;
import anahuerta.tfg.electronicsstorev4.domain.request.RequestOrder;

public interface OrdersRepositoryCustom {
	//create order
	void createOrders(RequestOrder requestOrder);
	
	void addReferencesToOrder(Integer order_number, List<Integer> references);
	
	List<Orders> findOrdersDesc();
}
