package spring_annotation_cls;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import spring_annotation_int.Coach;

@Component
public class FootballCoach implements Coach {

	public FootballCoach() {
		System.out.println("inside no-arg constructor : footballcoach");
	}
	@Override
	public String getDailyWorkout() {
		
		return "footballcoach: inside getdailyworkout method";
	}

	@Override
	public String getDailyFortune() {
		
		return "footballcoach: inside getDailyFortune method";
	}
	
	// add init mehtod
	@PostConstruct
	public void doInit() {
		System.out.println("footballcoach : inside method doInit()");
	}
	
	//add destroy method
	@PreDestroy
	public void doClean() {
		System.out.println("footballcoach : inside method doClean()");
	}

}
