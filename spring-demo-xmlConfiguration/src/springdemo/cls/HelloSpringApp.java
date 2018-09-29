package springdemo.cls;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springdemo.intface.Coach;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		/* Coach myCoach = new TrackCoach(myFortune);
		 * */
		/*CricketCoach theCoach = context.getBean("myCricCoach",CricketCoach.class);
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());*/
		
		// for lifecycle method , init + destroy
		Coach theCoach = context.getBean("myCoach",Coach.class);
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		 
		// close the context
		context.close();
		
	}

}
