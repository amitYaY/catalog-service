package com.fitkart.catalog.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/catalog")
public interface CatalogService {

	@GetMapping("/get")
	public List<String> getCatalog();

}
