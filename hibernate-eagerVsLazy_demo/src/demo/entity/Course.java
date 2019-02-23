package demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	//define the fields
	// annotate fields
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, // req: if course remove  
							CascadeType.DETACH, CascadeType.REFRESH}) // dont remove instructor
	
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	//define the constructors
	public Course() {
		
	}
	public Course(String title) {
		this.title = title;
	}
	
	//define the getter setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	//define toString
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	

}