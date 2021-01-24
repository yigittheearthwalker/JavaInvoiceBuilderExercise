package com.domain;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Invoice {

	static Random random = new Random();
	static String currency = "USD";
	static double vat = 0.18;
	
	// To Build the invoice
	public static void build(Map<String, Double> inventory) {
		
		invoiceInitiator();
		logoBuilder();
		headerBuiler();
		
		int numberOfItemsPurchased = random.nextInt(8) + 1;
		ArrayList<String> itemList = new ArrayList<String>(inventory.keySet());
		double total = 0.0; // Total of all items purchased
		
		for (int i = 0; i < numberOfItemsPurchased; i++) {
			int itemIndex = random.nextInt(itemList.size());
			String item = itemList.get(itemIndex);
			itemList.remove(itemIndex);
			int quantityPurchased = random.nextInt(5) + 1;
			double price = inventory.get(item);
			double totalAmount = price * quantityPurchased;
			total += totalAmount;
			
			inventoryItemBuilder(i + 1, item, quantityPurchased, price, totalAmount);
		}
		double vatAmount = total * vat;
		footerBuilder(total, vatAmount);
		
	}
	
	static void logoBuilder() {
		System.out.printf(Formats.LOGO_FORMAT, 
				" _____                 _            ____        _ _     _           \n" + 
				"|_   _|               (_)          |  _ \\      (_) |   | |          \n" + 
				"  | |  _ ____   _____  _  ___ ___  | |_) |_   _ _| | __| | ___ _ __ \n" + 
				"  | | | '_ \\ \\ / / _ \\| |/ __/ _ \\ |  _ <| | | | | |/ _` |/ _ \\ '__|\n" + 
				" _| |_| | | \\ V / (_) | | (_|  __/ | |_) | |_| | | | (_| |  __/ |   \n" + 
				"|_____|_| |_|\\_/ \\___/|_|\\___\\___| |____/ \\__,_|_|_|\\__,_|\\___|_|   \n" + 
				"                                                                    \n" + 
				"                                                                    \n" + 
				"");
	}
	
	static void headerBuiler() {
		System.out.printf(Formats.HEADER_FORMAT, "No", "Item", "Quantity", "Price", "Total Amount");
		System.out.println("------------------------------------------------------------------------------");
	}
	static void inventoryItemBuilder(int no, String item, int quantityPurchased, double price, double totalAmount) {
		String totalAmountWithCurrency =  Double.toString(totalAmount).concat(" " + currency);
		System.out.printf(Formats.INVOICE_ITEM_FORMAT, no, item, quantityPurchased, price, totalAmountWithCurrency);
	}
	static void footerBuilder(double total, double vatAmount) {
		String totalWithCurrency = Double.toString(total).concat(" " + currency);
		String vatWithCurrency = Double.toString(vatAmount).concat(" " + currency);
		String grandTotalWithCurrency =  Double.toString(total + vatAmount).concat(" " + currency);
		System.out.println("------------------------------------------------------------------------------\n");
		System.out.printf(Formats.FOOTER_FORMAT, "Signature", "Total", totalWithCurrency, "VAT", vatWithCurrency, "Grand Total", grandTotalWithCurrency);

	}

	
	static void invoiceInitiator () {
		int invoiceNumber = random.nextInt(Integer.MAX_VALUE);
		Locale locale = new Locale("tr", "TR");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(new Date());
		
		System.out.printf(Formats.INITIATION_FORMAT, "Invoice Number", invoiceNumber, "Date", date);
	}
}
