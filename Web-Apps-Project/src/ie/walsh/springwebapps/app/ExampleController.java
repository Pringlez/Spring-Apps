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

import ie.walsh.springwebapps.data.DataForm;
import ie.walsh.springwebapps.data.ExampleData;
import ie.walsh.springwebapps.interfaces.DataRepository;

@Controller
@RequestMapping("/example")
public class ExampleController {

	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
	
	private DataRepository dataRepository;
	
	@Autowired
	public ExampleController (DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String example(Model model) {
		model.addAttribute(dataRepository.findExamples(Long.MAX_VALUE, 20));
		return "example";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ExampleData> examples (
		@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
		@RequestParam(value="count", defaultValue="20") int count) {
		return dataRepository.findExamples(max, count);
	}

	@RequestMapping(value="/{exampleId}", method=RequestMethod.GET)
	public String example (
		@PathVariable("exampleId") long exampleId, Model model) {
		model.addAttribute(dataRepository.findOne(exampleId));
		return "example";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String saveExample(DataForm form, Model model) throws Exception {
		dataRepository.save(new ExampleData(null, form.getMessage(), new Date(), 
		form.getLongitude(), form.getLatitude()));
		return "redirect:/example";
	}
}
