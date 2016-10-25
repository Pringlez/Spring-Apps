package main.java.walsh.springwebapps.interfaces;

import main.java.walsh.springwebapps.data.User;

/**
 * The user repository interface to be implemented
 * @author John
 *
 */
public interface UserRepository {
	User saveUser(User spitter);	  
	User findByUsername(String username);
}
