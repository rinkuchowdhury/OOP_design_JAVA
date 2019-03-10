package spring.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestControllerDemo {

	// method for "hello" endpoint
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello API";
	}
}
