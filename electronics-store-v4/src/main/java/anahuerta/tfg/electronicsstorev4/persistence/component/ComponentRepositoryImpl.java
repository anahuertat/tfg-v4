package anahuerta.tfg.electronicsstorev4.persistence.component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ComponentRepositoryImpl implements ComponentRepositoryCustom{
	@PersistenceContext
	EntityManager entityManager;
	
	//get stock of a component
	public int getStockByReference(Integer reference) {
		Query query = entityManager.createNativeQuery("SELECT c.stock FROM Component c WHERE c.reference = ?");
		query.setParameter(1, reference);
		return (int) query.getResultList().get(0);
	}

	//update stock of a component
	public void updateStockByReference(Integer reference, int stock) {
		Query query = entityManager.createNativeQuery("UPDATE Component c set c.stock = ? where reference = ?");
		query.setParameter(1, stock);
		query.setParameter(2, reference);
	}

}
