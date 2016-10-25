package main.java.walsh.springwebapps.app;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This controller handles requests and routes data from the back-end to the front-end client view
 * @author John
 *
 */
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {
	
	@RequestMapping(method=GET)
	public String home() {
		return "home";
	}
}
