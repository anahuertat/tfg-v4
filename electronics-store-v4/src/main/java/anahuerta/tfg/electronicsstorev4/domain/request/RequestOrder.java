package anahuerta.tfg.electronicsstorev4.domain.request;

public class RequestOrder {
	private String address;
	private Integer user_id;
	
	public RequestOrder(String address, Integer user_id) {
		this.address = address;
		this.user_id = user_id;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public Integer getUserId() {
		return this.user_id;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setUserId(Integer id) {
		this.user_id = id;
	}

}
