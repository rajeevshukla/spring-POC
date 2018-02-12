package com.example.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Reciever {

	
	@Bean
	Queue queue() {
	 return	new Queue("CustomerQ", false);
	}
	

	@RabbitListener(queues="CustomerQ")
	public void recieve(String data) {
		System.out.println("Data found in another project:"+ data);
	}
	
	
	
}
