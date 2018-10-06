package mvc_demo_cls;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// need a controller method to show the initial html form
	@RequestMapping("/showForm")
	public String showFrom() {
		return "helloworld-form";
	}
	
	// need a controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read form data 
	// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String modelMethod(HttpServletRequest request, Model model){
		
		// read the request parameter from the HTML form
		String theName=request.getParameter("studentName"); 
		
		// convert the data to all caps
		theName=theName.toUpperCase();
		
		// create the message
		String result = "Yo! "+ theName;
		
		// add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	// Binding request param to variable
	@RequestMapping("/processFormVersionThree")
	public String modelMethod(@RequestParam("studentName") String theName, Model model){
		
		// convert the data to all caps
		theName=theName.toUpperCase();
		
		// create the message
		String result = "Three! "+ theName;
		
		// add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
