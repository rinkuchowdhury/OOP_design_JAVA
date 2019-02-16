package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();

		try {
			// read student object
			System.out.println("creating new student object");
			Student tempStudent = new Student("lisa", "schöber", "lisa@gmail.com");

			// start a transaction			
			session.beginTransaction();

			// save the student object to check primary key auto-increment in mysql
			System.out.println("saving student object : "+tempStudent.getId());
			session.save(tempStudent);
			System.out.println("after saving student object : "+tempStudent.getId());

			//commit transaction
			session.getTransaction().commit();
			
			//find out student's id
			System.out.println("after commiting student object : "+tempStudent.getId());
			
			// get a new session & start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id : primary key
			System.out.println("\nGetting student's id: " + tempStudent.getId());
			Student myStudent=session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete: "+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("done: student object");
		}
		
		finally {
			factory.close();
		}
	}

}
