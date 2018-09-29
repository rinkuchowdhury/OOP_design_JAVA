package spring_annotation_cls;

import java.util.Random;

import org.springframework.stereotype.Component;

import spring_annotation_int.FortuneService;

//@Component("random")
@Component
public class RandomFortuneService implements FortuneService {

private String[] fortune= {"healthy day", "lucky day", "good day"};
	
	// create a random number generator
	private Random random=new Random();
	public RandomFortuneService() {
		System.out.println("RandomFortuneService: no-arg constructor");
	}
	

	@Override
	public String getFortune() {
		int index=random.nextInt(fortune.length);
		
		return fortune[index];
	}


}
