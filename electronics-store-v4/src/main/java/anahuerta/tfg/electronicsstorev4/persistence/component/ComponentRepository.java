package anahuerta.tfg.electronicsstorev4.persistence.component;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import anahuerta.tfg.electronicsstorev4.domain.Component;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Integer>, ComponentRepositoryCustom{
	//get component
	Optional<Component> findById(Integer reference);
}
