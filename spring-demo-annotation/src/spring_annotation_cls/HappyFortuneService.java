package spring_annotation_cls;

import org.springframework.stereotype.Component;

import spring_annotation_int.FortuneService;

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
