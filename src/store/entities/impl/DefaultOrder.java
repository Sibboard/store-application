package store.entities.impl;

import store.entities.Order;
import store.entities.Product;

public class DefaultOrder implements Order {

	@Override
	public boolean isCreditCardNumberValid(String userInput) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCreditCardNumber(String userInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProducts(Product[] products) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCustomerId(int customerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCustomerId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
