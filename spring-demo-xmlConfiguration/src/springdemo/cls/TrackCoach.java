package springdemo.cls;

import springdemo.intface.Coach;
import springdemo.intface.FortuneService;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	

	

	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
		System.out.println("inside trackcoack(myfortune)");
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just do it :"+fortuneService.getFortune();
	}
	
	// add init mehtod
	public void doInit() {
		System.out.println("trackCoach : inside method doInit()");
	}
	
	//add destroy method
	public void doClean() {
		System.out.println("trackCoach : inside method doClean()");
	}

}
