package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class deleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();

		try {
			int studentId=1;
			
			// start a transaction	
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting Student with id: "+ studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("\ncurrent student: "+myStudent);
			
			//Updating student name
			System.out.println("Updating.....");
			myStudent.setFirstName("Avinash");

			//commit transaction
			session.getTransaction().commit();
			System.out.println("\nupdated student: "+myStudent);
			
			//new session to update all email
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			System.out.println("updating all email id");
			session.createQuery("update Student set email='foooo@gmail.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("\nupdated student email: "+myStudent.getEmail()); // retrieved not updated value
			
			
			
		}
		
		finally {
			factory.close();
		}
	}

}
