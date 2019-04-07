package com.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.springboot.thymeleafdemo.entity.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired 
	private EmployeeRepository employeeRepository;
	
	
	@Override
	@Transactional // if all has @Transactional then can be use in class
	public List<Employee> findAll() {
	
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee emp=null;
		
		if(result.isPresent()) {
			emp=result.get();
		}
		else {
			// employee not found in DB
			throw new RuntimeException("Did not find employee id- "+ id);
		}
		return emp;
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		
		employeeRepository.save(emp);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		employeeRepository.deleteById(id);

	}

}
