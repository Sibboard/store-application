/**
 * 
 */
package store.services.impl;

import java.util.Arrays;
import java.util.Objects;

import store.entities.User;
import store.services.UserManagementService;

/**
 * @author Gabriele
 *
 */
public class DefaultUserManagementService implements UserManagementService {
	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";
	
	private static final int DEFAULT_USER_CAPACITY = 20;
	
	private static DefaultUserManagementService instance;
	
	private User[] users;
	private int lastUserIndex;
	
	{
			users = new User[DEFAULT_USER_CAPACITY];
	}
	
	private DefaultUserManagementService() {
	}
	
	@Override
	public String registerUser(User user) {
		if (user == null) return NO_ERROR_MESSAGE;
		
		String checkEmail = checkEmail(user.getEmail());
		if(checkEmail != null && !checkEmail.isEmpty()) {
			return checkEmail;
		}
		
		if(lastUserIndex >= users.length) {
			users = Arrays.copyOf(users, users.length << 1);
		}
		
		users[lastUserIndex++] = user;
		return NO_ERROR_MESSAGE;
	}
	
	private String checkEmail(String email) {
		if (email == null || email.isEmpty()) return EMPTY_EMAIL_ERROR_MESSAGE;
		
		for(User user : users) {
			if (user == null) break;
			if (user.getEmail().equalsIgnoreCase(email) && user.getEmail() != null) {
				return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
			}
		}
		return NO_ERROR_MESSAGE;
	}

	@Override
	public User[] getUsers() {
		return Arrays.stream(users)
						.filter(Objects::nonNull)
						.toArray(User[]::new);
	}

	@Override
	public User getUserByEmail(String userEmail) {
		for(User user: users) {
			if(user != null && user.getEmail().equalsIgnoreCase(userEmail)) {
				return user;
			}
		}
		return null;
	}
	
	void clearServiceState() {
		lastUserIndex = 0;
		users = new User[DEFAULT_USER_CAPACITY];
	}
	
	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

}
