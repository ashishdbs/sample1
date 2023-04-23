package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	// this is for listner
	
	@KafkaListener(topics = "", groupId = "group_id")
	public void consume(String message)
	{
	   System.out.println(message);	
	}

}
