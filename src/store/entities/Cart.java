package store.entities;

public interface Cart {
	
	boolean isEmpty();

	void addProduct(Product product);

	Product[] getProducts();

	void clear();

}
