package anahuerta.tfg.electronicsstorev4.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anahuerta.tfg.electronicsstorev4.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom{
	
	User findByEmailAndPassword(String email, String password);
	
}
