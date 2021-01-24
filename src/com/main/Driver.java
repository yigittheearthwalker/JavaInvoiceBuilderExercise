package com.main;

import java.util.HashMap;
import com.domain.Inventory;
import com.domain.Invoice;

public class Driver {

	public static void main(String[] args) {
		
		HashMap<String, Double> inventory = Inventory.build();
		
		Invoice.build(inventory);
		
	
	}
	
	

}
