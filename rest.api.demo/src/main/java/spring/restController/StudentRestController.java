package spring.restController;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	List<Student> theStudents;
	
	@PostConstruct
	public void loadStudents() {
		theStudents= new ArrayList<>();
		
		theStudents.add(new Student(1,"Rinku","Chy"));
		theStudents.add(new Student(2,"Avinash","Chy"));
		theStudents.add(new Student(3,"Anisha","Ah"));
	}
	
	// define end point for "/student" to return list of students
	@GetMapping("/student")
	public List<Student> getStudents(){
		
		return theStudents;
	}
	
	@GetMapping("/student/{studentId}") // pathVariable "studentId" has to be same as signature
	public Student getStudent(@PathVariable int studentId) {
		
		// check the studentId against list size
		if(studentId>=theStudents.size()|| (studentId<0)) {
			throw new StudentNotFoundException("Student id not found: "+studentId);
		}
		
		// just index into the list
		return theStudents.get(studentId);
	}
	
	/* removed to class "StudentRestExcutionHandler" to reuse this for many classes: global exception handling
	 * // add an exception handle using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		// create a studentErrorResponse
		StudentErrorResponse error=new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		//return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	// add another exception handle for generic purpose
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
			
		// create a studentErrorResponse
		StudentErrorResponse error=new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		//return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	*/
}
 