package anahuerta.tfg.electronicsstorev4.persistence.component;

public interface ComponentRepositoryCustom {
	//get stock
	int getStockByReference(Integer reference);
	
	//update stock
	void updateStockByReference(Integer reference, Integer stock);
}
