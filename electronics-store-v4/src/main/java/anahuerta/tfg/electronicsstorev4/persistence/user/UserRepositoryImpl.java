package anahuerta.tfg.electronicsstorev4.persistence.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import anahuerta.tfg.electronicsstorev4.domain.User;
import anahuerta.tfg.electronicsstorev4.domain.request.RequestSignUp;
import anahuerta.tfg.electronicsstorev4.domain.Orders;

public class UserRepositoryImpl implements UserRepositoryCustom{
	@PersistenceContext
	EntityManager entityManager;

	//get user's orders
	public List<Orders> getOrdersById(Integer user_id) {
		Query query = entityManager.createNativeQuery("SELECT * FROM User u WHERE u.user_id = ?");
		query.setParameter(1, user_id);
		User u = (User) query.getResultList().get(0);
		return u.orders;
	}

	@Transactional
	public int createUser(RequestSignUp requestSignUp) {
		entityManager.joinTransaction();
		entityManager.createNativeQuery("INSERT INTO User (address, email, last_name, name, password) VALUES (?,?,?,?,?)")
			.setParameter(1, requestSignUp.getAddress())
			.setParameter(2, requestSignUp.getEmail())
			.setParameter(3, requestSignUp.getLastName())
			.setParameter(4, requestSignUp.getName())
			.setParameter(5, requestSignUp.getPassword())
			.executeUpdate();
		return 0;
	}
	

}
