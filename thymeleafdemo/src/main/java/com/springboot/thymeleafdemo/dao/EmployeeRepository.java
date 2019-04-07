package com.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.thymeleafdemo.entity.Employee;


//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// no need to write for crud : beauty of spring data JPA
	
	// add method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();

}
