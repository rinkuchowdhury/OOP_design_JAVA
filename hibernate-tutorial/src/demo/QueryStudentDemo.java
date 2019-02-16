package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction			
			session.beginTransaction();
			
			//query all student
			List<Student> theStudents = session.createQuery("from Student").list();
				
			// display the students
			displayStudents(theStudents);
			
			//query firstname
			System.out.println("all students");
			theStudents = session.createQuery("from Student s where s.firstName='lisa'").list();
			
			// display the students who has firstname"***"
			System.out.println("\n\n students firstname");
			displayStudents(theStudents);
			
			//query firstname "lisa" or last name "chy"
			System.out.println("\n\n students firstname or lastname");
			theStudents = session.createQuery("from Student s where"
											+ " s.firstName='lisa' OR s.lastName='chowdhury'").list();
			
			// display the students who has firstname or lastname
			displayStudents(theStudents);
			
			// query students where email like '%ymail.com'
			System.out.println("\n\n students email ends with");
			theStudents=session.createQuery("from Student s where"
											+" s.email like '%ymail.com'").list();
			
			// display the students who has email like
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done!!");
			
		}
		
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
