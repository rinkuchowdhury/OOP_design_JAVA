package spring_annotation_cls;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_annotation_int.Coach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
			
		// read soring config file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get bean from spring container, for default bean id: same as class with first lower case
		//Coach theCoach=context.getBean("footballCoach",Coach.class);
		//Coach alphaCoach=context.getBean("tennisCoach",Coach.class);
		
		
		//boolean result=(theCoach==alphaCoach);
		//System.out.println("the scope prototype result is : "+result);
		//System.out.println("\nthe memory location for theCoach is: "+theCoach);
		//System.out.println("\nthe memory loaction for alphaCoach is: "+alphaCoach);
		
		//call method on the bean
		//System.out.println(theCoach.getDailyWorkout());
		
		//System.out.println(theCoach.getDailyFortune());
		
		
		//close the context
		context.close();      
			
	}
}
