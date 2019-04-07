package com.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.thymeleafdemo.entity.Employee;
import com.springboot.thymeleafdemo.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	// create a mapping for "/hello"
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		theModel.addAttribute("theDate",new java.util.Date());
		
		return "helloworld";
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		
		// get employess from DB
		List<Employee> emp=employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", emp);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Employee emp=new Employee();
		theModel.addAttribute("employee", emp);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model theModel) {
		
		// get the employee from the service
		Employee emp=employeeService.findById(id);
		
		//set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", emp);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		// save the emp
		employeeService.save(emp);
		
		//use post redirect get pattern to return list
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		//delete the employee
		employeeService.deleteById(id);
		
		return "redirect:/employees/list";
	}
	
}
