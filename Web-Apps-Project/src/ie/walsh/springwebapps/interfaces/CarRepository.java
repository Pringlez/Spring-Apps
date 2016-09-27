package ie.walsh.springwebapps.interfaces;

import java.util.List;

import ie.walsh.springwebapps.data.Car;

public interface CarRepository {
	public List<Car> findRecentCars();
	public List<Car> findCars(long maxValue, int i);
	public Car findCarById(long carId);
	public void saveCar(Car car);
}
