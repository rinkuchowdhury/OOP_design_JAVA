package spring.mvc.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.demo.entity.Customer;

@Repository // always should applied to DAO impl.
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory; // bean id="sessionFactory, line 45: spring.mvc.crud.servlet.xml 
	
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session cs=sessionFactory.getCurrentSession();
		
		// create a query & sort by last name
		Query<Customer> query=cs.createQuery("from Customer order by lastName",Customer.class);
		
		
		// execute query and get result list
		List<Customer> customers=query.getResultList();
		
		// alternate to line 30+33 in one statement 
		//List<Customer> customers=cs.createQuery("from Customer").getResultList();
		
		// return the results
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get the current hibernate session
		Session ss=sessionFactory.getCurrentSession();
		
		// save or update the customer: method from hibernate
		ss.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int cId) {
		
		// get the current hibernate session
		Session ss=sessionFactory.getCurrentSession();
		
		// retrieve/read from DB using the primary key
		Customer theCustomer=ss.get(Customer.class, cId);
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int cId) {
		
		// get the current session
		Session ss=sessionFactory.getCurrentSession();
		
		// delete customer from DB with HQl
		// another approach by adding convenience delete method on Customer class
		Query query=ss.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", cId);
		query.executeUpdate();
	}


	@Override
	public List<Customer> searchCustomersByName(String searchName) {
		
		// get the current session
		Session ss=sessionFactory.getCurrentSession();
		
		// search customer in DB but only search by name if searchName !empty
		
		Query query=null;
		
		//logic clause added in service class, not a good practise to add here
		//if(theSearchName !=null && theSearchName.trim().length()>0) {

            // search for firstName or lastName ... case insensitive
		query =ss.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
        	query.setParameter("theName", "%" + searchName.toLowerCase() + "%");
        	
		//}
		//else {
			// searchName is empty ... so just get all customers
			//query=ss.createQuery("from Customer",Customer.class);
			
		//}
		
		 // execute query and get result list
		List<Customer> customers= query.getResultList();
                
        // return the results        
        return customers;
        
		
	}

}
