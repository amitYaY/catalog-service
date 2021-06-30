package com.fitkart.catalog.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CatalogUpdateEventManager {
	
	@KafkaListener(containerFactory = "kafkaListenerContainerFatcory", topics = "CATALOG_EVENTS")
	public void listenCatalogEvents(String message) {
		System.out.println("Catalog Event: "+message);
	}
	

}
