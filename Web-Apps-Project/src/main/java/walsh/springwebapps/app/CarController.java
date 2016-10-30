package main.java.walsh.springwebapps.app;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.walsh.springwebapps.data.Car;
import main.java.walsh.springwebapps.data.CarForm;
import main.java.walsh.springwebapps.interfaces.CarRepository;

/**
 * This controller handles requests and routes data from the back-end to the front-end client view
 * @author John
 *
 */
@Controller
@RequestMapping("/cars")
public class CarController {

	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
	
	private CarRepository carRepository;
	
	@Autowired
	public CarController (CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Car> cars (
		@RequestParam(value="maxValue", defaultValue=MAX_LONG_AS_STRING) long maxValue,
		@RequestParam(value="limit", defaultValue="20") int limit) {
		return carRepository.findCars(maxValue, limit);
	}

	@RequestMapping(value="/{carId}", method=RequestMethod.GET)
	public String car (
		@PathVariable("carId") long carId, Model model) {
		model.addAttribute(carRepository.findCarById(carId));
		return "car";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String saveCar(CarForm form, Model model) throws Exception {
		carRepository.saveCar(new Car(0, form.getMake(), form.getModel(), form.getColor(), 
				form.getMileage(), form.getYear(), form.getEngineSize(), form.getFuelType(), form.getDescription(), form.getPrice(), new Date()));
		return "redirect:/cars";
	}
}
