package main.java.walsh.springwebapps.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.walsh.springwebapps.data.User;
import main.java.walsh.springwebapps.interfaces.UserRepository;

/**
 * This class handles user related interactions with the database
 * @author John
 *
 */
@Repository
public class JdbcUserLink implements UserRepository {

	private JdbcOperations jdbc;
	
	@Autowired
	public JdbcUserLink(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}
	
	/**
	 * Save user record using the JDBC interface
	 */
	public User saveUser(User User) {
		jdbc.update(
			"insert into Users (username, password, first_name, last_name, email)" +
			" values (?, ?, ?, ?, ?)",
			User.getUsername(),
			User.getPassword(),
			User.getFirstName(),
			User.getLastName(),
			User.getEmail()
		);
		return User;
	}
	
	/**
	 * Find user record by the 'username' field using the JDBC interface
	 */
	public User findByUsername(String username) {
		return jdbc.queryForObject(
			"select id, username, null, first_name, last_name, email from Users where username=?",
		new UserRowMapper(), username);
	}
	
	/**
	 * Find recent joined users using the JDBC interface
	 */
	public List<User> findRecentUsers() {
		return jdbc.query(
			"select id, username, null, first_name, last_name, email" +
			" from Users" +
			" order by first_name desc limit 10", 
		new UserRowMapper());
	}
	  
	/**
	 * Maps rows from the database to an object and viceversa
	 * @author John
	 *
	 */
	private static class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(
				rs.getLong("id"),
				rs.getString("username"),
				null,
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getString("email")
			);
		}
	}
}
