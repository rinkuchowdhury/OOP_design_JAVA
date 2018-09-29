package sourceCode_config_class;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sourceCode_config_int.Coach;

public class SourceDemoApp {

	public static void main(String[] args) {
			
		// read soring config file
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get bean from spring container, for default bean id: same as class with first lower case
		//SwimCoach theCoach=context.getBean("swimCoach",SwimCoach.class);
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		
		
		//boolean result=(theCoach==alphaCoach);
		//System.out.println("the scope prototype result is : "+result);
		//System.out.println("\nthe memory location for theCoach is: "+theCoach);
		//System.out.println("\nthe memory loaction for alphaCoach is: "+alphaCoach);
		
		//call method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//call getter method: for properties value
		//System.out.println("email "+theCoach.getEmail());
		//System.out.println("team "+theCoach.getTeam());
		
		//close the context
		context.close();      
			
	}
}
