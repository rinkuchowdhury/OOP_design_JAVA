package spring.mvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.mvc.demo.entity.Customer;
import spring.mvc.demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the CustomerService
	// this will scan the component that impl. CustomerService interface
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get the customers from the Service
		List<Customer> theCustomers=customerService.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd") // this is displayed url:following method name need not Identical 
	public String showFormForAdd(Model theModel){
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using customer service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int cId, Model theModel) {
		
		// get the customer from the service
		Customer cs=customerService.getCustomer(cId);
		
		// set customer as a model arrtribute to prepopulate the form
		// attribute "customer" has to be same as form name (like as 49): line 26 in customer-form.jsp
		theModel.addAttribute("customer", cs); 
		
		// send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int cId) {
		
		// delete customer from the Service
		customerService.deleteCustomer(cId);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String theSearchName,Model theModel) {
		
		// search customer the Service
		List<Customer> theCustomers=customerService.searchCustomers(theSearchName);
		
		// add the customer to the model
		// attribute "customers" has to be same as form name (like as 33): line 47 in list-customers.jsp
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}

}
