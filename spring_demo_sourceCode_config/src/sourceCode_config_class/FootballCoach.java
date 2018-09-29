package sourceCode_config_class;

import org.springframework.stereotype.Component;

import sourceCode_config_int.Coach;


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
	
	

}
