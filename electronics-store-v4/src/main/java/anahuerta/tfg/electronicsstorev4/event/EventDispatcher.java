package anahuerta.tfg.electronicsstorev4.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventDispatcher {
	
	private RabbitTemplate rabbitTemplate;
	
	private String orderExchange;
	
	private String orderCreatedRoutingKey;
	
	@Autowired
	public EventDispatcher(final RabbitTemplate rabbitTemplate,  
			@Value("${orders.exchange}") final String orderExchange,
            @Value("${orders.created.key}") final String orderCreatedRoutingKey) {
		this.rabbitTemplate = rabbitTemplate;
		this.orderExchange = orderExchange;
		this.orderCreatedRoutingKey = orderCreatedRoutingKey;
		
	}
	
	public void send(final OrderCreatedEvent orderCreatedEvent) {
		rabbitTemplate.convertAndSend(orderExchange, orderCreatedRoutingKey, orderCreatedEvent);
	}

}
