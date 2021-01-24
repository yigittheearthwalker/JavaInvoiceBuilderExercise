package com.domain;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	
	//To Add Items to the Inventory
	public static HashMap<String, Double> build(HashMap<String, Double>inventory) {
		inventory.put("Jacket", 399.99);
		inventory.put("Gloves", 24.50);
		inventory.put("T-Shirt", 33.40);
		inventory.put("Sweater", 55.20);
		inventory.put("Trousers", 69.99);
		inventory.put("Hat", 19.90);
		inventory.put("Bag", 28.75);
		inventory.put("Shoes", 129.99);
		
		return inventory;
	}
}
