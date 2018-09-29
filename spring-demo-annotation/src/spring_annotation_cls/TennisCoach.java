package spring_annotation_cls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import spring_annotation_int.Coach;
import spring_annotation_int.FortuneService;

@Component
//@Lazy
//@Scope("prototype")
public class TennisCoach implements Coach {

	// field injection approach, no need of instantiation
	@Autowired
	//@Qualifier
	@Qualifier("fileFortuneService")
	private FortuneService fortune;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public TennisCoach() {
		super();
		System.out.println("Tenniscoach: inside default constructor");
	}
	
	// constructor injection: autowired
	/*@Autowired
	public TennisCoach(FortuneService fortune) {
		super();
		this.fortune=fortune;
		System.out.println("Tenniscoach: inside param constructor");
	}*/
	
	//constructor injection: @autowired+@qualifier
	//@Autowired
	public TennisCoach(FortuneService fortune) {
		super();
		this.fortune=fortune;
		System.out.println("Tenniscoach: inside param constructor using @autowired and @ qualifier");
	}
	
	//setter injection: autowired
	/*@Autowired
	public void setFortuneService(FortuneService fortune) {
		this.fortune=fortune;
		System.out.println("tenniscoach: inside setFortuneservice method");
	}*/
	
	// autowired injection on any method name. 
	/*@Autowired
	public void anyMethodName(FortuneService fortune) {
		this.fortune=fortune;
		System.out.println("tenniscoach: inside anyMethodName method");
	}*/

	@Override
	public String getDailyWorkout() {
		
		return "tenniscoach: inside getdailyworkout method";
	}

	
	@Override
	public String getDailyFortune() {
		
		return fortune.getFortune();
	}

}
 