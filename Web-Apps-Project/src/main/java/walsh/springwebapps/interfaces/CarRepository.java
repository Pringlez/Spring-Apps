package main.java.walsh.springwebapps.interfaces;

import java.util.List;

import main.java.walsh.springwebapps.data.Car;

/**
 * The car repository interface to be implemented
 * @author John
 *
 */
public interface CarRepository {
	public List<Car> findRecentCars();
	public List<Car> findCars(long maxValue, int limit);
	public Car findCarById(int carId);
	public List<Car> findCarsByMake(String make, int limit);
	public List<Car> findCarsByModel(String model, int limit);
	public List<Car> findCarsByColor(String color, int limit);
	public List<Car> findCarsByMileage(int minMileage, int maxMileage, int limit);
	public List<Car> findCarsByYear(int minYear, int maxYear, int limit);
	public List<Car> findCarsByEngineSize(int minEngSize, int maxEngSize, int limit);
	public List<Car> findCarsByFuelType(String fuelType, int limit);
	public List<Car> findCarsByPrice(int minPrice, int maxPrice, int limit);
	public void saveCar(Car car);
}
