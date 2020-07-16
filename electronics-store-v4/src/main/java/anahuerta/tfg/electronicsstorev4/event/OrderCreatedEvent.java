package anahuerta.tfg.electronicsstorev4.event;

import java.io.Serializable;


public class OrderCreatedEvent implements Serializable{

	private static final long serialVersionUID = -3133721444094820776L;
	
	private final Integer orderNumber;
	private final Integer userId;
	private final int points;
	
	public OrderCreatedEvent(Integer order_number, Integer userId, int points) {
		this.orderNumber = order_number;
		this.userId = userId;
		this.points = points;
	}
	
	public Integer getOrderNumber() {
		return orderNumber;
	}
	
	public Integer setUserId() {
		return userId;
	}
	
	public int getPoints() {
		return points;
	}
	
	
}
