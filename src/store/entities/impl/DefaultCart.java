package store.entities.impl;

import java.util.Arrays;

import store.entities.Cart;
import store.entities.Product;

public class DefaultCart implements Cart {
	
	private Product[] products;
	private final int MAX_NUMBER_OF_PRODUCTS = 50;
	private int lastIndex;
	
	{
		products = new Product[MAX_NUMBER_OF_PRODUCTS];
	}

	@Override
	public boolean isEmpty() {
		if (products == null || products.length == 0) return true;
		
		for (Product product : products) {
			if (product != null) return false;
		}
		
		return true;
	}

	@Override
	public void clear() {
		products = new Product[MAX_NUMBER_OF_PRODUCTS];
		// TODO need to reset lastIndex ?
		
	}

	@Override
	public void addProduct(Product product) {
		if (product == null) return;
		
		if (lastIndex > products.length) {
			products = Arrays.copyOf(products, products.length << 1);
		}
		products[lastIndex++] = product;
	}

	@Override
	public Product[] getProducts() {
		int nonNullProductsAmount = 0;
		for (Product product : products) {
			if (product != null) nonNullProductsAmount++;
		}
		
		Product[] nonNullProducts = new Product[nonNullProductsAmount];
		for ( int i = 0, j = 0; i <= products.length; i++) {
			if (products[i] == null) continue;
			nonNullProducts[j++] = products[i];
		}
		
		return nonNullProducts;
	}

}
