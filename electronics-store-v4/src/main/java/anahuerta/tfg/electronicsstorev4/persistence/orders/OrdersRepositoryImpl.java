package anahuerta.tfg.electronicsstorev4.persistence.orders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import anahuerta.tfg.electronicsstorev4.domain.Orders;
import anahuerta.tfg.electronicsstorev4.domain.request.RequestOrder;

public class OrdersRepositoryImpl implements OrdersRepositoryCustom{
	@PersistenceContext
	EntityManager entityManager;
	
	//create an order
	@Transactional
	public void createOrders(RequestOrder requestOrder) {
		entityManager.joinTransaction();
		entityManager.createNativeQuery("INSERT INTO Orders (address, user_id) VALUES (?,?)")
			.setParameter(1, requestOrder.getAddress())
			.setParameter(2, requestOrder.getUserId())
			.executeUpdate();
	}

	@Transactional
	public void addReferencesToOrder(Integer order_number, List<Integer> references) {
		Iterator<Integer> it = references.iterator();
		while(it.hasNext()) {
			Integer reference = it.next();
			entityManager.joinTransaction();
			entityManager.createNativeQuery("INSERT INTO order_has_component VALUES (?,?)")
				.setParameter(1, order_number)
				.setParameter(2, reference)
				.executeUpdate();
		}
	}


	@Override
	public List<Orders> findOrdersDesc() {
		TypedQuery<Orders> query = entityManager.createQuery("SELECT o FROM Orders o ORDER BY o.order_number DESC", Orders.class);
		List<Orders> orders = new ArrayList<Orders>();
		orders = query.getResultList();
		return orders;
	}
	
	
	
	
	
}
