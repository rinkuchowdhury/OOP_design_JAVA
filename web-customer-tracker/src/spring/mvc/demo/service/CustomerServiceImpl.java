package spring.mvc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.demo.dao.CustomerDAO;
import spring.mvc.demo.entity.Customer;

@Service 
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	// this will scan the component that impl. CustomerDAO interface
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional // to do auto session transaction, start/end of session 
	public List<Customer> getCustomers() {
	
		return customerDAO.getCustomers();
	}
	
	@Override
	@Transactional // to do auto session transaction, start/end of session
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional // to do auto session transaction, start/end of session
	public Customer getCustomer(int cId) {
		
		return customerDAO.getCustomer(cId);
	}

	@Override
	@Transactional // to do auto session transaction, start/end of session
	public void deleteCustomer(int cId) {
		
		customerDAO.deleteCustomer(cId);
	}

	@Override
	@Transactional // to do auto session transaction, start/end of session
	public List<Customer> searchCustomers(String searchName) {
		
		// search customer through DAO by name if searchName !empty
		if(searchName !=null && searchName.trim().length()>0) {
			return customerDAO.searchCustomersByName(searchName);
		}
		// searchName is empty ... so just get all customers
		else { 
			return customerDAO.getCustomers();
		}
	}

}
