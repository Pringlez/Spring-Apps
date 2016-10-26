package main.java.walsh.springwebapps.interfaces;

import java.util.List;

import main.java.walsh.springwebapps.data.User;

/**
 * The user repository interface to be implemented
 * @author John
 *
 */
public interface UserRepository {
	public User saveUser(User user);
	public User findByUsername(String username);
	public List<User> findRecentUsers();
}
