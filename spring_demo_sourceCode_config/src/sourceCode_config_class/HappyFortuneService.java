package sourceCode_config_class;

import org.springframework.stereotype.Component;

import sourceCode_config_int.FortuneService;


@Component
public class HappyFortuneService implements FortuneService {
	
	public HappyFortuneService() {
		System.out.println("happyFortuneService: no-arg constructor");
	}

	@Override
	public String getFortune() {
		
		return "today is your healty day";
	}

}
