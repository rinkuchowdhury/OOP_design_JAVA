package springdemo.cls;

import java.util.Random;

import springdemo.intface.FortuneService;

public class HappyFortuneService implements FortuneService{
	
	private String[] fortune= {"healthy day", "lucky day", "good day"};
	
	// cretae a random number generator
	private Random random=new Random();
	

	@Override
	public String getFortune() {
		int index=random.nextInt(fortune.length);
		
		return fortune[index];
	}

}
