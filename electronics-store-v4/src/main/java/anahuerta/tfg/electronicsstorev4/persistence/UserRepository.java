package anahuerta.tfg.electronicsstorev4.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import anahuerta.tfg.electronicsstorev4.domain.Order;
import anahuerta.tfg.electronicsstorev4.domain.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	//create user
	void createUser(User user);
	
	//get user's orders
	List<Order> getUsersOrders(Integer user_id);
}
