package test.java.walsh.springwebapps;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import main.java.walsh.springwebapps.app.CarController;
import main.java.walsh.springwebapps.data.Car;
import main.java.walsh.springwebapps.interfaces.CarRepository;

/**
 * This class tests the functionality of the car controller
 * @author John
 *
 */
public class CarControllerTest {

	//@Test
	public void shouldShowRecentExamples() throws Exception {
		List<Car> expectedCars = createCarList(20);
		CarRepository mockRepository = mock(CarRepository.class);
		
		when(mockRepository.findCars(Long.MAX_VALUE, 20)).thenReturn(expectedCars);
		
		CarController controller = new CarController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/cars.jsp")).build();
		
		mockMvc.perform(get("/cars"))
		.andExpect(view().name("cars"))
		.andExpect(model().attributeExists("carsList"))
		.andExpect(model().attribute("carsList", hasItems(expectedCars.toArray())));
	}
	
	private List<Car> createCarList(int count) {
		List<Car> carData = new ArrayList<Car>();
		for (int i=0; i < count; i++) {
			carData.add(new Car("Car " + i, "Car " + i, new Date()));
		}
		return carData;
	}
}
