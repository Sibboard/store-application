package store.entities.impl;

import store.entities.User;

public class DefaultUser implements User {
	
	private String firstName;
	private String lastName;
	private int id;
	private String password;
	private String email;
	
	private static int userCounter = 0;
	
	{
		id = ++userCounter;
	}
	
	public DefaultUser(){
	}
	
	public DefaultUser(String firstName, String lastName, String password, String email ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setPassword(String newPassword) {
		if (newPassword == null) return;
		this.password = newPassword;

	}

	@Override
	public void setEmail(String newEmail) {
		if (newEmail == null) return;
		this.email = newEmail;
	}

	@Override
	public String toString() {
		return "First Name=" + this.getFirstName() + ", Last Name=" + this.lastName + ", Id=" + this.getId() + ", Email=" + this.getEmail() + "]";
	}
	
	void clearState() {
		userCounter = 0;
	}
	

}
