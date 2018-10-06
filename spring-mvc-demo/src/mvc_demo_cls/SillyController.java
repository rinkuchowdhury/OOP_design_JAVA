package mvc_demo_cls;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// Parent Mapping : directory/sub-directory
@RequestMapping("/hello")
public class SillyController {

	// Binding request param to variable
	@RequestMapping("/processFormVersionThree") // sub relative to hello directory
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
