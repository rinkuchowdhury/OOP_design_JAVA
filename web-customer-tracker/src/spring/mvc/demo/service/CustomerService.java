package spring.mvc.demo.service;

import java.util.List;

import spring.mvc.demo.entity.Customer;

public interface CustomerService {

		public List<Customer> getCustomers();

		public void saveCustomer(Customer theCustomer);

		public Customer getCustomer(int cId);

		public void deleteCustomer(int cId);

		public List<Customer> searchCustomers(String searchName);
}
