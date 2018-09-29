package sourceCode_config_class;

import sourceCode_config_int.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "sad: You are not alone";
	}

}
