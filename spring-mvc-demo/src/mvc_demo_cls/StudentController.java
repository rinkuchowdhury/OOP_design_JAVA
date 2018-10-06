package mvc_demo_cls;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//inject the properties values
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	/*@Value("#{langOption}") 
	private Map<String, String> langOption;*/
	
	// add an initbinder to convert trim input strings
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		//remove leading and trailing whitespace
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		//resolve whitespace issue of all string field for the validation
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create student object
		Student theStudent=new Student();
		
		// add student object to model
		theModel.addAttribute("student",theStudent);
		
		// add country object to model
		theModel.addAttribute("theCountryOptions",countryOptions);
		
		// add country object to model
		//theModel.addAttribute("theLangOption",langOption);
		
		
		return "student-form";
	}
	@RequestMapping("/processForm")
	public String processFrom(
			@Valid @ModelAttribute("student") Student theStudent,
			BindingResult theBindResult) {
		
		//log the input data
		/*System.out.println("The Student: "+theStudent.getFirstName()+" "+
											theStudent.getLastName());
		System.out.println("The Student is from "+theStudent.getCountry());
		System.out.println("select "+theStudent.getLanguage());*/
		System.out.println("last name:|"+theStudent.getLastName()+"|");
		System.out.println("Binding result  "+theBindResult);
		if(theBindResult.hasErrors()) {
			return "student-form";
		}
		else return "student-confirmation";
	}
	
	

}
