package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			
			// create a course
			/*int id=16;
			Course tempCourse=session.get(Course.class, id);*/
			Course tempCourse = new Course("Spring: learn how to code");
			
			// add some reviews
			Review review=new Review();
			review.setComment("remember:");
			tempCourse.addReview(new Review(review.getComment()+"Great course "));
			tempCourse.addReview(new Review(review.getComment()+"very long content "));

			
			// save the course and cascade all reviews
			System.out.println("saved the course with reviews");
			System.out.println("course is : "+tempCourse);
			System.out.println("reviews are : "+tempCourse.getReviews());
			
			session.save(tempCourse);
			
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
