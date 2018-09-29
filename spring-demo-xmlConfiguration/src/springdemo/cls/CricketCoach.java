package springdemo.cls;

import springdemo.intface.Coach;
import springdemo.intface.FortuneService;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String email;
	private String team;
	
	//create no-arg constructor
	public CricketCoach() {
		System.out.println("Cric: no -arg constructor");
		
	}
	
	// setter methods_below getter methods
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println(fortuneService+" Cric: inside setFrotune method");
	}
	

	public String getEmail() {
		return "getEmail: "+email;
	}

	public void setEmail(String email) {
		System.out.println("settingEmail: ");
		this.email = email;
	}

	public String getTeam() {
		return "getTeam: "+team;
	}

	public void setTeam(String team) {
		System.out.println("settingTeam:  ");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		
		return "practice bowling";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
