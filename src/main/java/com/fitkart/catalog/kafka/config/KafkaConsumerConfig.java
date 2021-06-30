package com.fitkart.catalog.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Bean
	public Map<String, Object> kafkaConsumerConfig() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "bootstrap.servers");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer.group.id");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "enable.auto.commit");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return props;
	}

	@Bean
	public ConsumerFactory<String, String> kafkaConsumerFactory() {
		DefaultKafkaConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<String, String>(
				kafkaConsumerConfig());
		return consumerFactory;
	}

//	@Bean
//	public ConcurrentMessageListenerContainer<String, String> kafkaListenerContainer() {
//		ContainerProperties containerProperties = new ContainerProperties("Topic");
//		containerProperties.setMessageListener(containerProperties);
//		ConcurrentMessageListenerContainer<String, String> listenerContainer = new ConcurrentMessageListenerContainer<String, String>(
//				kafkaConsumerFactory(), containerProperties);
//		return listenerContainer;
//	}

	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFatcory() {

		ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		kafkaListenerContainerFactory.setConsumerFactory(kafkaConsumerFactory());
		return kafkaListenerContainerFactory;
	}

}
