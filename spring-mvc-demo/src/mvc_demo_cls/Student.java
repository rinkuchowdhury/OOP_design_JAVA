package mvc_demo_cls;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import mvc_demo_int_validation.CourseCode;


public class Student {
	private String firstName;
	
	//add validation rule for this field
	@NotNull(message="required")
	@Size(min=1, message="is required")
	private String lastName;
	
	//add validation rule for this field
	@NotNull(message="required")
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=10, message="must be less than or equal to 10")
	private Integer freePasses;
	
	//add validation rule for this field: regular expression
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
	private String postalCode;
	
	// custom annotation
	@CourseCode (value="IOC", message="must start with IOC")
	private String courseCode;
	
	private String country;
	private String language;
	private String[] os;
	private LinkedHashMap<String,String> languageOption;
	private LinkedHashMap<String,String> osOption;
	

	public Student() {
		
		// populate favorite language options
		languageOption = new LinkedHashMap<>();

        // parameter order: value, display label
		languageOption.put("Java", "Java");
		languageOption.put("C#", "C#");
		languageOption.put("PHP", "PHP");
		languageOption.put("Ruby", "Ruby"); 
		
		// populate favorite os options
		osOption = new LinkedHashMap<>();

        // parameter order: value, display label
		osOption.put("Linux", "linux");
		osOption.put("MAC OS", "MAC");
		osOption.put("Windows", "windows");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public LinkedHashMap<String, String> getLanguageOption() {
		return languageOption;
	}


	public LinkedHashMap<String, String> getosOption() {
		return osOption;
	}

	public void setosOption(LinkedHashMap<String, String> osOption) {
		this.osOption = osOption;
	}

	public String[] getOs() {
		return os;
	}

	public void setOs(String[] os) {
		this.os = os;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/*public LinkedHashMap<String, String> getCountryOption() {
		return countryOption;
	}
	*/

	
}
