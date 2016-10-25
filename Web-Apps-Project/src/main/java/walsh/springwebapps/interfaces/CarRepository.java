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
	public List<Car> findCars(long maxValue, int i);
	public Car findCarById(long carId);
	public void saveCar(Car car);
}
