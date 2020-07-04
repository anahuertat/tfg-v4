package anahuerta.tfg.electronicsstorev4.persistence.user;

import java.util.List;

import anahuerta.tfg.electronicsstorev4.domain.Orders;
//import anahuerta.tfg.electronicsstorev4.domain.request.RequestSignUp;
import anahuerta.tfg.electronicsstorev4.domain.request.RequestSignUp;

public interface UserRepositoryCustom {
	
	List<Orders> getOrdersById(Integer user_id);
	
	void createUser(RequestSignUp requestSignUp);
	
	void createUserOrder(Integer user_id, Integer order_number);
}
