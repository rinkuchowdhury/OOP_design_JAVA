package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		

		try {
			
			// start a transaction			
			session.beginTransaction();
			
			// get the a course
			int id=16;
			Course tempCourse=session.get(Course.class, id);
			
			// print course
			System.out.println("Couse is : "+tempCourse);
			
			// print course wih reviews
			System.out.println("reviews are : "+tempCourse.getReviews());
			
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
