package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;
import demo.entity.Student;

public class GetCoursesForRinkuDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		

		try {
			
			// start a transaction			
			session.beginTransaction();
			
			// get student rinku from database
			int id=1;
			Student student1=session.get(Student.class, id);
			System.out.println("\nload student: "+student1);
			System.out.println("\n courses: "+student1.getCourses());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done:");
		}
		
		finally {
			
			//add clean up code
			session.close();
			factory.close();
		}
	}

}
