package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class KafkaConfig {
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory()
	{
		Map<String,Object> map = new HashMap<>();
		map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		map.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<>(map);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory concurrentKafkaListenerContainerFactory()
	{
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
