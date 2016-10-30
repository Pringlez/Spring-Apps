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

	/**
	 * Find recently added cars using the JDBC interface
	 */
	public List<Car> findRecentCars() {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" order by created_at desc limit 20",
		new CarRowMapper());
	}

	/**
	 * Find cars by id within a certain range and limit using the JDBC interface
	 */
	public List<Car> findCars(long maxValue, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where id < ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), maxValue, limit);
	}

	/**
	 * Find a car record by the 'id' field using the JDBC interface
	 */
	public Car findCarById(long id) {
		return jdbc.queryForObject(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where id = ?",
		new CarRowMapper(), id);
	}
	
	/**
	 * Find car records by the 'make' field using the JDBC interface
	 */
	@Override
	public List<Car> findCarsByMake(String make, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where make = ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), make, limit);
	}

	/**
	 * Find car records by the 'model' field using the JDBC interface
	 */
	@Override
	public List<Car> findCarsByModel(String model, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where model = ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), model);
	}

	/**
	 * Find car records by the 'color' field using the JDBC interface
	 */
	@Override
	public List<Car> findCarsByColor(String color, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where color = ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), color);
	}

	/**
	 * Find car records by the 'mileage' field using the JDBC interface
	 */
	@Override
	public List<Car> findCarsByMileage(int minMileage, int maxMileage, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where mileage >= ? and <= ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), minMileage, maxMileage, limit);
	}

	/**
	 * Find car records by the 'year' field using the JDBC interface
	 */
	@Override
	public List<Car> findCarsByYear(int minYear, int maxYear, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where year >= ? and <= ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), minYear, maxYear, limit);
	}

	/**
	 * Find car records by the 'engine_size' field using the JDBC interface
	 */
	@Override
	public List<Car> findCarsByEngineSize(int minEngSize, int maxEngSize, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where engine_size >= ? and <= ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), minEngSize, maxEngSize, limit);
	}

	/**
	 * Find car records by the 'fuel_type' field using the JDBC interface
	 */
	@Override
	public List<Car> findCarsByFuelType(String fuelType, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where fuel_type = ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), fuelType, limit);
	}

	/**
	 * Find car records by the 'price' field using the JDBC interface
	 */
	@Override
	public List<Car> findCarsByPrice(int minPrice, int maxPrice, int limit) {
		return jdbc.query(
			"select id, make, model, color, mileage, year, engine_size, fuel_type, description, price, created_at" +
			" from Cars" +
			" where price >= ? and <= ?" +
			" order by created_at desc limit ?",
		new CarRowMapper(), minPrice, maxPrice, limit);
	}

	/**
	 * Save car record using the JDBC interface
	 */
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
				rs.getInt("id"),
				rs.getString("make"),
				rs.getString("model"),
				rs.getString("color"),
				rs.getInt("mileage"),
				rs.getShort("year"),
				rs.getInt("engine_size"),
				rs.getString("fuel_type"),
				rs.getString("description"),
				rs.getInt("price"),
				rs.getDate("created_at")
			);
		}
	}
}
