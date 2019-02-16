package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class updateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();

		try {
			int studentId=2;
			
			// start a transaction	
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting Student with id: "+ studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("\ncurrent student: "+myStudent);
			
			session.delete(myStudent);

			//commit transaction
			session.getTransaction().commit();
			System.out.println("\ndeleted student: "+myStudent);	
			
			// new transaction	
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// query delete approach
			System.out.println("\ndeleting....");	
			session.createQuery("delete from Student where id=101").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("\ndeleted ");
			
		}
		
		finally {
			factory.close();
		}
	}

}
