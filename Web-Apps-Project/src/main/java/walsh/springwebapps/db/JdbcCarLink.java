package main.java.walsh.springwebapps.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.walsh.springwebapps.data.Car;
import main.java.walsh.springwebapps.interfaces.CarRepository;

/**
 * This class handles car related interactions with the database
 * @author John
 *
 */
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

	public List<Car> findCars(long maxValue, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where id < ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), maxValue, limit);
	}

	public Car findCarById(long id) {
		return jdbc.queryForObject(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where id = ?",
		new CarRowMapper(), id);
	}
	
	@Override
	public List<Car> findCarsByMake(String make, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where make = ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), make, limit);
	}

	@Override
	public List<Car> findCarsByModel(String model, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where model = ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), model);
	}

	@Override
	public List<Car> findCarsByColor(String color, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where color = ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), color);
	}

	@Override
	public List<Car> findCarsByMileage(int minMileage, int maxMileage, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where mileage >= ? and <= ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), minMileage, maxMileage, limit);
	}

	@Override
	public List<Car> findCarsByYear(int minYear, int maxYear, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where year >= ? and <= ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), minYear, maxYear, limit);
	}

	@Override
	public List<Car> findCarsByEngineSize(int minEngSize, int maxEngSize, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where engine_size >= ? and <= ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), minEngSize, maxEngSize, limit);
	}

	@Override
	public List<Car> findCarsByFuelType(String fuelType, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where fuel_type = ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), fuelType, limit);
	}

	@Override
	public List<Car> findCarsByPrice(int minPrice, int maxPrice, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where price >= ? and <= ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), minPrice, maxPrice, limit);
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
