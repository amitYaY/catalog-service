package com.fitkart.catalog.impl;

import java.util.Arrays;
import java.util.List;

import com.fitkart.catalog.api.CatalogService;

public class CatalogServiceImpl implements CatalogService {
	
	public List<String> getCatalog() {
		
		return Arrays.asList("One", "Two", "Three");
	}

}
