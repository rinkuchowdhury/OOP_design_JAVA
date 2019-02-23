package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			// option 2: hibernate with HQL , this solution: join fetch: avoid lazy loading 
			Query<Instructor> query=session.createQuery("select i from Instructor i " 
														+ "JOIN FETCH i.courses "
														+ "where i.id=:theInstructorId ",
														Instructor.class);
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Instructor!: "+ tempInstructor);
							
			
			//commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			System.out.println("\nthe seesion is closed now\n");
			
			// HQL query has all the data
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
