package store.entities.impl;

import store.entities.Product;

public class DefaultProduct implements Product {
	
	private String productName;
	private String categoryName;
	private double price;
	private int id;
	
	public DefaultProduct() {
	}
	
	public DefaultProduct(String productName, String categoryName, double price, int id) {
		
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
		this.id = id;
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

	@Override
	public String toString() {
		return "Product Name=" + productName + ", categoryName=" + categoryName + ", price=" + price
				+ ", id=" + id;
	}
	
	

}
