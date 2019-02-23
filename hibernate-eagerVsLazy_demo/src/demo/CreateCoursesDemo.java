package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			// create some courses
			Course tempCours1 = new Course("guitar- ultimate guide");
			Course tempCours2 = new Course("piano- ultimate guide");
			
			// add the courses to instructor
			tempInstructor.add(tempCours1);
			tempInstructor.add(tempCours2);
	
			// save the courses	
			session.save(tempCours1);
			session.save(tempCours2);
				
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done: course object");
		}
		
		finally {
			
			//add clean up code
			session.close();
			factory.close();
		}
	}

}
