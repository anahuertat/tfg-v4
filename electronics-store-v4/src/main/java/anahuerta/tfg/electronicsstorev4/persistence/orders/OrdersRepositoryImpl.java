package anahuerta.tfg.electronicsstorev4.persistence.orders;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import anahuerta.tfg.electronicsstorev4.domain.Component;
import anahuerta.tfg.electronicsstorev4.domain.Orders;

public class OrdersRepositoryImpl implements OrdersRepositoryCustom{
	@PersistenceContext
	EntityManager entityManager;
	
	//create an order
	@Transactional
	public void createOrders(Orders order) {
		Iterator<Component> it = order.componentsInThisOrder.iterator();
		while(it.hasNext()) {
			Component c = it.next();
			entityManager.joinTransaction();
			entityManager.createNativeQuery("INSERT INTO Orders o (address, user_id, reference) VALUES (?,?,?)")
				.setParameter(1, order.getAddress())
				.setParameter(2, order.user.getUserId())
				.setParameter(3, c.getReference())
				.executeUpdate();		
		}
	}

}
