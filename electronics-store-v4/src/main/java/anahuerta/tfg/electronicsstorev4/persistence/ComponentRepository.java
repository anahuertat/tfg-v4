package anahuerta.tfg.electronicsstorev4.persistence;

import org.springframework.data.repository.CrudRepository;

import anahuerta.tfg.electronicsstorev4.domain.Component;

public interface ComponentRepository extends CrudRepository<Component, Integer>{
	//get stock of a component
	int getStockByReference(Integer reference);
	
	//update stock of a component
	void updateStockByReference(Integer reference);
	
	//get component 
	Component findComponentById(Integer reference);
}
