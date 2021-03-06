package demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	
	//define fields and annotate: map to database column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	
	// define constructor
	public Review() {
		
	}


	public Review(String comment) {
		this.comment = comment;
	}

	// define getter/setter 
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}

	// define toString : to have log file info
	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}

}
