package sourceCode_config_class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sourceCode_config_int.Coach;
import sourceCode_config_int.FortuneService;


@Component
//@Lazy
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	public TennisCoach() {
		super();
		System.out.println("Tenniscoach: inside default constructor");
	}
	public TennisCoach(FortuneService thefortune) {
		this.fortuneService=thefortune;
		System.out.println("Tenniscoach: inside arg:fortune constructor");
	}

	@Override
	public String getDailyWorkout() {
		
		return "tenniscoach: inside getdailyworkout method";
	}

	
	@Override
	public String getDailyFortune() {
		
		return "tenniscoach: inside getdailyfortune method "+fortuneService.getFortune();
	}

}
 