package store.entities;

import store.entities.Product;

public interface Cart {
	
	boolean isEmpty();

	void addProduct(Product productById);

	Product[] getProducts();

	void clear();

}
