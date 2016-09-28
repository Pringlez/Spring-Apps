package ie.walsh.springwebapps.interfaces;

import ie.walsh.springwebapps.data.User;

public interface UserRepository {
	User saveUser(User spitter);	  
	User findByUsername(String username);
}
