package ie.walsh.springwebapps.test;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import ie.walsh.springwebapps.app.ExampleController;
import ie.walsh.springwebapps.data.ExampleData;
import ie.walsh.springwebapps.interfaces.DataRepository;

public class ExampleControllerTest {

	@Test
	public void shouldShowRecentExamples() throws Exception {
		List<ExampleData> expectedExample = createExampleList(20);
		DataRepository mockRepository = mock(DataRepository.class);
		
		when(mockRepository.findExamples(Long.MAX_VALUE, 20)).thenReturn(expectedExample);
		
		ExampleController controller = new ExampleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/example.jsp")).build();
		
		mockMvc.perform(get("/example"))
		.andExpect(view().name("example"))
		.andExpect(model().attributeExists("exampleList"))
		.andExpect(model().attribute("exampleList", hasItems(expectedExample.toArray())));
	}
	
	private List<ExampleData> createExampleList(int count) {
		List<ExampleData> exampledata = new ArrayList<ExampleData>();
		for (int i=0; i < count; i++) {
			exampledata.add(new ExampleData("Example " + i, new Date()));
		}
		return exampledata;
	}
}
