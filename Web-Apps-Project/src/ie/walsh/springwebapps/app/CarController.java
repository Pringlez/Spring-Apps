package ie.walsh.springwebapps.app;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ie.walsh.springwebapps.data.Car;
import ie.walsh.springwebapps.data.CarForm;
import ie.walsh.springwebapps.interfaces.CarRepository;

@Controller
@RequestMapping("/cars")
public class CarController {

	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
	
	private CarRepository dataRepository;
	
	@Autowired
	public CarController (CarRepository dataRepository) {
		this.dataRepository = dataRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Car> cars (
		@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
		@RequestParam(value="count", defaultValue="20") int count) {
		return dataRepository.findCars(max, count);
	}

	@RequestMapping(value="/{carId}", method=RequestMethod.GET)
	public String car (
		@PathVariable("carId") long carId, Model model) {
		model.addAttribute(dataRepository.findCarById(carId));
		return "car";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String saveCar(CarForm form, Model model) throws Exception {
		dataRepository.saveCar(new Car(null, form.getMake(), form.getModel(), new Date()));
		return "redirect:/cars";
	}
}
