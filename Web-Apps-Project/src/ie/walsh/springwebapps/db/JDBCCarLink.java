package ie.walsh.springwebapps.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ie.walsh.springwebapps.data.Car;
import ie.walsh.springwebapps.interfaces.CarRepository;

@Repository
public class JdbcCarLink implements CarRepository {

	private JdbcOperations jdbc;

	@Autowired
	public JdbcCarLink(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}

	public List<Car> findRecentCars() {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" order by created_at desc limit 20",
		new CarRowMapper());
	}

	public List<Car> findCars(long max, int count) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where id < ?" +
			" order by created_at desc limit 20",
		new CarRowMapper(), max);
	}

	public Car findCarById(long id) {
		return jdbc.queryForObject(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where id = ?",
		new CarRowMapper(), id);
	}

	public void saveCar(Car car) {
		jdbc.update(
			"insert into Cars (make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at)" +
			" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
			car.getMake(),
			car.getModel(),
			car.getColor(),
			car.getMileage(),
			car.getYear(),
			car.getEngineSize(),
			car.getFuelType(),
			car.getDescription(),
			car.getPrice(),
			car.getTime()
		);
	}

	private static class CarRowMapper implements RowMapper<Car> {
		public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Car(
				rs.getLong("id"),
				rs.getString("make"),
				rs.getString("model"),
				rs.getString("color"),
				rs.getInt("mileage"),
				rs.getShort("year"),
				rs.getInt("engineSize"),
				rs.getString("fuelType"),
				rs.getString("description"),
				rs.getInt("price"),
				rs.getDate("created_at")
			);
		}
	}
}
