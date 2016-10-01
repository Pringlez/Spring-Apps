package ie.walsh.springwebapps.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ie.walsh.springwebapps.data.User;
import ie.walsh.springwebapps.interfaces.UserRepository;

@Repository
public class JdbcUserLink implements UserRepository {

	private JdbcOperations jdbc;
	
	@Autowired
	public JdbcUserLink(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}
	
	public User saveUser(User User) {
		jdbc.update(
		"insert into Users (username, password, first_name, last_name, email)" +
		" values (?, ?, ?, ?, ?)",
		User.getUsername(),
		User.getPassword(),
		User.getFirstName(),
		User.getLastName(),
		User.getEmail());
		return User;
	}
	
	public User findByUsername(String username) {
		return jdbc.queryForObject(
			"select id, username, null, first_name, last_name, email from Users where username=?", 
			new UserRowMapper(), 
			username
		);
	}
	  
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
