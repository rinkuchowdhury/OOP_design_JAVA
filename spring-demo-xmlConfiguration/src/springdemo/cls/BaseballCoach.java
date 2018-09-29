package springdemo.cls;

import springdemo.intface.Coach;
import springdemo.intface.FortuneService;

public class BaseballCoach implements Coach {
	
	//define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for DI
	public BaseballCoach (FortuneService theFortuneService) {
		
		fortuneService= theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Spend 30 mins on batting practice";
	}
	
	@Override
	public String getDailyFortune() {
		
		// use my fortune service to get a fortune
		return fortuneService.getFortune();
	}
}

