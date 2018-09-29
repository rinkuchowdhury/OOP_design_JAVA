package sourceCode_config_class;

import org.springframework.beans.factory.annotation.Value;

import sourceCode_config_int.Coach;
import sourceCode_config_int.FortuneService;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	public SwimCoach(FortuneService theFortuneService) {
		super();
		this.fortuneService = theFortuneService;
		System.out.println("SwimCoach: inside arg:fortuneService constructor");
	}

	@Override
	public String getDailyWorkout() {
		
		return "SwimCoach: inside getDailyWorkout";
	}

	@Override
	public String getDailyFortune() {
		
		return "SwimCoach: inside getDailyFortune"+fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
}
