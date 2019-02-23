package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		

		try {
			
			// start a transaction			
			session.beginTransaction();
			
			// get the instructor from db
			int theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Instructor!: "+ tempInstructor);
			
			//option 1: call getter method while session is open. 
			//get courses for the instructor
			System.out.println("Course!: "+ tempInstructor.getCourses());
						
			// close the session to see Lazy retrieving behaviour: will throw LazyInitializationException 
			//commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			// since the courses are lazy loaded ... this will fail 
			// get course for the instructor : if below line exist before session.close then no exception
			System.out.println("Course!: "+ tempInstructor.getCourses());
				
			
			
			System.out.println("done!");
		}
		
		finally {
			
			//add clean up code
			session.close();
			factory.close();
		}
	}

}
