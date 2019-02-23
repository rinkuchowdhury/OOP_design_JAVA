package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.Course;
import demo.entity.Instructor;
import demo.entity.InstructorDetail;
import demo.entity.Review;
import demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			// create a course
			/*
			int id=10;
			Course tempCourse=session.get(Course.class, id);
			*/
			
			Course tempCourse = new Course("Hibernate: learn how to map");
			session.save(tempCourse);
			System.out.println("\nSaved course :"+tempCourse);
			
			/*
			// to add course to student
			int id=1;
			Student student1=session.get(Student.class, id);
			student1.addCourse(tempCourse);
			session.save(student1);
			System.out.println("\nSaved student :"+student1.getCourses());
			*/

			// create student 
			Student student1=new Student("Rinku","Chowdhury","rinku@ymail.com");
			Student student2=new Student("lisa","Schöber","lisa@ymail.com");
			
			// add students to the course
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			
			// save the students
			session.save(student1);
			session.save(student2);
			System.out.println("\nSaved student :"+tempCourse.getStudents());
			
			
			
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
