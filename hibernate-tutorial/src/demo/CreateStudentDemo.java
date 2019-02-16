package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		

		try {
			// create a student object
			System.out.println("creating new student object");
			Student tempStudent1 = new Student("Avi", "chowdhury", "avinash@ymail.com");
			
			// create 2 student object
			Student tempStudent2 = new Student("Lisa", "schober", "lisa@ymail.com");
			Student tempStudent = new Student("nisha", "ahmed", "nisha@ymail.com");
			
			// start a transaction			
			session.beginTransaction();

			// save the student object to check primary key auto-increment in mysql
			System.out.println("saving student object : "+tempStudent.getId());
		
			session.save(tempStudent);
		
			System.out.println("after saving student object : "+tempStudent.getId());
			
				
			//commit transaction
			session.getTransaction().commit();
			System.out.println("after commiting student object : "+tempStudent.getId());
			
			System.out.println("done: student object");
		}
		
		finally {
			factory.close();
		}
	}

}
