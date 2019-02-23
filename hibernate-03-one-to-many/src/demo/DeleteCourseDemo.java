package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Student;

public class DeleteCourseDemo {

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

			// get the course
			int theId=2;
			Course tempCourse = session.get(Course.class, theId);
			
			// delete the course
			System.out.print("deleting course: "+ tempCourse);
			session.delete(tempCourse);
				
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done!");
			
		}
		
		finally {
			//add clean up code
			session.close();
			factory.close();
		}
	}

}
